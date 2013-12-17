package ca.queensu.cs.mase.util;

import org.eclipse.emf.common.util.EList;

import ca.queensu.cs.mase.urml.Port;
import ca.queensu.cs.mase.urml.Signal;

public class MessageInfo {
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

	private MessageInfo() {
		// no-op
	}
	
	public static MessageInfo create(Port p, Signal s, EList<Value> para) {
		return new MessageInfo(p, s, para);
	}
	
	private MessageInfo(Port p, Signal s, EList<Value> para) {
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
