package ca.queensu.cs.mase.interpreter.filters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import org.eclipse.xtext.EcoreUtil2;

import ca.queensu.cs.mase.interpreter.ExecutionConfig;
import ca.queensu.cs.mase.urml.Capsule;
import ca.queensu.cs.mase.urml.Transition;

public class TransitionSelector {

	private BufferedReader in;
	private PrintStream out;
	private ExecutionConfig config;

	public TransitionSelector(BufferedReader in, PrintStream out,
			ExecutionConfig config) {
		this.in = in;
		this.out = out;
		this.config = config;
	}

	/**
	 * Given a list of found transition that are stored in
	 * {@code nextTransitionList}, finds the single transition that is to be
	 * executed next. If no transition is found from {@code nextTransitionList},
	 * we assume that the state machine ends and return {@code null}.
	 * 
	 * @param nextTransitionList
	 *            a list of possible next transitions
	 * @return the single transition to be executed next, or {@code null} if no
	 *         such transition is available
	 */
	public Transition select(List<Transition> nextTransitionList) {
		if (nextTransitionList.size() == 0)
			return null;
		else if (nextTransitionList.size() == 1)
			return nextTransitionList.get(0);
		else
			return chooseNextTransition(nextTransitionList);
	}

	/**
	 * If multiple possible transitions are found in {@code nextTransitionList},
	 * choose the proper transition based on specified execution configuration.
	 * Either choose the first appearing transition from the state machine, or
	 * select a random transition from the list, or interactively ask the user
	 * which transition to execute.
	 * 
	 * @param nextTransitionList
	 *            the list of transitions to be executed next; currently
	 *            non-deterministic because there are more than one transitions
	 *            in the list
	 * @return the single transition to be executed next
	 */
	private Transition chooseNextTransition(List<Transition> trans) {
		switch (config.multiTrans) {
		case FIRST_TRANSITION:
			return trans.get(0);
		case RANDOM_TRANSITION:
			int index = generateRandomNumber(0, trans.size() - 1);
			return trans.get(index);
		case INTERACTIVE:
			try {
				int transitionSelection = userSelectTransition(trans);
				return trans.get(transitionSelection);
			} catch (IOException e) {
				e.printStackTrace(out);
			}
			return null;
		default:
			throw new IllegalArgumentException("bad execution configuration");
		}
	}

	/**
	 * Prompt the user which transition to execute from the list
	 * {@code nextTransitionList}
	 * 
	 * @param nextTransitionList
	 *            the list that contains more than one possible transitions to
	 *            be executed next. This results in a non-deterministic state
	 *            and as such we want to ask the user which transition to
	 *            execute next.
	 * @return the transition to be executed next, as suggested by the user
	 * @throws IOException
	 *             when the user is malicious and does something bad to the I/O
	 */
	private int userSelectTransition(List<Transition> nextTransitionList)
			throws IOException {
		while (true) {
			String capsuleName = "";
			int transitionIndex = 0;
			for (Transition tr : nextTransitionList) {
				Capsule c = EcoreUtil2.getContainerOfType(tr, Capsule.class);
				capsuleName = c != null ? c.getName() : "";
				out.println(capsuleName + " " + transitionIndex + ". "
						+ toStringForTransition(tr));
				transitionIndex++;
			}
			out.println("capsule name: " + capsuleName
					+ ". choose the transition you wish to launch:");
			// String transitionSelectionStr = in.readLine();
			// return Integer.parseInt(transitionSelectionStr);
			int transitionSelectionStr = Integer.parseInt(in.readLine());
			if (transitionSelectionStr >= 0
					&& transitionSelectionStr < nextTransitionList.size()) {
				return transitionSelectionStr;
			}
			out.println(capsuleName
					+ ": error: please choose the proper selection");
		}
	}

	/**
	 * Generates a random integer ranging from {@code min} to {@code max}
	 * 
	 * @param min
	 *            the minimum range of the random integer to be generated
	 * @param max
	 *            the maximum range of the random integer to be generated
	 * @return a randomly generated integer ranging from {@code min} to
	 *         {@code max}
	 */
	private int generateRandomNumber(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}

	/**
	 * Return a string representation of the given transition {@code tr}
	 * 
	 * @param tr
	 *            transition whose string representation is to be returned
	 * @return the string representation of {@code tr}
	 */
	private String toStringForTransition(Transition tr) {
		return tr.getName() + " from: " + tr.getFrom().getName() + " to: "
				+ tr.getTo().getName();
	}
}
