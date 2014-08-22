package ca.queensu.cs.mase.generator.protocols

import ca.queensu.cs.mase.urml.Protocol

/**
 * Genereates code for each protocol, which is given 
 * in the member variable prot.
 */
class ProtocolGenerator {
	var Protocol prot;
	new(Protocol p) {
		prot = p
	}
	
	/**
	 * Compiles the code for the protocol
	 */
	public def generate() '''
		import urml.runtime.*;
		import java.util.*;
		/**
		 * Protocol with name: «prot.name»
		 * @generated
		 */
		public class _P_«prot.name» extends Protocol {
			public _P_«prot.name»() {
				incomingSignals = Arrays.asList(«FOR s : prot.incomingMessages SEPARATOR ', '»_s_«s.name»«ENDFOR»);
				outgoingSignals = Arrays.asList(«FOR s : prot.outgoingMessages SEPARATOR ', '»_s_«s.name»«ENDFOR»);
			}
			«FOR s : prot.incomingMessages»
				public static Signal _s_«s.name» = new Signal();
			«ENDFOR»
			«FOR s : prot.outgoingMessages»
				public static Signal _s_«s.name» = new Signal();
			«ENDFOR»
		}
	'''
}