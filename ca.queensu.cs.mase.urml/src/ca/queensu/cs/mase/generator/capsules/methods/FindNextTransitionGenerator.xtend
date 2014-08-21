package ca.queensu.cs.mase.generator.capsules.methods

import java.util.List
import ca.queensu.cs.mase.urml.State_
import com.google.common.collect.Multimap
import ca.queensu.cs.mase.urml.Transition
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2

class FindNextTransitionGenerator {
	var List<State_> allStates
	var Multimap<State_, Transition> outgoingTransitions
	var Map<Transition, Integer> nonameTrans

	new(List<State_> allStates, Multimap<State_, Transition> o, Map<Transition, Integer> nonameTrans) {
		this.allStates = allStates
		this.outgoingTransitions = o
		this.nonameTrans = nonameTrans
	}


	public def generate() '''
		«findNextTransitions»
	'''

	/**
	 * Find the possible next transitions for each state
	 * @return generated code
	 */
	private def findNextTransitions() '''
		/**
		 * Find the possible next transitions for each state
		 * @return outgoing transition for the current state
		 */
		public List<? extends Transition> findPossibleTrans() {
			switch (currentState.name) {
				«FOR state : allStates»
					case "«state.name»":
						return Arrays.asList(«state.genPossibleTrans»);
				«ENDFOR»
				default:
					return new ArrayList<>();
			}
		}
	'''

	/**
	 * Generate possible outgoing transitions from state s
	 * @param s the state
	 * @return generated code
	 */
	private def genPossibleTrans(State_ s) {
		var stateToGoThrough = s
		var result = ''
		do {
			for (t : outgoingTransitions.get(stateToGoThrough)) {
				var tname = genName(t)
				result = result + '_tran_' + tname + ', '
			}
			stateToGoThrough = container(stateToGoThrough.eContainer, State_)
		} while (stateToGoThrough != null)
		if (result.length > 2)
		result = result.substring(0,result.length-2)
		return result
	}

	private def genName(Transition t) {
		if (t.name == null)
			"_noname_" + nonameTrans.get(t)
		else
			t.name
	}

	/**
	 * Returns the container of the EObject obj with type
	 * t
	 * @param
	 */
	private def <T extends EObject> container(EObject obj, Class<T> t) {
		EcoreUtil2.getContainerOfType(obj, t)
	}
}