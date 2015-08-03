package ca.queensu.cs.mase.generator.promelaStructs

import ca.queensu.cs.mase.urml.Connector
import org.eclipse.xtend.lib.annotations.Accessors

/*
 * Promela channel
 */
@Accessors class Channel {
	Connector connector
	
	new(Connector connector) {
		this.connector = connector
	}
}