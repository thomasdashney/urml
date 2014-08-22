package ca.queensu.cs.mase.generator.capsules.members

import java.util.List
import ca.queensu.cs.mase.urml.Transition
import ca.queensu.cs.mase.urml.Expression
import ca.queensu.cs.mase.generator.dispatchers.ExpressionGenerator
import java.util.Map
import ca.queensu.cs.mase.urml.IncomingVariable
import org.eclipse.emf.ecore.EObject
import ca.queensu.cs.mase.generator.dispatchers.StatementGenerator

class TransitionDefineGenerator {
	var List<Transition> allTransitions
	var Map<Transition, Integer> nonameTrans
	static var nonameTransCount = 0;
	new(List<Transition> allTransitions, 
		Map<Transition, Integer> nonameTrans
	) {
		this.allTransitions = allTransitions
		this.nonameTrans = nonameTrans
	}
	
	/**
	 * A transition
	 * @return generated code
	 */
	public def generate() '''
		«FOR t : allTransitions»
			«var tname = if (t.name == null) getNewNoNameTrans(t) else t.name»
			/**
			 * A transition with name: «tname»
			 */
			private Transition _tran_«tname» = new Transition(
			
				// name
				"«tname»",
				
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
	
		/**
	 * Compiles the expression
	 * @param ex the expression
	 * @return string expressing ex
	 */
	private def express(Expression ex) {
		new ExpressionGenerator().express(ex)
	}	
	
	private def getNewNoNameTrans(Transition t) {
		var i = nonameTransCount
		nonameTransCount++
		nonameTrans.put(t, i)
		"_noname_" + i
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
	 * Compiles the statement
	 * @param obj the statement
	 * @return string expressing the statement
	 */
	private def state(EObject obj) {
		new StatementGenerator().state(obj)
	}	
}