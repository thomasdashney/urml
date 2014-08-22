package ca.queensu.cs.mase.generator.capsules.members

import java.util.List
import ca.queensu.cs.mase.urml.State_
import org.eclipse.emf.ecore.EObject
import ca.queensu.cs.mase.generator.dispatchers.StatementGenerator

class StateDefineGenerator {
	var List<State_> allStates
	new(List<State_> allStates) {
		this.allStates = allStates
	}
	// STATES
	
	/**
	 * A state
	 * @return generated code
	 */
	public def generate() '''
		«FOR s : allStates»
			/**
			 * A state with name: «s.name»
			 */
			private State _state_«s.name» = new State(
			
				// name
				"«s.name»",
				
				// entry code
				() -> {
					«IF s.entryCode != null»
						«FOR st : s?.entryCode?.statements»
							«st.state»
						«ENDFOR»
					«ENDIF»
				},
				
				// exit code
				() -> {
					«IF s.exitCode != null»
						«FOR st : s?.exitCode?.statements»
							«st.state»
						«ENDFOR»
					«ENDIF»
				});
		«ENDFOR»	
	'''
	
	/**
	 * Compiles the statement
	 * @param obj the statement
	 * @return string expressing the statement
	 */
	private def state(EObject obj) {
		new StatementGenerator().state(obj)
	}
}