package ca.queensu.cs.mase.interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.EcoreUtil2;

import ca.queensu.cs.mase.interpreter.data.CapsuleContext;
import ca.queensu.cs.mase.interpreter.dispatchers.ExpressionEvaluator;
import ca.queensu.cs.mase.types.Bool;
import ca.queensu.cs.mase.types.Value;
import ca.queensu.cs.mase.urml.Capsule;
import ca.queensu.cs.mase.urml.Expression;
import ca.queensu.cs.mase.urml.IncomingVariable;
import ca.queensu.cs.mase.urml.Port;
import ca.queensu.cs.mase.urml.Signal;
import ca.queensu.cs.mase.urml.TimerPort;
import ca.queensu.cs.mase.urml.Transition;
import ca.queensu.cs.mase.urml.Trigger_in;
import ca.queensu.cs.mase.util.MessageDesc;

public class TransitionFilter {

	private BufferedReader in;
	private PrintStream out;
	private ExecutionConfig config;

	public TransitionFilter(BufferedReader in, PrintStream out,
			ExecutionConfig config) {
		this.in = in;
		this.out = out;
		this.config = config;
	}

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
	public Transition[] filterGuard(Transition[] transWithoutGuardCheck,
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
	 * Filters out the transitions which does not have the proper triggers, as
	 * stated in the capsule context {@code ctx}.
	 * 
	 * @param trans
	 *            the original list of transitions which is not processed for
	 *            their triggers yet
	 * @param ctx
	 *            the capsule context which contains the message queue and the
	 *            timer map
	 * @return a filtered list of transitions whose triggers match with the
	 *         message queue or the timer lookup table in the capsule context
	 */
	public Transition[] filterTrigger(Transition[] trans, CapsuleContext ctx) {
		List<Transition> toReturn = new ArrayList<>();
		for (Transition t : trans) {
			testMsgTriggers(t, toReturn, ctx);
			testTimerTriggers(t, toReturn, ctx);
		}
		return toReturn.toArray(new Transition[0]);
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
	@Nullable
	public Transition chooseNextTransition(Transition[] nextTransitionList,
			CapsuleContext ctx) {
		Transition toReturn;
		if (nextTransitionList.length == 0)
			return null;
		else if (nextTransitionList.length == 1)
			toReturn = nextTransitionList[0];
		else
			toReturn = chooseNextTransition(nextTransitionList);

		if (toReturn.getTimerPort() != null) {
			ctx.getTimeoutInstants().remove(toReturn.getTimerPort().getName());
		} else if (toReturn.getTriggers().size() != 0) {
			collectTriggerVars(toReturn, ctx);
			ctx.getMessageQueue().poll();
		}
		return toReturn;
	}

	/**
	 * Given the transition from the state machine {@code t}, look through the
	 * transitions from {@code toReturn} and check if their triggers in the
	 * message queue match.
	 * 
	 * @param t
	 * @param toReturn
	 * @param ctx
	 */
	private void testMsgTriggers(Transition t, List<Transition> toReturn,
			CapsuleContext ctx) {
		if (t.getTriggers().size() == 0 && t.getTimerPort() == null) {
			toReturn.add(t);
		} else {
			for (Trigger_in ti : t.getTriggers()) {
				Port transPort = ti.getFrom();
				Signal transSignal = ti.getSignal();
				MessageDesc msg = ctx.getMessageQueue().peek();
				if (msg != null) {
					if (transPort == msg.getPort()
							&& transSignal == msg.getSignal()) {
						toReturn.add(t);
					}
				}
			}
		}
	}

	private void testTimerTriggers(Transition t, List<Transition> toReturn,
			CapsuleContext ctx) {
		TimerPort timerPort = t.getTimerPort();
		if (timerPort != null) {
			if (ctx.getTimeoutInstants().containsKey(timerPort)) {
				Instant timeoutInstant = ctx.getTimeoutInstants().get(timerPort);
				if (Instant.now().isAfter(timeoutInstant)) {
					toReturn.add(t);
					ctx.getTimeoutInstants().remove(timerPort);
				}
			}
		}
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
		if (guard == null)
			return new Bool(true);
		Value guardValue = ExpressionEvaluator.interpret(guard, ci);
		if (!(guardValue instanceof Bool))
			throw new ClassCastException(
					"the guard does not evaluate to a boolean value");
		return (Bool) guardValue;
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
	private Transition chooseNextTransition(Transition[] trans) {
		switch (config.multiTrans) {
		case FIRST_TRANSITION:
			return trans[0];
		case RANDOM_TRANSITION:
			int index = generateRandomNumber(0, trans.length - 1);
			return trans[index];
		case INTERACTIVE:
			int transitionSelection = 0;
			try {
				transitionSelection = userSelectTransition(trans);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return trans[transitionSelection];
		default:
			throw new IllegalArgumentException("wrong choice: choose 1 to 3");
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
	private int userSelectTransition(Transition[] nextTransitionList)
			throws IOException {
		while (true) {
			String capsuleName = "";
			int transitionIndex = 0;
			for (Transition tr : nextTransitionList) {
				Capsule c = EcoreUtil2.getContainerOfType(tr, Capsule.class);
				capsuleName = c != null ? c.getName() : "";
				out.println(capsuleName + " " + transitionIndex + ". "
						+ evalTransition(tr));
				transitionIndex++;
			}
			out.println("capsule name: " + capsuleName
					+ ". choose the transition you wish to launch:");
			// String transitionSelectionStr = in.readLine();
			// return Integer.parseInt(transitionSelectionStr);
			int transitionSelectionStr = Integer.parseInt(in.readLine());
			if (transitionSelectionStr >= 0
					&& transitionSelectionStr < nextTransitionList.length) {
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

	private void collectTriggerVars(Transition transition, CapsuleContext ctx) {
		ctx.setTriggerIncomingVars(new HashMap<IncomingVariable, Value>());
		for (Trigger_in trigger : transition.getTriggers()) {
			Port triggerPort = trigger.getFrom();
			Signal triggerSignal = trigger.getSignal();
			MessageDesc msg = ctx.getMessageQueue().peek();
			if (msg == null) {
				continue;
			}
			if (triggerPort == msg.getPort()
					&& triggerSignal == msg.getSignal()) {
				ctx.setTriggerIncomingVars(new HashMap<IncomingVariable, Value>());
				EList<IncomingVariable> triggerParams = trigger.getParameters();
				EList<Value> msgParams = msg.getParameters();
				for (int index = 0; index < triggerParams.size(); index++) {
					IncomingVariable parameterName = triggerParams.get(index);
					Value parameterValue = msgParams.get(index);
					ctx.getTriggerIncomingVars().put(parameterName, parameterValue);
				}
			}
		}
	}

	/**
	 * Return a string representation of the given transition {@code tr}
	 * 
	 * @param tr
	 *            transition whose string representation is to be returned
	 * @return the string representation of {@code tr}
	 */
	private String evalTransition(Transition tr) {
		return tr.getName() + " from: " + tr.getFrom().getName() + " to: "
				+ tr.getTo().getName();
	}
}
