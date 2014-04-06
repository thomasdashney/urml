package ca.queensu.cs.mase.util;

import org.eclipse.emf.common.util.EList;

import ca.queensu.cs.mase.types.Value;
import ca.queensu.cs.mase.urml.Port;
import ca.queensu.cs.mase.urml.Signal;

public class MessageDesc {
	public Port getPort() {
		return port;
	}

	public Signal getSignal() {
		return signal;
	}

	public EList<Value> getParameters() {
		return parameters;
	}

	private Port port;
	private Signal signal;
	private EList<Value> parameters;

	private MessageDesc() {
		// no-op
	}
	
	public static MessageDesc create(Port p, Signal s, EList<Value> para) {
		return new MessageDesc(p, s, para);
	}
	
	private MessageDesc(Port p, Signal s, EList<Value> para) {
		port = p;
		signal = s;
		parameters = para;
	}

	@Override
	public String toString() {
		return "port: " + port + " signal: " + signal + " parameters: "
				+ parameters;
	}
}
