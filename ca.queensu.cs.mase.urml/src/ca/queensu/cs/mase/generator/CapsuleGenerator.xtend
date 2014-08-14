package ca.queensu.cs.mase.generator

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
	 */
	public def compile() '''
		«var initialTransition = getInit»
		«imports»
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

	private def imports() '''
		import java.time.*;
		import java.util.*;
		import urml.runtime.*;
	'''

	// CONSTRUCTORS
	
	private def constructors() '''
		public _C_«cap.name»() {
			this(null);
		}
		
		public _C_«cap.name»(Capsule parent_) {
			this.parent = parent_;
			«registerPorts»
			«registerCapsuleInsts»
			«registerConnectors»
		}
	'''
	
	private def registerPorts() '''
		internalports = Arrays.asList(
			«FOR port: cap.internalPorts SEPARATOR ', '»_p_«port.name»«ENDFOR»
		);
		
		externalports = Arrays.asList(
			«FOR port : cap.interfacePorts SEPARATOR ', '»_p_«port.name»«ENDFOR»
		);
	'''
	
	private def registerCapsuleInsts() '''
		capsules = Arrays.asList(
			«FOR ci: cap.capsuleInsts SEPARATOR ', '»_ci_«ci.name»«ENDFOR»
		);
	'''

	private def registerConnectors() '''
		connectors = Arrays.asList(
			«FOR conn : cap.connectors SEPARATOR ', '»«var c1 = conn.capsuleInst1»«var c2 = conn.capsuleInst2»
				new Connector(
				«IF c1 == null»
					this,
				«ELSE»
					_ci_«c1.name»,
				«ENDIF»
				«IF c1 != null»
					((_C_«c1.type.name») _ci_«c1.name»).«ENDIF»_p_«conn.port1.name»,
				«IF c2 == null»
					this,
				«ELSE»
					_ci_«c2.name»,
				«ENDIF»
				«IF c2 != null»
					((_C_«c2.type.name») _ci_«c2.name»).«ENDIF»_p_«conn.port2.name»
				)
			«ENDFOR»
		);
	'''

	// STATES
	
	private def defineStates() '''
		«FOR s : allStates»
			private State _state_«s.name» = new State(
				"«s.name»",
				() -> {
					«IF s.entryCode != null»
						«FOR st : s?.entryCode?.statements»
							«st.state»
						«ENDFOR»
					«ENDIF»
				},
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

	private def defineTransitions() '''
		«FOR t : allTransitions»
			private Transition _tran_«t.name» = new Transition(
				"«t.name»",
				() -> {
					«IF t.guard == null»
						return true;
					«ELSE»
						return «t.guard.express»;
					«ENDIF»
				},
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
				Arrays.asList(
					«FOR trig: t.triggers SEPARATOR ','»
						new TriggerIn(
							_p_«trig.from.name», _P_«trig.from.protocol.name»._s_«trig.signal.name»
						)
					«ENDFOR»
				),
				«IF t.timerPort == null»
					null
				«ELSE»
					_tp_«t.timerPort.name»
				«ENDIF»
			);
		«ENDFOR»	
	'''	
	
	// LISTS

	private def listPorts() '''
		«FOR port: cap.internalPorts»
			MessagePort _p_«port.name» = new MessagePort("«port.name»", new _P_«port.protocol.name»());
		«ENDFOR»
		«FOR port: cap.interfacePorts»
			MessagePort _p_«port.name» = new MessagePort("«port.name»", new _P_«port.protocol.name»());
		«ENDFOR»
	'''
	
	private def listTimers() '''
		«FOR timer : cap.timerPorts»
			final TimerPort _tp_«timer.name» = new TimerPort();
		«ENDFOR»
	'''
	
	private def listCapsuleInsts() '''
		«FOR ci: cap.capsuleInsts» 
			Capsule _ci_«ci.name» = new _C_«ci.type.name»(this);
		«ENDFOR»
	'''
	
	private def listAttribOps() '''
		«FOR attrib : cap.attributes»
			«attrib.compile»
		«ENDFOR»
		«FOR op : cap.operations»
			«op.compile»
		«ENDFOR»	
	'''

	private def findNextTransitions() '''
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
	
	private def genInitMethod(Transition init) '''
		public void startInit() {
			synchronized (lock) {
				«init.genInitMethod2»
			}
		}
	'''

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

	private def findInit(StateMachine sm) {
		var c = sm.container(Capsule)
		if (c != null)
			for (t : sm.transitions)
				if (t.init)
					return t
		return null
	}

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

	private def compile(Operation op) '''
		public «op.type» _f_«op.name»(«FOR param : op.localVars SEPARATOR ", "»«param.type» _l_«param.name»«ENDFOR») {
			«FOR st : op.operationCode.statements»«st.state»«ENDFOR»
		}
	'''

	private def commonObjType(IncomingVariable op) {
		if (op.isBool)
			'Bool'
		else if (op.isInt)
			'Int'
	}
	
	private def type(IncomingVariable op) {
		if (op.isInt)
			'int'
		else if (op.isBool)
			'boolean'
	}

	private def type(Operation op) {
		if (op.isInt)
			"int"
		else if(op.isBool) "boolean" else "void"
	}

	private def type(LocalVar op) {
		if (op.isInt)
			"int"
		else if(op.isBool) "boolean" else "void"
	}

	private def type(Attribute op) {
		if (op.isInt)
			"int"
		else if (op.isBool)
			"boolean"
	}

	private def compile(Attribute attrib) '''
		private «attrib.type» _a_«attrib.name»«IF attrib.defaultValue != null» = «attrib.defaultValue.express»«ENDIF»;
	'''

	private def express(Expression ex) {
		new ExpressionGenerator().express(ex)
	}

	private def state(EObject obj) {
		new StatementGenerator().state(obj)
	}

	private def <T extends EObject> contents(Class<T> t) {
		EcoreUtil2.getAllContentsOfType(cap, t)
	}

	private def <T extends EObject> container(EObject obj, Class<T> t) {
		EcoreUtil2.getContainerOfType(obj, t)
	}
}

class NoInitialTransitionInStateMachineException extends RuntimeException {
}
