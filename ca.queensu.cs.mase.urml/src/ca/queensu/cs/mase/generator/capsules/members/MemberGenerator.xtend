package ca.queensu.cs.mase.generator.capsules.members

import ca.queensu.cs.mase.urml.Capsule
import java.util.List
import ca.queensu.cs.mase.urml.State_
import ca.queensu.cs.mase.urml.Transition
import java.util.Map

class MemberGenerator {
	var Capsule cap
	var List<State_> allStates
	var List<Transition> allTransitions
	var Map<Transition, Integer> nonameTrans
	
	new(Capsule capsule, 
		List<State_> state_s, 
		List<Transition> transitions, 
		Map<Transition, Integer> map
	) {
		this.cap = capsule
		this.allStates = state_s
		this.allTransitions = transitions
		this.nonameTrans = map
	}
	
	public def generate() '''
		«new ListGenerator(cap).generate»
		«new StateDefineGenerator(allStates).generate»
		«new TransitionDefineGenerator(
			allTransitions, nonameTrans).generate»	
	'''
	
}