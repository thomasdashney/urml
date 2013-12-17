package ca.queensu.cs.mase.interpreter;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.internal.xtend.expression.ast.Cast;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.PolymorphicDispatcher;

import com.google.inject.Inject;

import ca.queensu.cs.mase.urml.BoolLiteral;
import ca.queensu.cs.mase.urml.ConditionalAndExpression;
import ca.queensu.cs.mase.urml.ConditionalOrExpression;
import ca.queensu.cs.mase.urml.Divide;
import ca.queensu.cs.mase.urml.Equal;
import ca.queensu.cs.mase.urml.Expression;
import ca.queensu.cs.mase.urml.FunctionCall;
import ca.queensu.cs.mase.urml.GreaterThan;
import ca.queensu.cs.mase.urml.GreaterThanOrEqual;
import ca.queensu.cs.mase.urml.Identifier;
import ca.queensu.cs.mase.urml.IntLiteral;
import ca.queensu.cs.mase.urml.Invoke;
import ca.queensu.cs.mase.urml.LessThan;
import ca.queensu.cs.mase.urml.LessThanOrEqual;
import ca.queensu.cs.mase.urml.Minus;
import ca.queensu.cs.mase.urml.Modulo;
import ca.queensu.cs.mase.urml.Multiply;
import ca.queensu.cs.mase.urml.NotBooleanExpression;
import ca.queensu.cs.mase.urml.NotEqual;
import ca.queensu.cs.mase.urml.Plus;
import ca.queensu.cs.mase.urml.ReturnStatement;
import ca.queensu.cs.mase.urml.StatementOperation;
import ca.queensu.cs.mase.urml.UnaryExpression;
import ca.queensu.cs.mase.util.Bool;
import ca.queensu.cs.mase.util.Int;
import ca.queensu.cs.mase.util.None;
import ca.queensu.cs.mase.util.Value;

/**
 * An expression evaluator used for the URML language
 * 
 * @author keith
 */
@SuppressWarnings("unused")
public class ExpressionEvaluator {

	@Inject
	private Logger logger;
	/**
	 * Xtext's polymorphic dispatcher to "overload" method based on the dynamic
	 * (runtime) types of the parameters (as opposed to Java which dispatch
	 * methods based on the compile-time types of the parameters)
	 */
	private PolymorphicDispatcher<Value> expEvalDispatcher = PolymorphicDispatcher
			.createForSingleTarget("compute", 2, 2, this); //$NON-NLS-1$

	/**
	 * Evaluates the expression {@code exp} based on the environment as
	 * available in {@code ctx} and returns a resulting {@link Value} that wraps
	 * either a boolean or an integer
	 * 
	 * @param exp
	 *            the expression to be evaluated
	 * @param ctx
	 *            contains the environment whether the identifiers reside
	 * @return a {@link Value} that wraps either a boolean or an integer, that
	 *         represents the result of the evaluation of the expression
	 *         {@code exp}
	 */
	public Value interpret(Expression exp, CapsuleContext ctx) {
		return expEvalDispatcher.invoke(exp, ctx);
	}

	/**
	 * Given an integer literal {@code intLiteral}, returns its {@link Value}
	 * correspondence
	 * 
	 * @param intLiteral
	 *            the integer literal
	 * @param ctx
	 *            environment where the identifiers and their values reside
	 * @return a {@link Value} correspondence of {@code intLiteral}
	 */
	private Value compute(IntLiteral intLiteral, CapsuleContext ctx) {
		return new Int(intLiteral.getInt());
	}

	/**
	 * Given an boolean literal {@code boolLiteral}, returns its {@link Value}
	 * correspondence
	 * 
	 * @param boolLiteral
	 *            the boolean literal
	 * @param ctx
	 *            environment where the identifiers and their values reside
	 * @return a {@link Value} correspondence of {@code boolLiteral}
	 */
	private Value compute(BoolLiteral boolLiteral, CapsuleContext ctx) {
		return new Bool(boolLiteral.isTrue());
	}

	private Value compute(NotBooleanExpression exp, CapsuleContext ctx) {
		Bool b = evalExpToBool(exp.getExp(), ctx);
		return new Bool(!b.getVal());
	}

	private Value compute(UnaryExpression exp, CapsuleContext ctx) {
		Int a = evalExpToInt(exp.getExp(), ctx);
		return new Int(-a.getVal());
	}

	private Value compute(ConditionalOrExpression exp, CapsuleContext ctx) {
		Bool a = evalExpToBool(exp.getLeft(), ctx);
		Bool b = evalExpToBool(exp.getRest(), ctx);
		return new Bool(a.getVal() || b.getVal());
	}

	private Value compute(ConditionalAndExpression exp, CapsuleContext ctx) {
		Bool a = evalExpToBool(exp.getLeft(), ctx);
		Bool b = evalExpToBool(exp.getRest(), ctx);
		return new Bool(a.getVal() && b.getVal());
	}

	private Value compute(Plus exp, CapsuleContext ctx) {
		Int a = evalExpToInt(exp.getLeft(), ctx);
		Int b = evalExpToInt(exp.getRest(), ctx);
		return new Int(a.getVal() + b.getVal());
	}

	private Value compute(Minus exp, CapsuleContext ctx) {
		Int a = evalExpToInt(exp.getLeft(), ctx);
		Int b = evalExpToInt(exp.getRest(), ctx);
		return new Int(a.getVal() - b.getVal());
	}

	private Value compute(Multiply exp, CapsuleContext ctx) {
		Int a = evalExpToInt(exp.getLeft(), ctx);
		Int b = evalExpToInt(exp.getRest(), ctx);
		return new Int(a.getVal() * b.getVal());
	}

	private Value compute(Divide exp, CapsuleContext ctx) {
		Int a = evalExpToInt(exp.getLeft(), ctx);
		Int b = evalExpToInt(exp.getRest(), ctx);
		return new Int(a.getVal() / b.getVal());
	}

	private Value compute(Modulo exp, CapsuleContext ctx) {
		Int a = evalExpToInt(exp.getLeft(), ctx);
		Int b = evalExpToInt(exp.getRest(), ctx);
		return new Int(a.getVal() % b.getVal());
	}

	private Value compute(LessThanOrEqual exp, CapsuleContext ctx) {
		Int a = evalExpToInt(exp.getLeft(), ctx);
		Int b = evalExpToInt(exp.getRest(), ctx);
		return new Bool(a.getVal() <= b.getVal());
	}

	private Value compute(LessThan exp, CapsuleContext ctx) {
		Int a = evalExpToInt(exp.getLeft(), ctx);
		Int b = evalExpToInt(exp.getRest(), ctx);
		return new Bool(a.getVal() < b.getVal());
	}

	private Value compute(GreaterThanOrEqual exp, CapsuleContext ctx) {
		Int a = evalExpToInt(exp.getLeft(), ctx);
		Int b = evalExpToInt(exp.getRest(), ctx);
		return new Bool(a.getVal() >= b.getVal());
	}

	private Value compute(GreaterThan exp, CapsuleContext ctx) {
		Int a = evalExpToInt(exp.getLeft(), ctx);
		Int b = evalExpToInt(exp.getRest(), ctx);
		return new Bool(a.getVal() > b.getVal());
	}

	private Value compute(Equal exp, CapsuleContext ctx) {
		try {
			Int a = evalExpToInt(exp.getLeft(), ctx);
			Int b = evalExpToInt(exp.getRest(), ctx);
			return new Bool(a.getVal() == b.getVal());
		} catch (ClassCastException e) {
			Bool a = evalExpToBool(exp.getLeft(), ctx);
			Bool b = evalExpToBool(exp.getRest(), ctx);
			return new Bool(a.getVal() == b.getVal());
		}
	}

	private Value compute(NotEqual exp, CapsuleContext ctx) {
		try {
			Int a = evalExpToInt(exp.getLeft(), ctx);
			Int b = evalExpToInt(exp.getRest(), ctx);
			return new Bool(a.getVal() != b.getVal());
		} catch (ClassCastException e) {
			Bool a = evalExpToBool(exp.getLeft(), ctx);
			Bool b = evalExpToBool(exp.getRest(), ctx);
			return new Bool(a.getVal() != b.getVal());
		}
	}

	private Value compute(Identifier exp, CapsuleContext ctx) {
		String identifierName = exp.getId().getName();

		if (ctx.getEnvt().containsKey(identifierName)) {
			return ctx.getEnvt().get(identifierName);
		} else if (ctx.getCallStack().peek().containsKey(identifierName)) {
			return ctx.getCallStack().peek().get(identifierName);
		} else if (ctx.getTriggerVars() != null
				&& ctx.getTriggerVars().containsKey(identifierName)) {
			return ctx.getTriggerVars().get(identifierName);
		} else {
			throw new NoSuchIdentifierException(String.format(
					"line %d: no such identifier %s from current scope or capsule attribute",
					getLineNumber(exp),
					identifierName));
		}
	}

	private static int getLineNumber(EObject obj) {
		if (obj == null) return -1;
		ICompositeNode node = NodeModelUtils.getNode(obj);
		if (node == null) return -1;
		return node.getStartLine();
	}
	
	private Value compute(FunctionCall exp, CapsuleContext ctx) {
//		logger.debug("calling function " + exp.getCall().getName()); //$NON-NLS-1$

		// check if formal param # == actual arguments #
		int formalParam = exp.getCall().getVarDecls().size();
		int actualArgs = exp.getParams().size();
		if (formalParam != actualArgs) {
			throw new IllegalStateException(String.format(
					Messages.getString("ExpressionEvaluator.1"), //$NON-NLS-1$
					exp.getCall().getName()));
		}

		// create new envt with formal params assigned
		HashMap<String, Value> newEnvt = new HashMap<>();
		for (int i = 0; i < formalParam; i++) {
			String formalParameter = exp.getCall().getVarDecls().get(i)
					.getName();
			Value actualArgument = this.interpret(exp.getParams().get(i), ctx);
			newEnvt.put(formalParameter, actualArgument);
		}

		ctx.getCallStack().push(newEnvt);

		try {
			StatementExecuter stmtExec = new StatementExecuter();
			for (StatementOperation stmtOp : exp.getCall().getOperationCode()
					.getStatements())
				stmtExec.execute(stmtOp, ctx);
			throw new ReturnStatementNotFoundException(
					Messages.getString("ExpressionEvaluator.2")); //$NON-NLS-1$
		} catch (ReturnStatementException re) {
		}
		Value returnVal = ctx.getCallStack().peek()
				.get("return");
		ctx.getCallStack().pop();
		return returnVal;
	}

	private Bool evalExpToBool(Expression exp, CapsuleContext ctx) {
		Value val = expEvalDispatcher.invoke(exp, ctx);
		if (!(val instanceof Bool))
			throw new ClassCastException(String.format(
					Messages.getString("ExpressionEvaluator.3"), //$NON-NLS-1$
					ctx.getName(), val.toString()));
		return (Bool) val;
	}

	private Int evalExpToInt(Expression exp, CapsuleContext ctx) {
		Value val = expEvalDispatcher.invoke(exp, ctx);
		if (!(val instanceof Int))
			throw new ClassCastException(String.format(
					Messages.getString("ExpressionEvaluator.4"), //$NON-NLS-1$
					ctx.getName(), val.toString()));
		return (Int) val;
	}

	@SuppressWarnings("serial")
	public class ReturnStatementNotFoundException extends RuntimeException {
		public ReturnStatementNotFoundException(String string) {
			super(string);
		}
	}

	@SuppressWarnings("serial")
	public class NoSuchIdentifierException extends RuntimeException {
		public NoSuchIdentifierException(String string) {
			super(string);
		}
	}
}