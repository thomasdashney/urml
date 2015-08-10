package ca.queensu.cs.mase.generator.promelaStructs
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List

/*
 * Promela process
 */
@Accessors abstract class Process {	
	List<Channel> channels
	
	/*
	 * A process should have a name
	 */
	public abstract def String name()
	
	new() {
		channels = newArrayList
	}
}