package ca.queensu.cs.mase.interpreter.filters;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import ca.queensu.cs.mase.interpreter.data.CapsuleContext;
import ca.queensu.cs.mase.urml.Port;
import ca.queensu.cs.mase.urml.Signal;
import ca.queensu.cs.mase.urml.TimerPort;
import ca.queensu.cs.mase.urml.Transition;
import ca.queensu.cs.mase.urml.Trigger_in;
import ca.queensu.cs.mase.util.MessageDesc;

public class TriggerFilter {
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
	public static Transition[] filter(Transition[] trans, CapsuleContext ctx) {
		List<Transition> toReturn = new ArrayList<>();
		for (Transition t : trans) {
			testMsgTriggers(t, toReturn, ctx);
			testTimerTriggers(t, toReturn, ctx);
		}
		return toReturn.toArray(new Transition[0]);
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
	private static void testMsgTriggers(Transition t, List<Transition> toReturn,
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

	private static void testTimerTriggers(Transition t, List<Transition> toReturn,
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
}
