package ca.queensu.cs.mase.interpreter.dispatchers;

import java.lang.reflect.Method;
import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.PolymorphicDispatcher;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

import ca.queensu.cs.mase.interpreter.OppositeFinder;
import ca.queensu.cs.mase.interpreter.OppositeFinder.ConnectorException;
import ca.queensu.cs.mase.interpreter.data.CapsuleContext;
import ca.queensu.cs.mase.interpreter.data.CapsuleContextPortPair;
import ca.queensu.cs.mase.types.Bool;
import ca.queensu.cs.mase.types.Int;
import ca.queensu.cs.mase.types.Value;
import ca.queensu.cs.mase.urml.Assignable;
import ca.queensu.cs.mase.urml.Assignment;
import ca.queensu.cs.mase.urml.Attribute;
import ca.queensu.cs.mase.urml.ConcatenateExpression;
import ca.queensu.cs.mase.urml.Expression;
import ca.queensu.cs.mase.urml.IfStatement;
import ca.queensu.cs.mase.urml.IfStatementOperation;
import ca.queensu.cs.mase.urml.InformTimer;
import ca.queensu.cs.mase.urml.Invoke;
import ca.queensu.cs.mase.urml.LocalVar;
import ca.queensu.cs.mase.urml.LogStatement;
import ca.queensu.cs.mase.urml.NoOp;
import ca.queensu.cs.mase.urml.Port;
import ca.queensu.cs.mase.urml.ReturnStatement;
import ca.queensu.cs.mase.urml.SendTrigger;
import ca.queensu.cs.mase.urml.Statement;
import ca.queensu.cs.mase.urml.StatementOperation;
import ca.queensu.cs.mase.urml.StringExpression;
import ca.queensu.cs.mase.urml.TimerPort;
import ca.queensu.cs.mase.urml.Trigger_out;
import ca.queensu.cs.mase.urml.UrmlFactory;
import ca.queensu.cs.mase.urml.Variable;
import ca.queensu.cs.mase.urml.WhileLoop;
import ca.queensu.cs.mase.urml.WhileLoopOperation;
import ca.queensu.cs.mase.util.MessageDesc;
import ca.queensu.cs.mase.util.ReturnStatementSignal;
import ca.queensu.cs.mase.util.UrmlInterruptedException;

@SuppressWarnings("unused")
public class StatementExecuter {
	private static PolymorphicDispatcher<Void> stmtExecDispatcher = PolymorphicDispatcher
			.createForSingleTarget("compute", 2, 3, new StatementExecuter());

	/**
	 * Execute the statement {@code st} based on the environment from the
	 * capsule context {@code ctx}
	 * 
	 * @param st
	 * @param ctx
	 * @
	 */
	public static void interpret(Statement st, CapsuleContext ctx)
			 {
		if (Thread.currentThread().isInterrupted())
			throw new UrmlInterruptedException();
		stmtExecDispatcher.invoke(st, ctx);
	}

	// operation-specific statements

	public static void interpret(StatementOperation st, CapsuleContext ctx)
			 {
		if (Thread.currentThread().isInterrupted())
			throw new UrmlInterruptedException();
		stmtExecDispatcher.invoke(st, ctx);
	}

	// public static void interpret(Statement st, CapsuleContext ctx,
	// boolean shouldStop) {
	// if (shouldStop)
	// return;
	// else
	// interpret(st, ctx);
	// }
	//
	// public static void interpret(StatementOperation st, CapsuleContext ctx,
	// boolean shouldStop) {
	// if (shouldStop)
	// return;
	// else
	// interpret(st,ctx);
	// }

	/**
	 * Get the line number where the EObject {@code obj} appears in the parsed
	 * file
	 * 
	 * @param obj
	 * @return the line number of the parsed {@code obj}; if not found, -1
	 */
	private static int getLineNumber(EObject obj) {
		if (obj == null)
			return -1;
		ICompositeNode node = NodeModelUtils.getNode(obj);
		if (node == null)
			return -1;
		return node.getStartLine();
	}

	private void compute(SendTrigger st, CapsuleContext ctx)
			 {
		for (Trigger_out to : st.getTriggers()) {
			try {
				CapsuleContextPortPair opposite = OppositeFinder
						.findOppositeCapsule(ctx, to.getTo());
				CapsuleContext target = opposite.getCapsuleCtx();
				Port port = opposite.getPort();
				EList<Expression> toParams = to.getParameters();
				EList<Value> toParamValues = new BasicEList<>(toParams.size());
				for (Expression argument : toParams) {
					toParamValues.add(ExpressionEvaluator.interpret(argument,
							ctx));
				}
				target.getMessageQueue()
						.add(MessageDesc.create(port, to.getSignal(),
								toParamValues));
			} catch (ConnectorException e) {
				String msg = "line " + getLineNumber(st) + ": "
						+ e.getMessage();
				throw new ConnectorException(msg);
			}
		}
	}

	private void compute(NoOp st, CapsuleContext ctx) {
		// no-op
	}

	private void compute(Variable var, CapsuleContext ctx)
			 {
		Map<LocalVar, Value> envt = ctx.callStackOfLocalVars().peek();
		LocalVar lvalue = var.getVar();
		if (var.isAssign()) {
			Value v = ExpressionEvaluator.interpret(var.getExp(), ctx);
			envt.put(lvalue, v);
		} else {
			envt.put(lvalue, null);
		}
	}

	private void compute(LogStatement log, CapsuleContext ctx)
			 {
		ctx.log(ctx.getCapsuleInst().getName() + " logging to "
				+ log.getLogPort().getName() + " with: "
				+ evalStr(log.getLeft(), ctx));
	}

	private String evalConcatStr(ConcatenateExpression conStr,
			CapsuleContext ctx)  {
		String a = evalStr(conStr.getLeft(), ctx);
		String b = evalStr(conStr.getRest(), ctx);
		return a + b;
	}

	private String evalStr(StringExpression strExp, CapsuleContext ctx)
			 {
		if (strExp instanceof ConcatenateExpression) {
			return evalConcatStr((ConcatenateExpression) strExp, ctx);
		} else {
			if (strExp.getExpr() != null) {
				return ExpressionEvaluator.interpret(strExp.getExpr(), ctx)
						.toString();
			} else {
				return strExp.getStr();
			}
		}
	}

	private void compute(Assignment asgn, CapsuleContext ctx)
			 {
		Value result = ExpressionEvaluator.interpret(asgn.getExp(), ctx);
		Assignable lval = asgn.getLvalue();
		if (lval instanceof Attribute) {
			if (ctx.getAttributes().containsKey((Attribute) lval)) {
				ctx.getAttributes().put((Attribute) lval, result);
				return;
			}
		} else if (lval instanceof LocalVar) {
			if (ctx.callStackOfLocalVars().peek().containsKey((LocalVar) lval)) {
				ctx.callStackOfLocalVars().peek().put((LocalVar) lval, result);
				return;
			}
		}
		throw new IllegalStateException("can't find " + lval.getName()
				+ " from capsule attribute or current scope");
	}

	private void compute(InformTimer ifm, CapsuleContext ctx)
			 {
		Value evalResult = ExpressionEvaluator.interpret(ifm.getTime(), ctx);
		if (!(evalResult instanceof Int))
			throw new IllegalStateException(ctx.getName() + " " + evalResult
					+ " is not an integer expression");
		Int time = (Int) evalResult;
		final TimerPort timeout = ifm.getTimerPort();
		Instant timeoutInstant = Instant.now().plusMillis(time.getVal());
		ctx.getTimeoutInstants().put(timeout, timeoutInstant);
	}

	private void compute(WhileLoop loop, CapsuleContext ctx)
			 {
		while (true) {
			Value result = ExpressionEvaluator.interpret(loop.getCondition(),
					ctx);
			if (!(result instanceof Bool))
				throw new IllegalStateException(ctx.getName() + " " + result
						+ " is not a boolean expression");
			Bool testResult = (Bool) result;
			if (!testResult.getVal())
				break;
			for (Statement s : loop.getStatements())
				StatementExecuter.interpret(s, ctx);
		}
	}

	private void compute(IfStatement ifSt, CapsuleContext ctx)
			 {
		Value evalResult = ExpressionEvaluator.interpret(ifSt.getCondition(),
				ctx);
		if (!(evalResult instanceof Bool)) {
			throw new IllegalStateException(ctx.getName() + " " + evalResult
					+ " is not a boolean expression");
		}
		Bool testResult = (Bool) evalResult;
		List<Statement> stList;
		if (testResult.getVal())
			stList = ifSt.getThenStatements();
		else
			stList = ifSt.getElseStatements();
		for (Statement s : stList)
			interpret(s, ctx);
	}

	private void compute(Invoke inv, CapsuleContext ctx)
			 {

		// check if # of formal parameters (from the operation header)
		// and # of actual arguments (from the invocation) are equal
		int formalParam = inv.getOperation().getLocalVars().size();
		int actualArgs = inv.getParameters().size();
		if (formalParam != actualArgs)
			throw new IllegalStateException(ctx.getName()
					+ " formal parameter in operation header "
					+ inv.getOperation().getName() + "(" + formalParam
					+ ") != actual parameter in invocation (" + actualArgs
					+ ")");

		// create a new environment with formal parameters assigned
		HashMap<LocalVar, Value> newEnvt = new HashMap<>();
		for (int i = 0; i < formalParam; i++) {
			final LocalVar formalParameter = inv.getOperation().getLocalVars()
					.get(i);
			Value actualArgument = ExpressionEvaluator.interpret(inv
					.getParameters().get(i), ctx);
			newEnvt.put(formalParameter, actualArgument);
		}

		ctx.callStackOfLocalVars().push(newEnvt);
		try {
			EList<StatementOperation> stmts = inv.getOperation()
					.getOperationCode().getStatements();
			for (StatementOperation so : stmts)
				interpret(so, ctx);
		} catch (ReturnStatementSignal ret) {
		}
		ctx.callStackOfLocalVars().pop();
	}

	// operation-specific statements

	private void compute(WhileLoopOperation loop, CapsuleContext ctx)
			 {
		while (true) {
			Value result = ExpressionEvaluator.interpret(loop.getCondition(),
					ctx);
			if (!(result instanceof Bool))
				throw new IllegalStateException(ctx.getName() + " " + result
						+ " is not a boolean expression");
			Bool testResult = (Bool) result;
			if (!testResult.getVal())
				break;
			for (StatementOperation so : loop.getStatements())
				interpret(so, ctx);
		}
	}

	private void compute(IfStatementOperation ifSt, CapsuleContext ctx)
			 {
		Value evalResult = ExpressionEvaluator.interpret(ifSt.getCondition(),
				ctx);
		if (!(evalResult instanceof Bool))
			throw new IllegalStateException(ctx.getName() + " " + evalResult
					+ " is not a boolean expression");
		Bool testResult = (Bool) evalResult;
		if (testResult.getVal())
			for (StatementOperation so : ifSt.getThenStatements())
				interpret(so, ctx);
		else
			for (StatementOperation so : ifSt.getElseStatements())
				interpret(so, ctx);
	}

	private void compute(ReturnStatement rtn, CapsuleContext ctx)
			 {
		if (rtn.getReturnValue() == null) {
			throw new ReturnStatementSignal(null);
		} else {
			throw new ReturnStatementSignal(ExpressionEvaluator.interpret(
					rtn.getReturnValue(), ctx));
		}
	}
}