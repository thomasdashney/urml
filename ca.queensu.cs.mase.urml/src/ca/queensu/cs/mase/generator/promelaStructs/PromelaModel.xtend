package ca.queensu.cs.mase.generator.promelaStructs
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List
import ca.queensu.cs.mase.generator.helperStructs.CapsuleInstTree
import ca.queensu.cs.mase.generator.helperStructs.CapsuleInstNode

@Accessors class PromelaModel {
	RootProcess rootProcess
	List<InstanceProcess> processes
	
	/**
	 * Creates a new promela model from a URML instance tree
	 */
	def static PromelaModel modelFromInstanceTree(CapsuleInstTree tree) {
		var model = new PromelaModel()
		model.rootProcess = new RootProcess(tree.rootCapsule)
		model.processes = getProcesses(tree)
		return model
	}
	
	// recursively finds all of the instances contained within a given capsule
	// EXCEPT for the root capsule
	private static def List<InstanceProcess> getProcesses(CapsuleInstTree instanceTree) {
		var processList = newArrayList()
		// recursively build up a list of all of the instances added together
		for (instanceNode : instanceTree.topInstances) {
			processList.add(new InstanceProcess(instanceNode))
			processList.addAll(getProcesses(instanceNode))
		}
		return processList
	}
	
	private static def List<InstanceProcess> getProcesses(CapsuleInstNode instanceNode) {
		var processList = newArrayList()
		// recursively build up a list of all of the instances added together
		for (child : instanceNode.children) {
			processList.add(new InstanceProcess(child))
			processList.addAll(getProcesses(child))
		}
		return processList
	}
	
}