package ca.queensu.cs.mase.generator

import ca.queensu.cs.mase.urml.Model
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import ca.queensu.cs.mase.urml.Attribute
import ca.queensu.cs.mase.promelaGenerator.structures.Process
import ca.queensu.cs.mase.promelaGenerator.structures.PromelaModel
import ca.queensu.cs.mase.promelaGenerator.utils.ExpressionGenerator
import ca.queensu.cs.mase.urml.Expression

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
		«model.rootProcess.compile»
		«FOR process : model.processes»
		«process.compile»
		«ENDFOR»
	'''
	
	private def compile(Process process) '''
		active proctype «process.name»() {
			«FOR a : process.capsuleType.attributes»
			«a.type» «a.name»«IF a.defaultValue != null» = «a.defaultValue.express»«ENDIF»
			«ENDFOR»
		}
	'''

	/**
	 * Returns the primitive type of the attribute
	 * @op the attribute
	 * @return a string represents the primitive type of 
	 * the attribute
	 */
	private def type(Attribute op) {
		if (op.isInt)
			'int'
		else if (op.isBool)
			'bool'
	}
	
	/**
	 * Compiles the expression
	 * @param ex the expression
	 * @return string expressing ex
	 */
	private def express(Expression ex) {
		new ExpressionGenerator().express(ex)
	}
}