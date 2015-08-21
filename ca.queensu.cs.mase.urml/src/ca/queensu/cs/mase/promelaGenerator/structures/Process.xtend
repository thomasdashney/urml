package ca.queensu.cs.mase.promelaGenerator.structures
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List
import ca.queensu.cs.mase.urml.Capsule

import org.eclipse.xtext.EcoreUtil2
import ca.queensu.cs.mase.urml.State_
import com.google.common.collect.Multimap
import org.eclipse.xtext.xbase.typesystem.util.Multimaps2
import org.eclipse.emf.ecore.EObject
import ca.queensu.cs.mase.urml.Transition

/*
 * Promela process
 */
@Accessors abstract class Process {	
	List<Channel> channels = newArrayList
	List<State_> states = newArrayList
	List<Transition> transitions = newArrayList
	Multimap<State_, Transition> outgoingTransitions = Multimaps2.newLinkedHashListMultimap
	
	public abstract def String name()
	
	public abstract def Capsule capsuleType()
	
	/**
	 * init() must be called by implemented class constructor after
	 * the capsule type has been set.
	 */
	protected def init() {
		states = contained(State_)
		transitions = contained(Transition)
		findOutgoingTransitions()
	}
	
	/**
	 * Returns a list of all objects that is contained
	 * by the EObject t
	 * @param the container of the objects to be returned
	 * @return the objects that is contained by t
	 */
	private def <T extends EObject> contained(Class<T> t) {
		EcoreUtil2.getAllContentsOfType(capsuleType, t)
	}
	
	/**
	 * Returns the initial transition from the current capsule
	 * @return the initial transition of the capsule
	 */
	public def State_ getInitialState() {
		if (!hasStates)
			return null
		val stateMachine = capsuleType.statemachines.get(0)
		for (transition : stateMachine.transitions) {
			if (transition.init)
				return transition.to
		}
		return null
	}
	
	public def Boolean getHasStates() {
		if (capsuleType.statemachines.size == 0)
			return false
		return true
	}
	
	/**
	 * Find the outgoing transitions for each state in the
	 * capsule
	 * @return a multimap containing a state mapping to 
	 * a list of outgoing transitions of that state
	 */
	private def findOutgoingTransitions() {
		for (t : transitions)
			if (!t.init)
				outgoingTransitions.put(t.from, t)
	}
}