package ca.queensu.cs.mase.promelaGenerator.structures
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List
import ca.queensu.cs.mase.urml.Capsule

import org.eclipse.xtext.EcoreUtil2
import ca.queensu.cs.mase.urml.State_

/*
 * Promela process
 */
@Accessors abstract class Process {	
	List<Channel> channels
	List<State_> states // doesn't include initial state
	
	public abstract def String name()
	
	public abstract def Capsule capsuleType()
	
	new() {
		channels = newArrayList
	}
	
	/**
	 * Sets the states on the process
	 */
	protected def findStates() {
		states = containedStates(capsuleType)
	}

	/**
	 * Returns a list of all objects that is contained
	 * by the EObject t
	 * @param the container of the objects to be returned
	 * @return the objects that is contained by t
	 */
	private def List<State_> containedStates(Capsule capsule) {
		EcoreUtil2.getAllContentsOfType(capsule, State_)
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
	
	public def getHasStates() {
		if (capsuleType.statemachines.size == 0)
			return false
		return true
	}
}