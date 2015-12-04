package ca.queensu.cs.mase.promelaGenerator.structures
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List
import ca.queensu.cs.mase.urml.Capsule
import ca.queensu.cs.mase.urml.CapsuleInst
import java.util.Map
import ca.queensu.cs.mase.urml.Protocol
import static extension ca.queensu.cs.mase.promelaGenerator.utils.TraversalTools.*
import ca.queensu.cs.mase.urml.Model
import ca.queensu.cs.mase.urml.Connector
import ca.queensu.cs.mase.urml.Port

@Accessors class PromelaModel {
	RootProcess rootProcess
	Model model // urml model
	List<InstanceProcess> processes = newArrayList
	List<Channel> channels = newArrayList
	// map capsuleInsts to corresponding processes
	// in order to speed up traversal
	private Map<CapsuleInst, Process> instanceMap = newHashMap
	private List<Connector> reachedConnectors = newArrayList
	
	/**
	 * Creates a new promela model from a URML root capsule (xtext)
	 */
	def static PromelaModel modelFromUrmlModel(Model model) {
		var promelaModel = new PromelaModel()
		promelaModel.build(model)
		return promelaModel
	}
	
	/**
	 * Builds the promela model given an instance tree
	 * 
	 * - Populates Process objects from the instance nodes
	 * - On each Process, will populate its in/outgoing channels
	 * - Will populate the global "channels" as it creates each process object
	 */
	private def void build(Model model) {
		this.model = model
		val capsules = model.capsules
		val rootCapsule = capsules.filter[root].head
		// recursively create all of the processes
		createProcesses(rootCapsule)
		// create each of the channels. it's important that this is done
		// after all of the processes have been created
		createChannels(rootProcess)
	}
	
	/**
	 * Given the root capsule, will create all processes
	 * from the contained capsule instances, additionally
	 * adding them to the global list
	 */
	private def void createProcesses(Capsule rootCapsule) {
		this.rootProcess = new RootProcess(rootCapsule)
		// add the root processes
		rootCapsule.capsuleInsts.forEach[
			val newProcess = new InstanceProcess(it)
			instanceMap.put(it, newProcess) // add to map
			processes.add(newProcess)
			this.rootProcess.children.add(newProcess)
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
	 * Recursively creates channels for process and its child processes
	 */
	private def void createChannels(Process process) {
		for (connector : process.capsuleType.connectors.filter[!isMarked]) {
			connector.mark
			var ProcessPort processPort1 = null
			var ProcessPort processPort2 = null
			// if either of the connector's capsule instances
			// are null, then the port resides in the current capsule
			// it could not possibly be connected to a parent by relay because
			// this connection would have already been made in previous createChannels() calls
			// (because it goes top-down, and all parent connectors have already been marked)
			if (connector.capsuleInst1 == null) 
				processPort1 = new ProcessPort(process, connector.port1)
			else // use algorithm to find relay-connected process
				processPort1 = getConnectedSubProcess(process, connector.capsuleInst1.process as InstanceProcess, connector.port1)
			if (connector.capsuleInst2 == null)
				processPort2 = new ProcessPort(process, connector.port2)
			else // use algorithm to find relay-connected process (or simply the sub-capsule)
				processPort2 = getConnectedSubProcess(process, connector.capsuleInst2.process as InstanceProcess, connector.port2)
			// create channel
			val protocol = connector.port1.protocol
			for (signal : protocol.incomingMessages + protocol.outgoingMessages) {
				val channel = new Channel(processPort1, processPort2, signal)
				// map the port to the channel on the process
				processPort1.process.portChannels.put(processPort1.port, channel)
				processPort2.process.portChannels.put(processPort2.port, channel)
				
				// add to relevant lists
				channels.add(channel)
				processPort1.process.channels.add(channel)
				processPort2.process.channels.add(channel)
			}
		}
		
		process.children.forEach[createChannels]
	}
	
	/**
	 * Marks a connector as being reached
	 */
	private def mark(Connector connector) {
		reachedConnectors.add(connector)
	}
	
	/**
	 * Returns true if the given connector is marked
	 * (that is--it has been reached)
	 */
	private def boolean getIsMarked(Connector connector) {
		if (reachedConnectors.contains(connector))
			true
		else
			false
	}
	
	/**
	 * Returns a capsule instance's corresponding process
	 * (useful as an extension method)
	 */
	private def getProcess(CapsuleInst capsuleInst) {
		return instanceMap.get(capsuleInst)
	}
	
	/**
	 * Given a parent process, subprocess and port that the subprocess is connected by,
	 * will return the connected sub-process by checking for relay ports.
	 * 
	 * It may simply return the sub-process if there is no relay connected ports
	 * 
	 * Rather than return the Process, it actually returns a ProcessPort--that is,
	 * a structure containing both the connected process and the port on that process
	 * in which the process is connected by.
	 */
	private def ProcessPort getConnectedSubProcess(Process parentProcess, InstanceProcess subProcess, Port port) {
		val connector = findRelayConnector(subProcess, port)
		if (connector == null) {
			// there is no relay port here, so return current process
			return new ProcessPort(subProcess, port)
		}
		
		// note: connector can not possibly be marked because the algorithm
		// doesn't allow this connector to be reached before this point
		connector.mark
		
		// we know this is a relay port
		val newPort = connectedPort(connector, port)
		val newProcess = connector.connectedCapsuleInst(subProcess.capsuleInstance).process
		return getConnectedSubProcess(subProcess, newProcess as InstanceProcess, newPort)
	}
	
	/**
	 * Given a process and a port, will find the connector where that port is used
	 * If the port is not used, it returns null
	 */
	private def Connector findRelayConnector(Process process, Port port) {
		for (connector : process.capsuleType.connectors) {
			if (connector.port1 == port || connector.port2 == port)
				return connector
		}
		return null
	}
	
	/**
	 * Given a connector and a port, returns the opposite port in the connector
	 */
	 private def Port connectedPort(Connector connector, Port port) {
	 	if (connector.port1 == port)
	 		return connector.port2
	 	else if (connector.port2 == port)
	 		return connector.port1
	 	else 
	 		return null // port not even connected to connector
	 }
	
	/**
	 * Given a connector and the connector's containing capsule,
	 * it will return the connected capsule instance
	 */
	 private def CapsuleInst connectedCapsuleInst(Connector connector, CapsuleInst capsuleInst) {
	 	if (connector.capsuleInst1 == capsuleInst || connector.capsuleInst1 == null)
	 		return connector.capsuleInst2
	 	else if (connector.capsuleInst2 == capsuleInst || connector.capsuleInst2 == null)
	 		return connector.capsuleInst1
	 	else 
	 		return null // capsuleInst not even connected to connector
	 }
	
	/**
	 * Returns a list of all possible protocol signal (message)
	 * names. If two different protocols have signals with identical names,
	 * it will remove the duplicates.
	 */
	public def List<String> getProtocolMethodNames() {
		val protocols = model.contained(Protocol)
		var strings = newArrayList
		for (protocol : protocols) {
			val messages = protocol.incomingMessages + protocol.outgoingMessages
			for (signal : messages) {
				if (!strings.contains(signal.name))
					strings.add(signal.name)
			}
		}
		return strings
	}
}