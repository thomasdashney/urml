package ca.queensu.cs.mase.interpreter.filters;

import java.util.function.Predicate;

import ca.queensu.cs.mase.interpreter.data.CapsuleContext;
import ca.queensu.cs.mase.urml.Port;
import ca.queensu.cs.mase.urml.Signal;
import ca.queensu.cs.mase.urml.Transition;
import ca.queensu.cs.mase.urml.Trigger_in;
import ca.queensu.cs.mase.util.MessageDesc;

public class MessageTriggerPredicate implements Predicate<Transition> {
	private CapsuleContext ctx;

	public MessageTriggerPredicate(CapsuleContext ctx_) {
		ctx = ctx_;
	}

	@Override
	public boolean test(Transition t) {
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
	}
}
