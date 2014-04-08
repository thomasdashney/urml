package ca.queensu.cs.mase.interpreter.filters;

import java.util.ArrayList;
import java.util.List;

import ca.queensu.cs.mase.interpreter.data.CapsuleContext;
import ca.queensu.cs.mase.interpreter.dispatchers.ExpressionEvaluator;
import ca.queensu.cs.mase.types.Bool;
import ca.queensu.cs.mase.types.Value;
import ca.queensu.cs.mase.urml.Expression;
import ca.queensu.cs.mase.urml.Transition;

public class GuardFilter {
	
	/**
	 * Filter out the transitions whose guard conditions return false, based on
	 * the capsule context {@code ctx}.
	 * 
	 * @param transWithoutGuardCheck
	 *            original list of transitions without the guard check
	 * @param ctx
	 *            context object of the capsule
	 * @return a filtered list of transitions whose guard values return true
	 */
	public static Transition[] filter(Transition[] transWithoutGuardCheck,
			CapsuleContext ctx) {
		List<Transition> toReturn = new ArrayList<>();
		for (Transition candidate : transWithoutGuardCheck) {
			Bool guardValue = evaluateGuard(candidate, ctx);
			if (guardValue.getVal()) {
				toReturn.add(candidate);
			}
		}
		return toReturn.toArray(new Transition[0]);
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
		if (guard == null)
			return new Bool(true);
		Value guardValue = ExpressionEvaluator.interpret(guard, ci);
		if (!(guardValue instanceof Bool))
			throw new ClassCastException(
					"the guard does not evaluate to a boolean value");
		return (Bool) guardValue;
	}
}