package ca.queensu.cs.mase.interpreter;

import org.eclipse.xtext.scoping.impl.SelectableBasedScope;

import ca.queensu.cs.mase.urml.Transition;

public class ExecutionConfig {

	public ExecutionConfig(MultipleTransitions mt, ExitCondition ec,
			int duration) {
		this.multiTrans = mt;
		this.exitCons = ec;
		this.duration = duration;
	}

	public enum MultipleTransitions {
		FIRST_TRANSITION, RANDOM_TRANSITION, INTERACTIVE
	};

	public MultipleTransitions multiTrans;

	public enum ExitCondition {
		BEFORE_SECONDS, BEFORE_TRANSITIONS, INFINITE;
	}

	public int duration;
	public ExitCondition exitCons;
}