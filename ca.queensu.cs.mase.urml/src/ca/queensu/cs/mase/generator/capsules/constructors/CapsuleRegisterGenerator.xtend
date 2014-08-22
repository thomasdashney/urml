package ca.queensu.cs.mase.generator.capsules.constructors

import ca.queensu.cs.mase.urml.Capsule
import ca.queensu.cs.mase.urml.CapsuleInst

class CapsuleRegisterGenerator {
	var Capsule cap
	new(Capsule cap) {
		this.cap = cap
	}
	// REGISTERS
	
	public def generate() '''
		«registerPorts»
		«registerCapsuleInsts»
		«registerConnectors»
	'''
	
	
	/**
	 * Lists of message ports
	 * @return generated code
	 */
	public def registerPorts() '''
		internalports = Arrays.asList(«FOR port: cap.internalPorts SEPARATOR ', '»_p_«port.name»«ENDFOR»);
		
		externalports = Arrays.asList(«FOR port : cap.interfacePorts SEPARATOR ', '»_p_«port.name»«ENDFOR»);
	'''
	
	/**
	 * List of capsule instances that the current capsule has
	 * @return generated code
	 */
	public def registerCapsuleInsts() '''
		capsules = Arrays.asList(«FOR ci: cap.capsuleInsts SEPARATOR ', '»_ci_«ci.name»«ENDFOR»);
		«FOR ci: cap.capsuleInsts»
			_ci_«ci.name».name = "«ci.name»";
		«ENDFOR»
	'''

	/**
	 * List of connectors
	 * @return generated code
	 */
	public def registerConnectors() '''
		connectors = Arrays.asList(
		«FOR conn : cap.connectors SEPARATOR ', '»«var c1 = ciName(conn.capsuleInst1)»«var c2 = ciName(conn.capsuleInst2)»
			new Connector(
				// capsule 1, port 1
				«c1», «c1»._p_«conn.port1.name»,
				
				// capsule 2, port 2
				«c2», «c2»._p_«conn.port2.name»)
		«ENDFOR»);
	'''
	
	private def ciName(CapsuleInst c) {
		if (c == null) 
			"this"
		else
			"_ci_" + c.name
	}
	
}