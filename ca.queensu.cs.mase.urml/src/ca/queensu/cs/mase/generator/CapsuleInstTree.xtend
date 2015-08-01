package ca.queensu.cs.mase.generator

import org.eclipse.xtend.lib.annotations.Accessors
import ca.queensu.cs.mase.urml.Capsule
import java.util.List

/**
 * CapsuleInstTree.xtend
 * 
 * @Description Tree structure. Points to the root capsule, as well
 * as the top instances nodes within the root capsule.
 * The tree can be traversed by accessing the children
 * nodes of the top instances.
 * 
 * This is useful for traversing the ancestors of
 * instances (this isn't possible simply using the
 * xtend API--or at least, it doesn't seem to be)
 */
@Accessors class CapsuleInstTree {
	Capsule rootCapsule
	List<CapsuleInstNode> topInstances
	
	new() {
		topInstances = newArrayList
	}
	
	new(Capsule rootCapsule) {
		this.rootCapsule = rootCapsule
		topInstances = newArrayList
	}
}