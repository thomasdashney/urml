package ca.queensu.cs.mase.generator.capsules.members

import ca.queensu.cs.mase.urml.Capsule
import ca.queensu.cs.mase.urml.Operation
import ca.queensu.cs.mase.urml.Attribute
import ca.queensu.cs.mase.urml.LocalVar
import ca.queensu.cs.mase.urml.Expression
import ca.queensu.cs.mase.generator.dispatchers.ExpressionGenerator
import org.eclipse.emf.ecore.EObject
import ca.queensu.cs.mase.generator.dispatchers.StatementGenerator

class ListGenerator {
	var Capsule cap
	new(Capsule cap) {
		this.cap = cap
	}

	public def generate() '''
		«listPorts»
		«listTimers»
		«listCapsuleInsts»
		«listAttribOps»
	'''

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
			_C_«ci.type.name» _ci_«ci.name» = new _C_«ci.type.name»(this);
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
}