package ca.queensu.cs.mase.promelaGenerator.structures
import org.eclipse.xtend.lib.annotations.Accessors
import ca.queensu.cs.mase.urml.Capsule
import ca.queensu.cs.mase.urml.CapsuleInst

@Accessors class InstanceProcess extends Process {
	CapsuleInst capsuleInstance
	Process parent
	
	new(CapsuleInst capsuleInstance) {
		super()
		this.capsuleInstance = capsuleInstance
		init()
	}
	
	/*
	 * name should be the name of the instance
	 * preceded by its ancestor instance's names
	 */
	public override String name() {
		if (parent == null)
			return capsuleInstance.name
		'''«parent.name»_«capsuleInstance.name»'''
	}
	
	/**
	 * Returns type of capsule
	 */
	public override Capsule capsuleType() {
		return capsuleInstance.type
	}
}