package ca.queensu.cs.mase.generator.capsules

import ca.queensu.cs.mase.generator.dispatchers.ExpressionGenerator
import ca.queensu.cs.mase.generator.dispatchers.StatementGenerator
import ca.queensu.cs.mase.urml.Attribute
import ca.queensu.cs.mase.urml.Capsule
import ca.queensu.cs.mase.urml.Expression
import ca.queensu.cs.mase.urml.IncomingVariable
import ca.queensu.cs.mase.urml.LocalVar
import ca.queensu.cs.mase.urml.Operation
import ca.queensu.cs.mase.urml.StateMachine
import ca.queensu.cs.mase.urml.State_
import ca.queensu.cs.mase.urml.Transition
import com.google.common.collect.Multimap
import java.util.List
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
	public def compile() '''
		«var initialTransition = getInit»
		«imports»
		/**
		 * The capsule class for «cap.name».
		 * @generated
		 */
		public class _C_«cap.name» extends Capsule {
			«constructors»
			«listAttribOps»
			«listPorts»
			«listTimers»
			«listCapsuleInsts»
			«defineStates»
			«defineTransitions»
			«findNextTransitions»
			«initialTransition.genInitMethod»
			«new TransitionGenerator(allTransitions).transitions»
		}
	'''

	// IMPORTS
	/**
	 * Import statements
	 * @return generated code
	 */
	private def imports() '''
		import java.time.*;
		import java.util.*;
		import urml.runtime.*;
	'''

	// CONSTRUCTORS
	
	/**
	 * Constructors
	 * @return generated code
	 */
	private def constructors() '''
		/**
		 * Call this constructor when the capsule is a root
		 */
		public _C_«cap.name»() {
			this(null);
		}
		
		/**
		 * Call this constructor when the capsule is not a
		 * root
		 * @param parent_ the parent of the capsule
		 */
		public _C_«cap.name»(Capsule parent_) {
			this.parent = parent_;
			«registerPorts»
			«registerCapsuleInsts»
			«registerConnectors»
		}
	'''
	
	// REGISTERS
	
	/**
	 * Lists of message ports
	 * @return generated code
	 */
	private def registerPorts() '''
		internalports = Arrays.asList(
			«FOR port: cap.internalPorts SEPARATOR ', '»_p_«port.name»«ENDFOR»
		);
		
		externalports = Arrays.asList(
			«FOR port : cap.interfacePorts SEPARATOR ', '»_p_«port.name»«ENDFOR»
		);
	'''
	
	/**
	 * List of capsule instances that the current capsule has
	 * @return generated code
	 */
	private def registerCapsuleInsts() '''
		capsules = Arrays.asList(
			«FOR ci: cap.capsuleInsts SEPARATOR ', '»_ci_«ci.name»«ENDFOR»
		);
	'''

	/**
	 * List of connectors
	 * @return generated code
	 */
	private def registerConnectors() '''
		connectors = Arrays.asList(
			«FOR conn : cap.connectors SEPARATOR ', '»«var c1 = conn.capsuleInst1»«var c2 = conn.capsuleInst2»
				new Connector(
					
					// capsule 1
				«IF c1 == null»
					this,
				«ELSE»
					_ci_«c1.name»,
				«ENDIF»
					// port 1
				«IF c1 != null»
					((_C_«c1.type.name») _ci_«c1.name»).«ENDIF»_p_«conn.port1.name»,
					
					// capsule 2
				«IF c2 == null»
					this,
				«ELSE»
					_ci_«c2.name»,
				«ENDIF»
					// port 2
				«IF c2 != null»
					((_C_«c2.type.name») _ci_«c2.name»).«ENDIF»_p_«conn.port2.name»
				)
			«ENDFOR»
		);
	'''

	// STATES
	
	/**
	 * A state
	 * @return generated code
	 */
	private def defineStates() '''
		«FOR s : allStates»
			/**
			 * A state with name: «s.name»
			 */
			private State _state_«s.name» = new State(
			
				// name
				"«s.name»",
				
				// entry code
				() -> {
					«IF s.entryCode != null»
						«FOR st : s?.entryCode?.statements»
							«st.state»
						«ENDFOR»
					«ENDIF»
				},
				
				// exit code
				() -> {
					«IF s.exitCode != null»
						«FOR st : s?.exitCode?.statements»
							«st.state»
						«ENDFOR»
					«ENDIF»
				});
		«ENDFOR»	
	'''
	
	// TRANSITIONS

	/**
	 * A transition
	 * @return generated code
	 */
	private def defineTransitions() '''
		«FOR t : allTransitions»
			/**
			 * A transition with name: «t.name»
			 */
			private Transition _tran_«t.name» = new Transition(
			
				// name
				"«t.name»",
				
				// guard
				() -> {
					«IF t.guard == null»
						return true;
					«ELSE»
						return «t.guard.express»;
					«ENDIF»
				},
				
				// action code
				params -> {
					«IF t.triggers.size != 0»
						«FOR p : t.triggers.get(0).parameters»
							«var count = 0»
							«p.type» _i_«p.name» = ((«p.commonObjType») (params.get(«count»))).val;
							«{count = count + 1 ''}»
						«ENDFOR»
					«ENDIF»
					«IF t.action != null»
						«FOR st : t.action.statements»«st.state»«ENDFOR»
					«ENDIF»
				},
				
				// triggers
				Arrays.asList(
					«FOR trig: t.triggers SEPARATOR ','»
						new TriggerIn(
							_p_«trig.from.name», _P_«trig.from.protocol.name»._s_«trig.signal.name»
						)
					«ENDFOR»
				),
				
				// timer port
				«IF t.timerPort == null»
					null
				«ELSE»
					_tp_«t.timerPort.name»
				«ENDIF»
			);
		«ENDFOR»	
	'''	
	
	// LISTS

	/**
	 * Defines the message ports
	 * @return generated code
	 */
	private def listPorts() '''
		«FOR port: cap.internalPorts»
			MessagePort _p_«port.name» = new MessagePort("«port.name»", new _P_«port.protocol.name»());
		«ENDFOR»
		«FOR port: cap.interfacePorts»
			MessagePort _p_«port.name» = new MessagePort("«port.name»", new _P_«port.protocol.name»());
		«ENDFOR»
	'''
	
	/**
	 * Defines the timers
	 * @return generated code
	 */
	private def listTimers() '''
		«FOR timer : cap.timerPorts»
			final TimerPort _tp_«timer.name» = new TimerPort();
		«ENDFOR»
	'''
	
	/**
	 * Defines the capsule instances
	 * @return generated code
	 */
	private def listCapsuleInsts() '''
		«FOR ci: cap.capsuleInsts» 
			Capsule _ci_«ci.name» = new _C_«ci.type.name»(this);
		«ENDFOR»
	'''
	
	/**
	 * Defines the attributes and operations
	 * @return generated code
	 */
	private def listAttribOps() '''
		«FOR attrib : cap.attributes»
			«attrib.compile»
		«ENDFOR»
		«FOR op : cap.operations»
			«op.compile»
		«ENDFOR»	
	'''

	/**
	 * Compiles the operation
	 * @param op operation to be compiled
	 * @return generated code
	 */
	private def compile(Operation op) '''
		public «op.type» _f_«op.name»(«FOR param : op.localVars SEPARATOR ", "»«param.type» _l_«param.name»«ENDFOR») {
			«FOR st : op.operationCode.statements»«st.state»«ENDFOR»
		}
	'''

	/**
	 * Compiles the attribute
	 */
	private def compile(Attribute attrib) '''
		private «attrib.type» _a_«attrib.name»«IF attrib.defaultValue != null» = «attrib.defaultValue.express»«ENDIF»;
	'''
	

	// -------------------------------------------------------
	
	
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
			for (t : outgoingTransitions.get(stateToGoThrough))
				result = result + '_tran_' + t.name + ', '
			stateToGoThrough = container(stateToGoThrough.eContainer, State_)
		} while (stateToGoThrough != null)
		if (result.length > 2)
		result = result.substring(0,result.length-2)
		return result
	}
	
	/**
	 * Generate the initial transition chain
	 * @return generated code
	 */
	private def genInitMethod(Transition init) '''
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
			result = result + '''
				_tran_«init.name».action.accept(new ArrayList<>());
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
				result = result + '''
					_tran_«subInitial.name».action.accept(new ArrayList<>());
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
	 * Returns the CommonObj type corresponding to the 
	 * incoming variable
	 * @param op the incoming variable
	 * @return a string that represents the CommonObj
	 * of the incoming variable
	 */
	private def commonObjType(IncomingVariable op) {
		if (op.isBool)
			'Bool'
		else if (op.isInt)
			'Int'
	}
	
	/**
	 * Returns the primitive type of the incoming variable
	 * @param op the incoming variable
	 * @return a string representing the primitive type
	 * of the incoming variable
	 */
	private def type(IncomingVariable op) {
		if (op.isInt)
			'int'
		else if (op.isBool)
			'boolean'
	}

	/**
	 * Returns the return primitive type of the operation
	 * @param op the operation
	 * @return the return type (primitive type)
	 */
	private def type(Operation op) {
		if (op.isInt)
			"int"
		else if(op.isBool) "boolean" else "void"
	}

	/**
	 * Returns the primitive type of the local variable
	 * @param op the local variable
	 * @return the string represents the primitive type
	 * of the local variable
	 */
	private def type(LocalVar op) {
		if (op.isInt)
			"int"
		else if(op.isBool) "boolean" else "void"
	}

	/**
	 * Returns the primitive type of the attribute
	 * @op the attribute
	 * @return a string represents the primitive type of 
	 * the attribute
	 */
	private def type(Attribute op) {
		if (op.isInt)
			"int"
		else if (op.isBool)
			"boolean"
	}

	/**
	 * Compiles the expression
	 * @param ex the expression
	 * @return string expressing ex
	 */
	private def express(Expression ex) {
		new ExpressionGenerator().express(ex)
	}

	/**
	 * Compiles the statement
	 * @param obj the statement
	 * @return string expressing the statement
	 */
	private def state(EObject obj) {
		new StatementGenerator().state(obj)
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
