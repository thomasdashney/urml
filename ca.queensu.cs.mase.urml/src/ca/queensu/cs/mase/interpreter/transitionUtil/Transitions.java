package ca.queensu.cs.mase.interpreter.transitionUtil;

import ca.queensu.cs.mase.interpreter.data.CapsuleContext;
import ca.queensu.cs.mase.urml.Transition;

public class Transitions {
	public static void processTriggers(Transition currentTransition,
			CapsuleContext ctx) {
		if (hasTimeoutTrigger(currentTransition)) {
			ctx.getTimeoutInstants().remove(currentTransition.getTimerPort());
		} else if (hasMessageTriggers(currentTransition)) {
			IncomingVariableCollector.collectTriggerVarsFromMessageQueue(
					currentTransition, ctx);
			IncomingVariableCollector.removeUsedMessageQueue(ctx);
		}
	}

	private static boolean hasMessageTriggers(Transition currentTransition) {
		return currentTransition.getTriggers().size() != 0;
	}

	private static boolean hasTimeoutTrigger(Transition t) {
		return t.getTimerPort() != null;
	}
}
