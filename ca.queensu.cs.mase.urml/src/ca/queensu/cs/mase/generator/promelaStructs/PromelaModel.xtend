package ca.queensu.cs.mase.generator.promelaStructs
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List
import ca.queensu.cs.mase.urml.Capsule
import ca.queensu.cs.mase.urml.CapsuleInst

@Accessors class PromelaModel {
	RootProcess rootProcess
	List<InstanceProcess> processes
	List<Channel> channels
	
	/**
	 * Creates a new promela model from a URML root capsule (xtext)
	 */
	def static PromelaModel modelFromRootCapsule(Capsule rootCapsule) {
		var model = new PromelaModel()
		model.rootProcess = new RootProcess(rootCapsule)
		model.build(rootCapsule)
		return model
	}
	
	/**
	 * Builds the promela model given an instance tree
	 * 
	 * - Populates Process objects from the instance nodes
	 * - On each Process, will populate its in/outgoing channels
	 * - Will populate the global "channels" as it creates each process object
	 */
	private def void build(Capsule rootCapsule) {
		// recursively create all of the processes
		createProcesses(rootCapsule)
		// create each of the channels. it's important that this is done
		// after all of the processes have been created
		processes.forEach[createChannels]
	}
	
	/**
	 * Given the root capsule, will create all processes
	 * from the contained capsule instances, additionally
	 * adding them to the global list
	 */
	private def void createProcesses(Capsule rootCapsule) {
		processes = newArrayList
		// add the root processes
		rootCapsule.capsuleInsts.forEach[
			val newProcess = new InstanceProcess(it)
			processes.add(newProcess)
			newProcess.createChildProcesses			
		]
	}
	
	/**
	 * Given a Process, will create each of its child processes
	 * and properly link them using their 'parent' and 'children'
	 * properties
	 */
	private def void createChildProcesses(InstanceProcess process) {
		val capsule = process.capsuleInstance.type
		capsule.capsuleInsts.forEach[
			var newProcess = new InstanceProcess(it)
			processes.add(newProcess)
			newProcess.parent = process
			process.children.add(newProcess)
			createChildProcesses(newProcess)
		]
	}
	
	/**
	 * Note: O(n2) efficiency. Could be improved in future
	 * 
	 * Given a Process, will check to see if it has any connectors
	 * based on its corresponding capsule instance.
	 * 
	 * If so, it will first check to see if there is already a
	 * channel made for the connection. If not, it will create
	 * the channel, assign it to the given process (and 
	 * 
	 * If so, it will create a channel, assign it to the given process, and add
	 * the channel to the model's channel list.
	 * 
	 * If there
	 * 
	 */
	private def void createChannels(InstanceProcess process) {
		
	}
}