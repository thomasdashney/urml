package ca.queensu.cs.mase.generator

import ca.queensu.cs.mase.urml.Model
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import ca.queensu.cs.mase.generator.promelaStructs.Process
import ca.queensu.cs.mase.generator.promelaStructs.PromelaModel

class UrmlGenerator implements IGenerator {
	var Model model

	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		model = resource.contents.get(0) as Model
		val capsules = model.capsules
		val rootCapsule = capsules.filter[root].head
		
		// create the promela model from the root capsule
		var promelaModel = PromelaModel.modelFromRootCapsule(rootCapsule)
		
		fsa.generateFile(model.name + ".prom", promelaModel.compile)	
	}
	
	private def compile(PromelaModel model) '''
		«FOR channel : model.channels»
		chan «channel.name»;
		«ENDFOR»
		«IF model.channels.length > 0 /* add space if channels */»
		
		«ENDIF»
		active proctype «model.rootProcess.name»() {
		}
		«FOR process : model.processes»
		«process.compile»
		«ENDFOR»
	'''
	
	private def compile(Process process) '''
		active proctype «process.name»() {
		}
	'''
}