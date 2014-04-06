package ca.queensu.cs.mase.interpreter.data;

import ca.queensu.cs.mase.urml.Port;

/**
 * A <capsule context, port> pair, to indicate a specific port in a specific
 * capsule instance in a model
 * 
 * @author Keith
 * 
 */
public class CapsuleContextPortPair {
	private CapsuleContext capsuleContext;
	private Port port;

	/**
	 * Constructor
	 * 
	 * @param capsuleContext
	 * @param port
	 */
	public CapsuleContextPortPair(CapsuleContext capsuleContext, Port port) {
		this.capsuleContext = capsuleContext;
		this.port = port;
	}

	/**
	 * @return the capsule context of the pair
	 */
	public CapsuleContext getCapsuleCtx() {
		return capsuleContext;
	}

	/**
	 * @return the port of the pair
	 */
	public Port getPort() {
		return port;
	}
}
