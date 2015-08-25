package ca.queensu.cs.mase.promelaGenerator.utils

import ca.queensu.cs.mase.urml.State_
import ca.queensu.cs.mase.promelaGenerator.structures.Process
import org.eclipse.emf.ecore.EObject
import ca.queensu.cs.mase.urml.Transition
import java.util.Collection
import ca.queensu.cs.mase.urml.SendTrigger
import ca.queensu.cs.mase.promelaGenerator.structures.Channel

/**
 * Used to compile a state, given its contained process
 */
class StateGenerator {
	State_ state
	Process process
	Collection<Transition> outgoingTransitions
	
	new(State_ state, Process process) {
		this.state = state
		this.process = process
		this.outgoingTransitions = process.outgoingTransitions.get(state)
	}
	
	/**
	 * Returns a string of the compiled state within its process
	 */
	public def String compile() '''
		«state.name»:
			«IF state.entryCode != null»
				«FOR statement : state.entryCode.statements»
					«statement.state»
				«ENDFOR»
			«ENDIF»
			«IF outgoingTransitions.length > 0»
			if
				«FOR transition : outgoingTransitions»
					::(true)
						«IF transition.action != null»
						«FOR statement : transition.action.statements»
							«IF statement instanceof SendTrigger»
								«(statement as SendTrigger).compile»
							«ELSE»
								«statement.state»
							«ENDIF»
						«ENDFOR»
						«ENDIF»
				«ENDFOR»
			fi
			«ENDIF»
			«IF state.final»
			goto process_termination
			«ENDIF»
	'''
	
	/**
	 * Compiles the statement
	 * @param obj the statement
	 * @return string expressing the statement
	 */
	private def state(EObject obj) {
		new StatementGenerator().state(obj)
	}
	
	/**
	 * Compiles the trigger statement (send a message)
	 * @param trigger the trigger
	 * @return string expressing the statement
	 */
	private def compile(SendTrigger sendTrig) '''
		«FOR trigger : sendTrig.triggers»
			«FOR channel : process.portChannels.get(trigger.to)»
				«channel.name»!«trigger.signal.name»
			«ENDFOR»
		«ENDFOR»
	'''
}