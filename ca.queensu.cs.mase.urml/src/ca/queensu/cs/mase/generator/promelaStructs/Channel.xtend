package ca.queensu.cs.mase.generator.promelaStructs

import ca.queensu.cs.mase.urml.Connector
import org.eclipse.xtend.lib.annotations.Accessors

/*
 * Promela channel
 * (Conceptually the same as a URML connector)
 * 
 * Connects two processes together
 * 
 */
@Accessors class Channel {
	Process sender
	Process receiver
	private Connector connector
	
	new(Connector connector) {
		this.connector = connector
	}
	
	new(Connector connector, Process sender, Process receiver) {
		this.connector = connector
		this.sender = sender
		this.receiver = receiver
	}
}