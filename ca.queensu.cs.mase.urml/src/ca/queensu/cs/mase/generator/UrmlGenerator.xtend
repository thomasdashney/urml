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
		
		var channelString = '' //XXX
		
		// trim whitespace to satisfy tests w/ no channels
		if (channelString.toString.trim == '')
			channelString = '';
		
		var processString = '''
			active proctype «promelaModel.rootProcess.name»() {
			}
			«FOR process : promelaModel.processes»
			active proctype «process.name»() {
				«process.compile»
			}
			«ENDFOR»
		''';
		
		// combine into one string (which will comprise the promela file)
		var contents = channelString + processString;
		
		fsa.generateFile(model.name + ".prom", contents)	
	}
	
	private def compile(Process process) ''''''
}