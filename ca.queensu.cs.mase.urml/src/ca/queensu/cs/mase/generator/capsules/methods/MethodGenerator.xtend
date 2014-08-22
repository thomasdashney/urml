package ca.queensu.cs.mase.generator.capsules.methods

import java.util.List
import ca.queensu.cs.mase.urml.State_
import com.google.common.collect.Multimap
import ca.queensu.cs.mase.urml.Transition
import java.util.Map

class MethodGenerator {
	var List<State_> allStates
	var List<Transition> allTransitions
	var Transition initialTransition
	var Multimap<State_, Transition> outgoingTransitions
	var Map<Transition, Integer> nonameTrans
	
	new(List<State_> allStates, 
		List<Transition> allTransitions, 
		Transition inititalTransition, 
		Multimap<State_, Transition> outgoingTransitions, 
		Map<Transition, Integer> nonameTrans
	) {
		this.allStates = allStates
		this.allTransitions = allTransitions
		this.initialTransition = initialTransition
		this.outgoingTransitions = outgoingTransitions
		this.nonameTrans = nonameTrans
	}
	
	public def generate() '''
		«new FindNextTransitionGenerator(allStates, 
			outgoingTransitions, nonameTrans).generate»
		«new InitialTransitionGenerator(initialTransition, 
			nonameTrans).generate»
		«new ExecuteTransitionGenerator(allTransitions, 
			nonameTrans).generate»	
	'''
}