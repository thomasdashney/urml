package ca.queensu.cs.mase.interpreter;

import ca.queensu.cs.mase.urml.Port;

public class CapsuleContextPortPair {
	private CapsuleContext capsuleContext;
	private Port port;
	
	private CapsuleContextPortPair() {
		// no-op
	}
	
	CapsuleContextPortPair(CapsuleContext capsuleContext, Port port) {
		this.capsuleContext = capsuleContext;
		this.port = port;
	}
	
	public static CapsuleContextPortPair create(CapsuleContext capsuleContext, Port port) {
		return new CapsuleContextPortPair(capsuleContext, port);
	}
	
	public CapsuleContext getCapsuleCB() {
		return capsuleContext;
	}
	
	public Port getPort() {
		return port;
	}
}
