package ca.queensu.cs.mase.interpreter.filters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import org.eclipse.xtext.EcoreUtil2;

import ca.queensu.cs.mase.interpreter.ExecutionConfig;
import ca.queensu.cs.mase.interpreter.data.CapsuleContext;
import ca.queensu.cs.mase.interpreter.data.CapsuleContextNextTransitionPair;
import ca.queensu.cs.mase.urml.Capsule;
import ca.queensu.cs.mase.urml.CapsuleInst;
import ca.queensu.cs.mase.urml.Transition;

public class TransitionSelector {

	private BufferedReader in;
	private PrintStream out;
	private ExecutionConfig config;

	// private CapsuleContext ctx;

	public TransitionSelector(BufferedReader in, PrintStream out,
			ExecutionConfig config) {
		this.in = in;
		this.out = out;
		this.config = config;
		// this.ctx = ctx;
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
	public CapsuleContextNextTransitionPair select(
			List<CapsuleContextNextTransitionPair> nextTransitionList) {
		if (nextTransitionList.size() == 0) {
			return null;
		} else if (nextTransitionList.size() == 1) {
			return nextTransitionList.get(0);
		} else {
			out.println("NON-DETERMINISM");
			return chooseNextTransition(nextTransitionList);
		}
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
	private CapsuleContextNextTransitionPair chooseNextTransition(
			List<CapsuleContextNextTransitionPair> trans) {
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
	 *             when the user does something bad to the I/O
	 */
	private int userSelectTransition(
			List<CapsuleContextNextTransitionPair> nextTransitionList)
			throws IOException {
		while (true) {
			// String capsuleName = "";
			// CapsuleInst c = ctx.getCapsuleInst();
			int transitionIndex = 0;
			for (CapsuleContextNextTransitionPair pr : nextTransitionList) {
				CapsuleInst c = pr.getCtx().getCapsuleInst();
				Transition tr = pr.getTrans();
				out.println(c.getName() + " " + transitionIndex + ". "
						+ toStringForTransition(tr));
				transitionIndex++;
			}
			out.print("choose the transition you wish to launch:");
			// String transitionSelectionStr = in.readLine();
			// return Integer.parseInt(transitionSelectionStr);
			try {
				int transitionSelectionStr = Integer.parseInt(in.readLine());
				if (transitionSelectionStr >= 0
						&& transitionSelectionStr < nextTransitionList.size()) {
					return transitionSelectionStr;
				}
			} catch (NumberFormatException consumed) {
			}
			out.println("error: please choose the proper selection");
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
