package ca.queensu.cs.mase.interpreter;

/**
 * Encapsulates the configuration of running the interpreter. The following
 * options apply:
 * 
 * <ul>
 * <li>what to do when we encounter multiple enabled transitions:
 * <ol>
 * <li>execute the first transition in the list</li>
 * <li>execute some random transition in the list></li>
 * <li>interactively ask the user what to execute</li>
 * </ol>
 * </li>
 * <li>what is the exit conditions:
 * <ol>
 * <li>continue executing until we meet a specified number of seconds</li>
 * <li>continue executing until we meet a specified number of transitions</li>
 * <li>continue exeuting for an infinite time</li>
 * </ol>
 * </li>
 * </ul>
 * 
 * @author Keith
 * 
 */
public class ExecutionConfig {

	/**
	 * Constructor
	 * 
	 * @param mt
	 * @param ec
	 * @param duration
	 */
	public ExecutionConfig(MultipleTransitions mt, ExitCondition ec,
			int duration) {
		this.multiTrans = mt;
		this.exitCons = ec;
		this.duration = duration;
	}

	public enum MultipleTransitions {
		FIRST_TRANSITION, RANDOM_TRANSITION, INTERACTIVE
	}

	public MultipleTransitions multiTrans;

	public enum ExitCondition {
		BEFORE_SECONDS, BEFORE_TRANSITIONS, INFINITE;
	}

	public ExitCondition exitCons;

	public int duration;
}