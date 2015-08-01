package ca.queensu.cs.mase.generator
import org.eclipse.xtend.lib.annotations.Accessors

/*
 * Promela process
 */
@Accessors class Process {
	CapsuleInstNode instanceNode
	
	new(CapsuleInstNode instanceNode) {
		this.instanceNode = instanceNode
	}
	
	/*
	 * Process name should be the name of the instance
	 * preceded by its ancestor instance's names
	 */
	public def name() { return instanceNode.name }
}