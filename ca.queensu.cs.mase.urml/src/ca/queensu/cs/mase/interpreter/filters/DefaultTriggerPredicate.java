package ca.queensu.cs.mase.interpreter.filters;

import java.util.function.Predicate;

import ca.queensu.cs.mase.urml.Transition;

public class DefaultTriggerPredicate implements Predicate<Transition> {

	@Override
	public boolean test(Transition t) {
		return t.getTriggers().size() == 0 && t.getTimerPort() == null;
	}

}
