package ca.queensu.cs.mase.generator
import org.eclipse.xtend.lib.annotations.Accessors

import ca.queensu.cs.mase.generator.Process
import ca.queensu.cs.mase.urml.Capsule

@Accessors class RootProcess extends Process {
	Capsule rootCapsule
	
	new(Capsule rootCapsule) {
		this.rootCapsule = rootCapsule
	}
	
	/**
	 * Root process name should simply be the name of the root capsule
	 */
	public override String name() {
		return rootCapsule.name
	}
}