package ca.queensu.cs.mase.promelaGenerator.structures
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List
import ca.queensu.cs.mase.urml.Capsule

import ca.queensu.cs.mase.urml.State_
import com.google.common.collect.Multimap
import org.eclipse.xtext.xbase.typesystem.util.Multimaps2
import ca.queensu.cs.mase.urml.Transition
import static extension ca.queensu.cs.mase.promelaGenerator.utils.TraversalTools.*
import ca.queensu.cs.mase.urml.Port

/*
 * Promela process
 */
@Accessors abstract class Process {	
	List<InstanceProcess> children = newArrayList
	
	List<Channel> channels = newArrayList
	List<State_> states = newArrayList
	List<Transition> transitions = newArrayList
	Multimap<State_, Transition> outgoingTransitions = Multimaps2.newLinkedHashListMultimap
	Multimap<Port, Channel> portChannels = Multimaps2.newLinkedHashListMultimap
	
	public abstract def String name()
	
	public abstract def Capsule capsuleType()
	
	/**
	 * init() must be called by implemented class constructor after
	 * the capsule type has been set.
	 */
	protected def init() {
		states = capsuleType.contained(State_)
		transitions = capsuleType.contained(Transition)
		findOutgoingTransitions()
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
	
	/**
	 * Returns true if the process (capsule) has states
	 */
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