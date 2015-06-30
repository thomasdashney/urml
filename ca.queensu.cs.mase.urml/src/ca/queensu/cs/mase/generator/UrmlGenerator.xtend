package ca.queensu.cs.mase.generator

import ca.queensu.cs.mase.urml.Model
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import ca.queensu.cs.mase.urml.Capsule

class UrmlGenerator implements IGenerator {
	var Model model

	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		model = resource.contents.get(0) as Model
		var contents = '''
			«FOR capsule : model.capsules»
			proctype «capsule.name»() {
			}
			«ENDFOR»
		''';
		
		fsa.generateFile(model.name + ".prom", contents);
		
				
	}
}