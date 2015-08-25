package ca.queensu.cs.mase.promelaGenerator.structures

import ca.queensu.cs.mase.urml.Connector
import org.eclipse.xtend.lib.annotations.Accessors
import ca.queensu.cs.mase.urml.Protocol
import ca.queensu.cs.mase.urml.Port

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
	Port process1Port
	Port process2Port
	
	new(ProcessPort procPort1, ProcessPort procPort2) {
		this.process1 = procPort1.process
		this.process2 = procPort2.process
		this.process1Port = procPort1.port
		this.process2Port = procPort2.port
	}
	
	/**
	 * Name should be "channel" followed by each process name, separated by underscores
	 */
	public def String name() 
		'''«process1.name».«process1Port.name»_«process2.name».«process2Port.name»'''
}