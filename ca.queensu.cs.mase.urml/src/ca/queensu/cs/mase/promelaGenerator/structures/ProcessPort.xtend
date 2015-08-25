package ca.queensu.cs.mase.promelaGenerator.structures
import org.eclipse.xtend.lib.annotations.Accessors
import ca.queensu.cs.mase.urml.Port

/**
 * Represents a process-port combination for the sake of
 * creating connections for channels by way of relay ports
 */
@Accessors class ProcessPort {
	Process process
	Port port
	
	new(Process process, Port port) {
		this.process = process
		this.port = port
	}
}