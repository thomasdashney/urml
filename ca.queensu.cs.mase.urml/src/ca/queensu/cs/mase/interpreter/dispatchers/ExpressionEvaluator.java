package ca.queensu.cs.mase.interpreter.dispatchers;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.internal.xtend.expression.ast.Cast;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.PolymorphicDispatcher;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

import ca.queensu.cs.mase.interpreter.data.CapsuleContext;
import ca.queensu.cs.mase.types.Bool;
import ca.queensu.cs.mase.types.Int;
import ca.queensu.cs.mase.types.None;
import ca.queensu.cs.mase.types.Value;
import ca.queensu.cs.mase.urml.Attribute;
import ca.queensu.cs.mase.urml.BoolLiteral;
import ca.queensu.cs.mase.urml.ConditionalAndExpression;
import ca.queensu.cs.mase.urml.ConditionalOrExpression;
import ca.queensu.cs.mase.urml.Divide;
import ca.queensu.cs.mase.urml.Equal;
import ca.queensu.cs.mase.urml.Expression;
import ca.queensu.cs.mase.urml.FunctionCall;
import ca.queensu.cs.mase.urml.GreaterThan;
import ca.queensu.cs.mase.urml.GreaterThanOrEqual;
import ca.queensu.cs.mase.urml.Identifiable;
import ca.queensu.cs.mase.urml.Identifier;
import ca.queensu.cs.mase.urml.IncomingVariable;
import ca.queensu.cs.mase.urml.IntLiteral;
import ca.queensu.cs.mase.urml.Invoke;
import ca.queensu.cs.mase.urml.LessThan;
import ca.queensu.cs.mase.urml.LessThanOrEqual;
import ca.queensu.cs.mase.urml.LocalVar;
import ca.queensu.cs.mase.urml.Minus;
import ca.queensu.cs.mase.urml.Modulo;
import ca.queensu.cs.mase.urml.Multiply;
import ca.queensu.cs.mase.urml.NotBooleanExpression;
import ca.queensu.cs.mase.urml.NotEqual;
import ca.queensu.cs.mase.urml.Plus;
import ca.queensu.cs.mase.urml.ReturnStatement;
import ca.queensu.cs.mase.urml.StatementOperation;
import ca.queensu.cs.mase.urml.UnaryExpression;
import ca.queensu.cs.mase.util.ReturnStatementSignal;
import ca.queensu.cs.mase.util.UrmlInterruptedException;

/**
 * An expression evaluator used for the URML language
 * 
 * @author keith
 */
@SuppressWarnings("unused")
public class ExpressionEvaluator {

	@Inject
	private Logger logger = Logger.getLogger(ExpressionEvaluator.class);
	/**
	 * Xtext's multiple dispatcher to dispatch method based on the dynamic
	 * (runtime) types of all its arguments (as opposed to Java where in the
	 * call receiver.message(arguments), only the runtime type of receiver is
	 * matched and for the arguments, their compile-time type is matched);
	 * multiple dispatch is also known as "multi-methods" in the PL literature
	 */
	private static PolymorphicDispatcher<Value> expEvalDispatcher = PolymorphicDispatcher
			.createForSingleTarget("compute", 2, 3, new ExpressionEvaluator());

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
	 * @
	 *             if interrupted
	 */
	public static Value interpret(Expression exp, CapsuleContext ctx) {
		if (Thread.currentThread().isInterrupted())
			throw new UrmlInterruptedException();
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

	private Value compute(NotBooleanExpression exp, CapsuleContext ctx)
			 {
		Bool b = evalExpToBool(exp.getExp(), ctx);
		return new Bool(!b.getVal());
	}

	private Value compute(UnaryExpression exp, CapsuleContext ctx)
			 {
		Int a = evalExpToInt(exp.getExp(), ctx);
		return new Int(-a.getVal());
	}

	private Value compute(ConditionalOrExpression exp, CapsuleContext ctx)
			 {
		Bool a = evalExpToBool(exp.getLeft(), ctx);
		Bool b = evalExpToBool(exp.getRest(), ctx);
		return new Bool(a.getVal() || b.getVal());
	}

	private Value compute(ConditionalAndExpression exp, CapsuleContext ctx)
			 {
		Bool a = evalExpToBool(exp.getLeft(), ctx);
		Bool b = evalExpToBool(exp.getRest(), ctx);
		return new Bool(a.getVal() && b.getVal());
	}

	private Value compute(Plus exp, CapsuleContext ctx)
			 {
		Int a = evalExpToInt(exp.getLeft(), ctx);
		Int b = evalExpToInt(exp.getRest(), ctx);
		return new Int(a.getVal() + b.getVal());
	}

	private Value compute(Minus exp, CapsuleContext ctx)
			 {
		Int a = evalExpToInt(exp.getLeft(), ctx);
		Int b = evalExpToInt(exp.getRest(), ctx);
		return new Int(a.getVal() - b.getVal());
	}

	private Value compute(Multiply exp, CapsuleContext ctx)
			 {
		Int a = evalExpToInt(exp.getLeft(), ctx);
		Int b = evalExpToInt(exp.getRest(), ctx);
		return new Int(a.getVal() * b.getVal());
	}

	private Value compute(Divide exp, CapsuleContext ctx)
			 {
		Int a = evalExpToInt(exp.getLeft(), ctx);
		Int b = evalExpToInt(exp.getRest(), ctx);
		return new Int(a.getVal() / b.getVal());
	}

	private Value compute(Modulo exp, CapsuleContext ctx)
			 {
		Int a = evalExpToInt(exp.getLeft(), ctx);
		Int b = evalExpToInt(exp.getRest(), ctx);
		return new Int(a.getVal() % b.getVal());
	}

	private Value compute(LessThanOrEqual exp, CapsuleContext ctx)
			 {
		Int a = evalExpToInt(exp.getLeft(), ctx);
		Int b = evalExpToInt(exp.getRest(), ctx);
		return new Bool(a.getVal() <= b.getVal());
	}

	private Value compute(LessThan exp, CapsuleContext ctx)
			 {
		Int a = evalExpToInt(exp.getLeft(), ctx);
		Int b = evalExpToInt(exp.getRest(), ctx);
		return new Bool(a.getVal() < b.getVal());
	}

	private Value compute(GreaterThanOrEqual exp, CapsuleContext ctx)
			 {
		Int a = evalExpToInt(exp.getLeft(), ctx);
		Int b = evalExpToInt(exp.getRest(), ctx);
		return new Bool(a.getVal() >= b.getVal());
	}

	private Value compute(GreaterThan exp, CapsuleContext ctx)
			 {
		Int a = evalExpToInt(exp.getLeft(), ctx);
		Int b = evalExpToInt(exp.getRest(), ctx);
		return new Bool(a.getVal() > b.getVal());
	}

	private Value compute(Equal exp, CapsuleContext ctx)
			 {
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

	private Value compute(NotEqual exp, CapsuleContext ctx)
			 {
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
		Identifiable ident = exp.getId();
		if (ident instanceof Attribute
				&& ctx.getAttributes().containsKey((Attribute) ident)) {
			return ctx.getAttributes().get((Attribute) ident);
		} else if (ident instanceof LocalVar
				&& ctx.callStackOfLocalVars().peek()
						.containsKey((LocalVar) ident)) {
			return ctx.callStackOfLocalVars().peek().get((LocalVar) ident);
		} else if (ident instanceof IncomingVariable
				&& ctx.getTriggerIncomingVars().containsKey(
						(IncomingVariable) ident)) {
			return ctx.getTriggerIncomingVars().get((IncomingVariable) ident);
		} else {
			throw new NoSuchIdentifierException(
					String.format(
							"line %d: no such identifier %s from current scope or capsule attribute",
							getLineNumber(exp), ident.getName()));
		}
	}

	private static int getLineNumber(EObject obj) {
		if (obj == null)
			return -1;
		ICompositeNode node = NodeModelUtils.getNode(obj);
		if (node == null)
			return -1;
		return node.getStartLine();
	}

	private Value compute(FunctionCall exp, CapsuleContext ctx)
			 {

		// check if formal param # == actual arguments #
		int formalParam = exp.getCall().getLocalVars().size();
		int actualArgs = exp.getParams().size();
		if (formalParam != actualArgs) {
			throw new IllegalStateException(
					String.format(
							"line %d: the number of parameters in function call and its prototype do not match in %s",
							getLineNumber(exp), exp.getCall().getName()));
		}

		// create new envt with formal params assigned
		HashMap<LocalVar, Value> newStackFrame = new HashMap<>();
		for (int i = 0; i < formalParam; i++) {
			LocalVar formalParameter = exp.getCall().getLocalVars().get(i);
			Value actualArgument = ExpressionEvaluator.interpret(exp
					.getParams().get(i), ctx);
			newStackFrame.put(formalParameter, actualArgument);
		}

		ctx.callStackOfLocalVars().push(newStackFrame);

		try {

			for (StatementOperation stmtOp : exp.getCall().getOperationCode()
					.getStatements())
				StatementExecuter.interpret(stmtOp, ctx);

		} catch (ReturnStatementSignal re) {
			Value returnVal = re.getVal();
			ctx.callStackOfLocalVars().pop();
			return returnVal;
		}
		throw new ReturnStatementNotFoundException("line " + getLineNumber(exp)
				+ ": cannot find a return statement in a function.");
	}

	private Bool evalExpToBool(Expression exp, CapsuleContext ctx)
			 {
		Value val = interpret(exp, ctx);
		if (!(val instanceof Bool))
			throw new ClassCastException(String.format(
					"line %d: %s is not a boolean", getLineNumber(exp),
					val.toString()));
		return (Bool) val;
	}

	private Int evalExpToInt(Expression exp, CapsuleContext ctx)
			 {
		Value val = interpret(exp, ctx);
		if (!(val instanceof Int))
			throw new ClassCastException(String.format(
					"line %d: %s is not an integer", getLineNumber(exp), val));
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