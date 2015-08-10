package ca.queensu.cs.mase.generator.promelaStructs
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List
import ca.queensu.cs.mase.urml.Capsule
import ca.queensu.cs.mase.urml.CapsuleInst
import java.util.Map

@Accessors class PromelaModel {
	RootProcess rootProcess
	List<InstanceProcess> processes
	List<Channel> channels
	// map capsuleInsts to corresponding processes
	// in order to speed up traversal
	private Map<CapsuleInst, Process> instanceMap
	
	/**
	 * Creates a new promela model from a URML root capsule (xtext)
	 */
	def static PromelaModel modelFromRootCapsule(Capsule rootCapsule) {
		var model = new PromelaModel()
		model.instanceMap = newHashMap
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
		createChannels(rootCapsule)
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
			instanceMap.put(it, newProcess) // add to map
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
			instanceMap.put(it, newProcess) // add to map
			processes.add(newProcess)
			newProcess.parent = process
			process.children.add(newProcess)
			createChildProcesses(newProcess)
		]
	}
	
	/**
	 * Note: O(n2) efficiency. Could be improved in future
	 * 
	 * Algorithm: 
	 * - given a capsule to create channels from (starting from root):
	 * 		- for each connector in capsule model
	 * 			- find the actual capsule instances it connects to
	 * 			- find the corresponding processes from the instance map
	 * 			- if the channel has not already been created, 
	 * 				create it, link the processes and add it to the global list
	 */
	private def void createChannels(Capsule rootCapsule) {
		channels = newArrayList
		for (connector : rootCapsule.connectors) {
			var Process process1 = null
			var Process process2 = null
			// if either of the connector's capsule instances
			// are null, then the port resides in the current (root) capsule
			if (connector.capsuleInst1 == null)
				process1 = rootProcess
			else // naive. TODO: take into account relay ports
				process1 = instanceMap.get(connector.capsuleInst1)
			if (connector.capsuleInst2 == null)
				process2 = rootProcess
			else // naive. TODO: take into account relay ports
				process2 = instanceMap.get(connector.capsuleInst2)
				
			// create channel
			val channel = new Channel(connector, process1, process2)
			// add to relevant lists
			channels.add(channel)
			process1.channels.add(channel)
			process2.channels.add(channel)
		}
	}
}