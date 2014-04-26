package ca.queensu.cs.mase.interpreter.filters;

import java.time.Instant;
import java.util.function.Predicate;

import ca.queensu.cs.mase.interpreter.data.CapsuleContext;
import ca.queensu.cs.mase.urml.Port;
import ca.queensu.cs.mase.urml.Signal;
import ca.queensu.cs.mase.urml.TimerPort;
import ca.queensu.cs.mase.urml.Transition;
import ca.queensu.cs.mase.urml.Trigger_in;
import ca.queensu.cs.mase.util.MessageDesc;

public class TriggerPredicates {
	public static Predicate<Transition> hasNoTriggersDefined() {
		return t -> t.getTriggers().size() == 0 && t.getTimerPort() == null;
	}

	public static Predicate<Transition> hasActivatedMessages(CapsuleContext ctx) {
		return t -> {
			for (Trigger_in ti : t.getTriggers()) {
				Port transPort = ti.getFrom();
				Signal transSignal = ti.getSignal();
				MessageDesc msg = ctx.getMessageQueue().peek();
				if (msg != null && transPort == msg.getPort()
						&& transSignal == msg.getSignal()) {
					return true;
				}
			}
			return false;
		};

	}

	public static Predicate<Transition> hasActivatedTimeouts(CapsuleContext ctx) {
		return t -> {
			TimerPort timerPort = t.getTimerPort();
			if (timerPort != null) {
				if (ctx.getTimeoutInstants().containsKey(timerPort)) {
					Instant timeoutInstant = ctx.getTimeoutInstants().get(
							timerPort);
					if (Instant.now().isAfter(timeoutInstant)) {
						ctx.getTimeoutInstants().remove(timerPort);
						return true;
					}
				}
			}
			return false;
		};
	}
}
