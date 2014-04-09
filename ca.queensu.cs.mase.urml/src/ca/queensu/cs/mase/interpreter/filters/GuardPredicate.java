package ca.queensu.cs.mase.interpreter.filters;

import java.util.Objects;
import java.util.function.Predicate;

import ca.queensu.cs.mase.interpreter.data.CapsuleContext;
import ca.queensu.cs.mase.interpreter.dispatchers.ExpressionEvaluator;
import ca.queensu.cs.mase.types.Bool;
import ca.queensu.cs.mase.types.Value;
import ca.queensu.cs.mase.urml.Expression;
import ca.queensu.cs.mase.urml.Transition;

public class GuardPredicate implements Predicate<Transition> {

	private CapsuleContext ctx;
	public GuardPredicate(CapsuleContext ctx_) {
		ctx = ctx_;
	}
	
	@Override
	public boolean test(Transition t) {
		Bool guardValue = evaluateGuard(t, ctx);
		return guardValue.getVal();
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
	private Bool evaluateGuard(Transition t, CapsuleContext ci) {
		Expression guard = t.getGuard();
		Value guardValue = ExpressionEvaluator.interpret(guard, ci);
		if (!(guardValue instanceof Bool))
			throw new ClassCastException(
					"the guard does not evaluate to a boolean value");
		return (Bool) guardValue;
	}
	

}
