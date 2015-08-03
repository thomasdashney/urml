package ca.queensu.cs.mase.generator.helperStructs

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
	
	public static def CapsuleInstTree treeFromRootCapsule(Capsule rootCapsule) {
		val instanceTree = new CapsuleInstTree
		
		// set initial tree values based on root capsule
		instanceTree.rootCapsule = rootCapsule
		rootCapsule.capsuleInsts.forEach[
			instanceTree.topInstances.add(new CapsuleInstNode(it))
		]
		
		instanceTree.topInstances.forEach[parseInstanceNode]
		
		return instanceTree
	}
	
	// given a capsule instance node, will parse each of its children recursively
	private static def void parseInstanceNode(CapsuleInstNode capsuleInstNode) {
		val capsule = capsuleInstNode.instance.type
		capsuleInstNode.children = newArrayList
		capsule.capsuleInsts.forEach[
			var newCapsuleInstNode = new CapsuleInstNode(it, capsuleInstNode)
			capsuleInstNode.children.add(newCapsuleInstNode)
			parseInstanceNode(newCapsuleInstNode)
		]
	}
}