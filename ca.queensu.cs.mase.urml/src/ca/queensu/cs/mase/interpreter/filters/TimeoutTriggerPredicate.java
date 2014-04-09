package ca.queensu.cs.mase.interpreter.filters;

import java.time.Instant;
import java.util.function.Predicate;

import ca.queensu.cs.mase.interpreter.data.CapsuleContext;
import ca.queensu.cs.mase.urml.TimerPort;
import ca.queensu.cs.mase.urml.Transition;

public class TimeoutTriggerPredicate implements Predicate<Transition> {
	private CapsuleContext ctx;
	public TimeoutTriggerPredicate(CapsuleContext ctx_) {
		ctx = ctx_;
	}
	
	@Override
	public boolean test(Transition t) {
		TimerPort timerPort = t.getTimerPort();
		if (timerPort != null) {
			if (ctx.getTimeoutInstants().containsKey(timerPort)) {
				Instant timeoutInstant = ctx.getTimeoutInstants().get(timerPort);
				if (Instant.now().isAfter(timeoutInstant)) {
					ctx.getTimeoutInstants().remove(timerPort);
					return true;
				}
			}
		}
		return false;
	}
}
