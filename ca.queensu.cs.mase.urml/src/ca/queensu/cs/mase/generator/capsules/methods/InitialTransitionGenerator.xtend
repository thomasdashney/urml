package ca.queensu.cs.mase.generator.capsules.methods

import ca.queensu.cs.mase.urml.Transition
import ca.queensu.cs.mase.urml.State_
import ca.queensu.cs.mase.urml.StateMachine
import ca.queensu.cs.mase.urml.Capsule
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2
import java.util.Map

class InitialTransitionGenerator {
	var Transition init
	var Map<Transition, Integer> nonameTrans
	
	new(Transition init, Map<Transition, Integer> nonameTrans) {
		this.init = init
		this.nonameTrans = nonameTrans
	}
	
	public def generate() '''
		«genInitMethod»
	'''

	/**
	 * Generate the initial transition chain
	 * @return generated code
	 */
	private def genInitMethod() '''
		/**
		 * Initial transition chain
		 */
		public void startInit() {
			synchronized (lock) {
				«init.genInitMethod2»
			}
		}
	'''

	/**
	 * Generate the initial transition chain
	 * @param init the initial transition
	 * @return generated code
	 */
	private def genInitMethod2(Transition init) {
		var result = ''
		var State_ state
		if (init != null) {
			var initname = genName(init)
			result = result + '''
				_tran_«initname».action.accept(new ArrayList<>());
			'''
			state = init.to
			result = result + '''
				currentState = _state_«state.name»;
				_state_«state.name».entry.run();
			'''
			while (state.substatemachine != null) {
				var sm = state.substatemachine
				var subInitial = sm.findInit
				if (subInitial == null)
					throw new NoInitialTransitionInStateMachineException
				var subInitialname = genName(subInitial)
				result = result + '''
					_tran_«subInitialname».action.accept(new ArrayList<>());
				'''
				state = subInitial.to
				result = result + '''
					currentState = _state_«state.name»;
					_state_«state.name».entry.run();
				'''
			}
		}
		return result
	}

	private def genName(Transition t) {
		if (t.name == null)
			"_noname_" + nonameTrans.get(t)
		else
			t.name
	}
	
	/**
	 * Find the initial transition for the given state machine
	 * @param sm the given state machine
	 * @return the initial transition of sm
	 */
	private def findInit(StateMachine sm) {
		var c = sm.container(Capsule)
		if (c != null)
			for (t : sm.transitions)
				if (t.init)
					return t
		return null
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

class NoInitialTransitionInStateMachineException extends RuntimeException {
}