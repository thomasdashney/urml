package ca.queensu.cs.mase.interpreter.filters;

import java.util.function.Predicate;

import ca.queensu.cs.mase.interpreter.data.CapsuleContext;
import ca.queensu.cs.mase.interpreter.dispatchers.ExpressionEvaluator;
import ca.queensu.cs.mase.types.Bool;
import ca.queensu.cs.mase.types.Value;
import ca.queensu.cs.mase.urml.Expression;
import ca.queensu.cs.mase.urml.Transition;

public class GuardPredicates {

	public static Predicate<Transition> evalsToTrue(CapsuleContext ctx) {
		return t -> evaluateGuard(t, ctx).getVal();
	}

	public static Predicate<Transition> hasNoGuard() {
		return t -> t.getGuard() == null;
	}

	/**
	 * Determines the boolean value of the guard of the given transition
	 * {@code t}
	 * 
	 * @param t
	 *            the transition whose guard wil be evaluated
	 * @param ci
	 *            persistent information of the currently running capsule
	 * @return the boolean value to which the guard expression of {@code t}
	 *         evaluates
	 */
	private static Bool evaluateGuard(Transition t, CapsuleContext ci) {
		Expression guard = t.getGuard();
		Value guardValue = ExpressionEvaluator.interpret(guard, ci);
		if (!(guardValue instanceof Bool))
			throw new ClassCastException(
					"the guard does not evaluate to a boolean value");
		return (Bool) guardValue;
	}

}
