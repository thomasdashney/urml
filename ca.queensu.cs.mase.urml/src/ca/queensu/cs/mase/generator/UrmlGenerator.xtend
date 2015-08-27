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
import ca.queensu.cs.mase.promelaGenerator.utils.StateGenerator

class UrmlGenerator implements IGenerator {
	var Model model

	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		model = resource.contents.get(0) as Model
		
		// create the promela model from the root capsule
		var promelaModel = PromelaModel.modelFromUrmlModel(model)
		
		fsa.generateFile(model.name + ".prom", promelaModel.compile)	
	}
	
	private def compile(PromelaModel model) '''
		«FOR channel : model.channels»
		chan «channel.name» = [0] of {mtype};
		«ENDFOR»
		«IF model.channels.length > 0»
		mtype = {msg};
		
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
			«IF process.hasStates»
				goto «process.initialState.name»
				«FOR state : process.states»
					«(new StateGenerator(state, process)).compile»
				«ENDFOR»
				process_termination: skip
			«ENDIF»
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