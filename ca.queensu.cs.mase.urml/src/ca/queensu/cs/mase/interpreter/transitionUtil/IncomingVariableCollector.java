package ca.queensu.cs.mase.interpreter.transitionUtil;

import java.util.HashMap;

import org.eclipse.emf.common.util.EList;

import ca.queensu.cs.mase.interpreter.data.CapsuleContext;
import ca.queensu.cs.mase.types.Value;
import ca.queensu.cs.mase.urml.IncomingVariable;
import ca.queensu.cs.mase.urml.Port;
import ca.queensu.cs.mase.urml.Signal;
import ca.queensu.cs.mase.urml.Transition;
import ca.queensu.cs.mase.urml.Trigger_in;
import ca.queensu.cs.mase.util.MessageDesc;

public class IncomingVariableCollector {
	static void collectTriggerVarsFromMessageQueue(Transition transition, CapsuleContext ctx) {
//		ctx.setTriggerIncomingVars(new HashMap<IncomingVariable, Value>());
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

	static void removeUsedMessageQueue(CapsuleContext ctx) {
		ctx.getMessageQueue().poll();
	}
}
