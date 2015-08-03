package ca.queensu.cs.mase.generator.helperStructs

import org.eclipse.xtend.lib.annotations.Accessors
import ca.queensu.cs.mase.urml.CapsuleInst
import java.util.List

/**
 * CapsuleInstNode.xtend
 * 
 * @Description Tree structure. Instances can contain
 * other instances as children, but can only have one
 * instance as a parent.
 * 
 * This is useful for traversing the ancestors of
 * instances (this isn't possible simply using the
 * xtend API--or at least, it doesn't seem to be)
 */
@Accessors class CapsuleInstNode {
	CapsuleInst instance
	CapsuleInstNode parent
	List<CapsuleInstNode> children
	
	new(CapsuleInst instance) {
		children = newArrayList
		this.instance = instance
	}
	
	new(CapsuleInst instance, CapsuleInstNode parent) {
		children = newArrayList
		this.instance = instance
		this.parent = parent
	}
	
	/*
	 * name should be the name of the instance
	 * preceded by its ancestor instance's names
	 */
	public def String name() {
		if (parent == null)
			return instance.name
		'''«parent.name»_«instance.name»'''
	}
}