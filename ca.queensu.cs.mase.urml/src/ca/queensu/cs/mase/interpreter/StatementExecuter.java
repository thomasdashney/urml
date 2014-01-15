package ca.queensu.cs.mase.interpreter;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.PolymorphicDispatcher;

import ca.queensu.cs.mase.interpreter.OppositeFinder.ConnectorException;
import ca.queensu.cs.mase.urml.Assignment;
import ca.queensu.cs.mase.urml.ConcatenateExpression;
import ca.queensu.cs.mase.urml.Expression;
import ca.queensu.cs.mase.urml.IfStatement;
import ca.queensu.cs.mase.urml.IfStatementOperation;
import ca.queensu.cs.mase.urml.InformTimer;
import ca.queensu.cs.mase.urml.Invoke;
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
import ca.queensu.cs.mase.urml.VarDecl;
import ca.queensu.cs.mase.urml.Variable;
import ca.queensu.cs.mase.urml.WhileLoop;
import ca.queensu.cs.mase.urml.WhileLoopOperation;
import ca.queensu.cs.mase.util.Bool;
import ca.queensu.cs.mase.util.Int;
import ca.queensu.cs.mase.util.MessageInfo;
import ca.queensu.cs.mase.util.Value;

@SuppressWarnings("unused")
public class StatementExecuter {
	private PolymorphicDispatcher<Void> stmtExecDispatcher = PolymorphicDispatcher
			.createForSingleTarget("compute", 2, 2, this);

	public void interpret(Statement st, CapsuleContext ctx) {
		stmtExecDispatcher.invoke(st, ctx);
	}

	private static int getLineNumber(EObject obj) {
		if (obj == null)
			return -1;
		ICompositeNode node = NodeModelUtils.getNode(obj);
		if (node == null)
			return -1;
		return node.getStartLine();
	}

	private void compute(SendTrigger st, CapsuleContext ctx) {
		for (Trigger_out to : st.getTriggers()) {
			// ctx.getOutstream().println(
			// ctx.getName() + " sending triggers for "
			// + to.getTo().getName() + "."
			// + to.getSignal().getName());
			try {
				CapsuleContextPortPair opposite = OppositeFinder
						.findOppositeCapsule(ctx, to.getTo());
				CapsuleContext target = opposite.getCapsuleCB();
				Port port = opposite.getPort();
				EList<Expression> toParams = to.getParameters();
				EList<Value> toParamValues = new BasicEList<>(toParams.size());
				for (Expression argument: toParams) {
					toParamValues.add(new ExpressionEvaluator().interpret(
							argument, ctx));
				}
				target.getMessageQueue()
						.add(MessageInfo.create(port, to.getSignal(),
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

	private void compute(Variable st, CapsuleContext ctx) {
		// ctx.getOutstream().println(
		// ctx.getName() + " declaring variable for "
		// + st.getVar().getName());

		Map<String, Value> envt = ctx.getCallStack().peek();
		String lvalue = st.getVar().getName();
		if (st.isAssign()) {
			Value v = new ExpressionEvaluator().interpret(st.getExp(), ctx);
			envt.put(lvalue, v);
		} else {
			envt.put(lvalue, null);
		}
	}

	private void compute(LogStatement st, CapsuleContext ctx) {
		ctx.getOutstream().println(
				ctx.getCapsuleRef().getName() + " logging to "
						+ st.getLogPort().getName() + " with: "
						+ evalStr(st.getLeft(), ctx));
	}

	private String evalConcatStr(ConcatenateExpression conStr,
			CapsuleContext ctx) {
		String a = evalStr(conStr.getLeft(), ctx);
		String b = evalStr(conStr.getRest(), ctx);
		return a + b;
	}

	private String evalStr(StringExpression strExp, CapsuleContext ctx) {
		if (strExp instanceof ConcatenateExpression) {
			return evalConcatStr((ConcatenateExpression) strExp, ctx);
		} else {
			if (strExp.getExpr() != null) {
				return new ExpressionEvaluator().interpret(strExp.getExpr(),
						ctx).toString();
			} else {
				return strExp.getStr();
			}
		}
	}

	private void compute(Assignment st, CapsuleContext ctx) {
		ExpressionEvaluator expEval = new ExpressionEvaluator();
		Value result = expEval.interpret(st.getExp(), ctx);
		String lvalue = st.getLvalue().getName();
		// ctx.getOutstream().println(
		// ctx.getName() + " assigning " + lvalue + " with " + result);
		Map<String, Value> currCall = ctx.getCallStack().peek();
		if (currCall.containsKey(lvalue))
			currCall.put(lvalue, result);
		else if (ctx.getEnvt().containsKey(lvalue))
			ctx.getEnvt().put(lvalue, result);
		else
			throw new IllegalStateException("can't find " + lvalue
					+ " from capsule attribute or current scope");
	}

	private void compute(InformTimer st, CapsuleContext ctx) {
		ExpressionEvaluator expEval = new ExpressionEvaluator();
		Value evalResult = expEval.interpret(st.getTime(), ctx);
		if (!(evalResult instanceof Int))
			throw new IllegalStateException(ctx.getName() + " " + evalResult
					+ " is not an integer expression");
		Int time = (Int) evalResult;
		// ctx.getOutstream().println(
		// ctx.getName() + " informing timer "
		// + st.getTimerPort().getName() + " for " + time.getVal()
		// + " milliseconds");
		final TimerPort timeout = st.getTimerPort();
		long timeoutTime = System.currentTimeMillis() + time.getVal();
		ctx.getTimeout().put(timeout, timeoutTime);
	}

	private void compute(WhileLoop st, CapsuleContext ctx) {
		ExpressionEvaluator expEval = new ExpressionEvaluator();
		while (true) {
			Value result = expEval.interpret(st.getCondition(), ctx);
			if (!(result instanceof Bool))
				throw new IllegalStateException(ctx.getName() + " " + result
						+ " is not a boolean expression");
			Bool testResult = (Bool) result;
			if (!testResult.getVal())
				break;
			for (Statement loopSt : st.getStatements())
				interpret(loopSt, ctx);
		}
	}

	private void compute(IfStatement st, CapsuleContext ctx) {
		ExpressionEvaluator expEval = new ExpressionEvaluator();
		Value evalResult = expEval.interpret(st.getCondition(), ctx);
		if (!(evalResult instanceof Bool))
			throw new IllegalStateException(ctx.getName() + " " + evalResult
					+ " is not a boolean expression");
		Bool testResult = (Bool) evalResult;
		if (testResult.getVal())
			for (Statement stIf : st.getThenStatements())
				interpret(stIf, ctx);
		else
			for (Statement stElse : st.getElseStatements())
				interpret(stElse, ctx);
	}

	private void compute(Invoke st, CapsuleContext ctx) {
		// ctx.getOutstream().println(
		// ctx.getName() + " invoking operation "
		// + st.getOperation().getName());

		// check if # of formal parameters (from the operation header)
		// and # of actual arguments (from the invocation) are equal
		int formalParam = st.getOperation().getVarDecls().size();
		int actualArgs = st.getParameters().size();
		if (formalParam != actualArgs)
			throw new IllegalStateException(ctx.getName()
					+ " formal parameter in operation header "
					+ st.getOperation().getName() + "(" + formalParam
					+ ") != actual parameter in invocation (" + actualArgs
					+ ")");

		// create a new environment with formal parameters assigned
		HashMap<String, Value> newEnvt = new HashMap<>();
		ExpressionEvaluator expEval = new ExpressionEvaluator();
		for (int i = 0; i < formalParam; i++) {
			String formalParameter = st.getOperation().getVarDecls().get(i)
					.getName();
			Value actualArgument = expEval.interpret(st.getParameters().get(i),
					ctx);
			newEnvt.put(formalParameter, actualArgument);
		}

		ctx.getCallStack().push(newEnvt);
		try {
			EList<StatementOperation> stmts = st.getOperation()
					.getOperationCode().getStatements();
			for (StatementOperation so : stmts)
				execute(so, ctx);
		} catch (ReturnStatementException ret) {
		}
		ctx.getCallStack().pop();
	}

	// operation-specific statements

	public void execute(StatementOperation st, CapsuleContext ctx) {
		stmtExecDispatcher.invoke(st, ctx);
	}

	private void compute(WhileLoopOperation st, CapsuleContext ctx) {
		ExpressionEvaluator expEval = new ExpressionEvaluator();
		while (true) {
			Value result = expEval.interpret(st.getCondition(), ctx);
			if (!(result instanceof Bool))
				throw new IllegalStateException(ctx.getName() + " " + result
						+ " is not a boolean expression");
			Bool testResult = (Bool) result;
			if (!testResult.getVal())
				break;
			for (StatementOperation so : st.getStatements())
				execute(so, ctx);
		}
	}

	private void compute(IfStatementOperation st, CapsuleContext ctx) {
		ExpressionEvaluator expEval = new ExpressionEvaluator();
		Value evalResult = expEval.interpret(st.getCondition(), ctx);
		if (!(evalResult instanceof Bool))
			throw new IllegalStateException(ctx.getName() + " " + evalResult
					+ " is not a boolean expression");
		Bool testResult = (Bool) evalResult;
		if (testResult.getVal())
			for (StatementOperation so : st.getThenStatements())
				execute(so, ctx);
		else
			for (StatementOperation so : st.getElseStatements())
				execute(so, ctx);
	}

	private void compute(ReturnStatement st, CapsuleContext ctx) {
		ExpressionEvaluator expEval = new ExpressionEvaluator();
		ctx.getCallStack()
				.peek()
				.put(UrmlInterpreter.RETURN_STRING,
						expEval.interpret(st.getReturnValue(), ctx));
		throw new ReturnStatementException();
	}

}