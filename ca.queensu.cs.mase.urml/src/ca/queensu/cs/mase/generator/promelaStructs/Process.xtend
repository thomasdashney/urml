package ca.queensu.cs.mase.generator.promelaStructs
import org.eclipse.xtend.lib.annotations.Accessors

/*
 * Promela process
 */
@Accessors abstract class Process {	
	/*
	 * A process should have a name
	 */
	public abstract def String name()
}