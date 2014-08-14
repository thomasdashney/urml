package ca.queensu.cs.mase.generator

import ca.queensu.cs.mase.urml.State_
import ca.queensu.cs.mase.urml.Transition
import java.util.Deque
import java.util.LinkedList
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2

class TransitionGenerator {

	var List<Transition> allTransitions

	new(List<Transition> allTrans) {
		allTransitions = allTrans
	}

	/**
	 * Generates code for executing transition
	 * @return generated code
	 */
	public def transitions() '''
		public boolean transitionAndIfFinal(
				Transition t, List<? extends CommonObj> params)  {
			synchronized (lock) {
				switch (t.name) {
					«FOR t : allTransitions»
						«IF !t.init»
							case "«t.name»":
								«t.genTransitionSwitchCase»
								currentState = _state_«t.to.name»;
								return «t.to.final»;
						«ENDIF»
					«ENDFOR»
					default:
						return false;
				}
			}
		}
	'''

	/**
	 * Generates the exit/action/entry code for transition
	 * chains using the least common ancestor algorithm
	 * 
	 * @param t the transition chain of which the code is
	 * to be generated
	 * @return generated code
	 */
	private def genTransitionSwitchCase(Transition t) {
		var result = ''
		var Deque<State_> fromWithAnc = t.from.getStatesWithAnc
		var Deque<State_> toWithAnc = t.to.getStatesWithAnc
		removeCommonAnc(fromWithAnc, toWithAnc)
		while (!fromWithAnc.empty)
			result = result + '''
				_state_«fromWithAnc.removeLast.name».exit.run();
			'''
		result = result + '''
			_tran_«t.name».action.accept(params);
		'''
		while (!toWithAnc.empty)
			result = result + '''
				_state_«toWithAnc.pop.name».entry.run();
			'''
		return result
	}

	/**
	 * Removes common ancestors of fromWithAnc and 
	 * toWithAnc
	 * @param fromWithAnc from state
	 * @param toWithAnc to state
	 */
	private def void removeCommonAnc(Deque<State_> fromWithAnc, Deque<State_> toWithAnc) {
		var State_ from
		var State_ to
		while (true) {
			from = fromWithAnc.peek
			to = toWithAnc.peek
			if (from != to || fromWithAnc.empty || toWithAnc.empty) {
				return
			}
			fromWithAnc.pop
			toWithAnc.pop
		}
	}

	/**
	 * Gets state along with its ancestors
	 * @param s specified state
	 * @return a list containing the state and its ancestors
	 */
	private def Deque<State_> getStatesWithAnc(State_ s) {
		var state = s
		var Deque<State_> statesWithAnc = new LinkedList
		while (state != null) {
			statesWithAnc.push(state)
			var parent = getContainer(state.eContainer, State_)
			state = parent
		}
		return statesWithAnc
	}

	/**
	 * Returns the container of obj, of which the container has
	 * the specified class
	 * @param obj the EObject to find whose container from
	 * @param t the type of the container
	 * @return the EObject that is the container of obj with the type t
	 */
	private def <T extends EObject> getContainer(EObject obj, Class<T> t) {
		EcoreUtil2.getContainerOfType(obj, t)
	}

//	/**
//	 * Expresses the expression ex
//	 * @param ex the expression
//	 * @return the string form of the expression
//	 */
//	private def express(Expression ex) {
//		new ExpressionGenerator().express(ex)
//	}
}
