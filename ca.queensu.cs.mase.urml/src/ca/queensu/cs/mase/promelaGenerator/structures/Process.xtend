package ca.queensu.cs.mase.promelaGenerator.structures
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List
import ca.queensu.cs.mase.urml.Capsule

/*
 * Promela process
 */
@Accessors abstract class Process {	
	List<Channel> channels
	
	State initialState
	List<State> states // doesn't include initial state
	
	public abstract def String name()
	
	public abstract def Capsule capsuleType()
	
	new() {
		channels = newArrayList
	}
}