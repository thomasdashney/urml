package ca.queensu.cs.mase.generator

import ca.queensu.cs.mase.urml.Model
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import ca.queensu.cs.mase.urml.Capsule
import java.util.List
import ca.queensu.cs.mase.generator.promelaStructs.Process
import ca.queensu.cs.mase.generator.promelaStructs.InstanceProcess
import ca.queensu.cs.mase.generator.promelaStructs.Channel

class UrmlGenerator implements IGenerator {
	var Model model

	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		model = resource.contents.get(0) as Model
		val capsules = model.capsules
		val rootCapsule = capsules.filter[root].head
		
		// build up a tree of CapsuleInstNodes. these can later
		// be used for easier traversal & channel building.
		val instanceTree = parseInstanceTree(rootCapsule)
		
		// get a list of promela process objects
		// (built from the instance tree)
		var processes = getProcesses(instanceTree)
		
		// get a list of all of the promela channel objects 
		// (built up from the instances)
		var channels = getChannels(processes)
		
		var channelString = '' //XXX
		
		// trim whitespace to satisfy tests w/ no channels
		if (channelString.toString.trim == '')
			channelString = '';
		
		var processString = '''
			active proctype «rootCapsule.name»() {
			}
			«FOR process : processes»
			active proctype «process.name»() {
				«process.compile»
			}
			«ENDFOR»
		''';
		
		// combine into one string (which will comprise the promela file)
		var contents = channelString + processString;
		
		fsa.generateFile(model.name + ".prom", contents)	
	}
	
	// given a root node, will return a new root node as a CapsuleInstNode
	private def CapsuleInstTree parseInstanceTree(Capsule rootCapsule) {
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
	private def void parseInstanceNode(CapsuleInstNode capsuleInstNode) {
		val capsule = capsuleInstNode.instance.type
		capsuleInstNode.children = newArrayList
		capsule.capsuleInsts.forEach[
			var newCapsuleInstNode = new CapsuleInstNode(it, capsuleInstNode)
			capsuleInstNode.children.add(newCapsuleInstNode)
			parseInstanceNode(newCapsuleInstNode)
		]
	}
	
	// recursively finds all of the instances contained within a given capsule
	// EXCEPT for the root capsule
	private def List<InstanceProcess> getProcesses(CapsuleInstTree instanceTree) {
		var processList = newArrayList()
		// recursively build up a list of all of the instances added together
		for (instanceNode : instanceTree.topInstances) {
			processList.add(new InstanceProcess(instanceNode))
			processList.addAll(getProcesses(instanceNode))
		}
		return processList
	}
	
	private def List<InstanceProcess> getProcesses(CapsuleInstNode instanceNode) {
		var processList = newArrayList()
		// recursively build up a list of all of the instances added together
		for (child : instanceNode.children) {
			processList.add(new InstanceProcess(child))
			processList.addAll(getProcesses(child))
		}
		return processList
	}
	
	private def compile(Process process) ''''''
	
	private def List<Channel> getChannels(List<InstanceProcess> processes) {
		var channels = newArrayList()
		for (process : processes) {
			val capsule = process.instanceNode.instance.type
			// for each connector
			for (connector : capsule.connectors) {
				channels.add(new Channel(connector))
			}
		}
		return channels; //XXX
	}
}