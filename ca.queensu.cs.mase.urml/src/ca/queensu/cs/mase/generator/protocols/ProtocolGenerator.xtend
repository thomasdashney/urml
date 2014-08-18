package ca.queensu.cs.mase.generator.protocols

import ca.queensu.cs.mase.urml.Protocol

class ProtocolGenerator {
	var Protocol prot;
	new(Protocol p) {
		prot = p
	}
	public def compile() '''
		import urml.runtime.*;
		import java.util.*;
		public class _P_«prot.name» extends Protocol {
			public _P_«prot.name»() {
				incomingSignals = Arrays.asList(
					«FOR s : prot.incomingMessages SEPARATOR ', '»_s_«s.name»«ENDFOR»
				);
				outgoingSignals = Arrays.asList(
					«FOR s : prot.outgoingMessages SEPARATOR ', '»_s_«s.name»«ENDFOR»
				);
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