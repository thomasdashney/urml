package ca.queensu.cs.mase.generator.capsules

import ca.queensu.cs.mase.generator.capsules.constructors.ConstructorGenerator
import ca.queensu.cs.mase.generator.capsules.members.MemberGenerator
import ca.queensu.cs.mase.generator.capsules.methods.MethodGenerator
import ca.queensu.cs.mase.urml.Capsule
import ca.queensu.cs.mase.urml.State_
import ca.queensu.cs.mase.urml.Transition
import com.google.common.collect.Multimap
import java.util.HashMap
import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.xbase.typesystem.util.Multimaps2


/**
 * Genereator for a specific capsule.  The capsule in question
 * (i.e. the one to be compiled) is stored in the variable cap.
 * This will generate the file _C_«cap.name».java, where
 * «cap.name» is the name of the capsule.
 * @author Keith
 */
class CapsuleGenerator {

	var Capsule cap
	var List<State_> allStates
	var List<Transition> allTransitions
	var Multimap<State_, Transition> outgoingTransitions
	var Map<Transition, Integer> nonameTrans = new HashMap;
	
	new(Capsule capsule) {
		cap = capsule
		allStates = contents(State_)
		allTransitions = contents(Transition)
		outgoingTransitions = findOutgoingTransitions
	}	

	/**
	 * Compile code for a capsule
	 * @param capsule the capsule to be compiled
	 * @return generated code
	 */
	public def generate() '''
		«var initialTransition = getInit»
		«var constructors = new ConstructorGenerator(cap)»
		«var members = new MemberGenerator(cap, allStates, allTransitions, nonameTrans)»
		«var methods = new MethodGenerator(allStates, allTransitions, initialTransition, outgoingTransitions, nonameTrans)»
		«imports»
		/**
		 * The capsule class for «cap.name».
		 * @generated
		 */
		public class _C_«cap.name» extends Capsule {
			«constructors.generate»
			«members.generate»
			«methods.generate»
		}
	'''

	/**
	 * Import statements
	 * @return generated code
	 */
	private def imports() '''
		import java.util.*;
		import urml.runtime.*;
	'''

	/**
	 * Find the outgoing transitions for each state in the
	 * capsule
	 * @return a multimap containing a state mapping to 
	 * a list of outgoing transitions of that state
	 */
	private def findOutgoingTransitions() {
		var result = Multimaps2.newLinkedHashListMultimap
		for (t : allTransitions)
			if (!t.init)
				result.put(t.from, t)
		return result
	}

	/**
	 * Returns the initial transition from the current capsule
	 * @return the initial transition of the capsule
	 */
	private def getInit() {
		if (cap.statemachines.size == 0)
			return null
		var sm = cap.statemachines.get(0)
		for (t : sm.transitions)
			if (t.init)
				return t
		return null
	}

	/**
	 * Returns a list of all objects that is contained
	 * by the EObject t
	 * @param the container of the objects to be returned
	 * @return the objects that is contained by t
	 */
	private def <T extends EObject> contents(Class<T> t) {
		EcoreUtil2.getAllContentsOfType(cap, t)
	}
}
