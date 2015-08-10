package ca.queensu.cs.mase.generator.promelaStructs

import ca.queensu.cs.mase.urml.Connector
import org.eclipse.xtend.lib.annotations.Accessors
import ca.queensu.cs.mase.urml.Protocol

/*
 * Promela channel
 * (Conceptually the same as a URML connector)
 * 
 * Connects two processes together
 * 
 */
@Accessors class Channel {
	Process process1
	Process process2
	private Connector connector
	private Protocol protocol
	
	new(Connector connector) {
		this.connector = connector
		protocol = connector.port1.protocol
	}
	
	new(Connector connector, Process process1, Process process2) {
		this.connector = connector
		this.process1 = process1
		this.process2 = process2
		protocol = connector.port1.protocol
	}
	
	/**
	 * Name should be "channel" followed by each process name, separated by underscores
	 */
	public def String name() 
		'''«process1.name».«connector.port1.name»_«process2.name».«connector.port2.name»'''
}