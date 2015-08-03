package ca.queensu.cs.mase.generator.promelaStructs
import org.eclipse.xtend.lib.annotations.Accessors
import ca.queensu.cs.mase.generator.CapsuleInstNode

@Accessors class InstanceProcess extends Process {
	CapsuleInstNode instanceNode
	
	new(CapsuleInstNode instanceNode) {
		this.instanceNode = instanceNode
	}
	
	/*
	 * Process name should be the name of the instance
	 * preceded by its ancestor instance's names
	 */
	public override String name() {
		return instanceNode.name
	}
}