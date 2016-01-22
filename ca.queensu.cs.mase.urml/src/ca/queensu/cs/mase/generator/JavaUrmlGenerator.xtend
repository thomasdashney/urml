
/*
 * generated by Xtext
 */
package ca.queensu.cs.mase.generator

import ca.queensu.cs.mase.urml.Capsule
import ca.queensu.cs.mase.urml.Model
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import ca.queensu.cs.mase.urml.Protocol
import ca.queensu.cs.mase.generator.capsules.CapsuleGenerator
import ca.queensu.cs.mase.generator.protocols.ProtocolGenerator

class JavaUrmlGenerator implements IGenerator {
	
	var Model model

	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		model = resource.contents.get(0) as Model
		var mfname = modelPackageName.replace('.','/')
		for (cap : model.capsules) 
			fsa.generateFile(mfname + "/_C_" + cap.name + ".java", cap.compile)

		for (prot : model.protocols)
			fsa.generateFile(mfname + "/_P_" + prot.name + ".java", prot.compile)
			
		fsa.generateFile(mfname + "/Launcher.java", compileLauncher)
		
		#[
			'Int.java' -> compileInt, 
			'Bool.java' -> compileBool, 
			'CommonObj.java' -> compileCommon,
			'Capsule.java' -> compileCommonCapsule, 
			'MessagePort.java' -> compilePort,
			'Protocol.java' -> compileProtocol,
			'Connector.java' -> compileConnector, 
			'CapsulePortPair.java' -> compileCapPortPair,
			'Message.java' -> compileMessage,
			'Signal.java' -> compileSignal,
			'State.java' -> compileState,
			'Transition.java' -> compileTransition,
			'TriggerIn.java' -> compileTriggerIn,
			'TimerPort.java' -> compileTimerPort
		].forEach[
			fsa.generateFile(urmlRuntimeName.replace('.','/') + 
			'/' + it.key, it.value)
		]
	}
	
	
	private def urmlRuntime() '''
		package «urmlRuntimeName»;
	'''
	
	private def urmlRuntimeName() {
		'urml.runtime'
	}
	
	
	private def modelPackage() '''
		package «modelPackageName»;
	'''
	
	private def modelPackageName() {
		'model.' + model.name.toFirstLower
	}
	
	private def compile(Protocol p) '''
		«modelPackage»
		«new ProtocolGenerator(p).generate»
	'''
	
	private def compileSignal() '''
		«urmlRuntime»
		public class Signal {}
	'''
	
	private def compileMessage() '''
		«urmlRuntime»
		import java.util.*;
		public class Message {
			public MessagePort port;
			public Signal signal;
			public List<CommonObj> parameters;
			public Message(MessagePort msgPort, Signal signal, 
					List<CommonObj> param) {
				this.port = msgPort;
				this.signal = signal;
				this.parameters = param;
			}
		}
	'''
	
	private def compileCapPortPair() '''
		«urmlRuntime»
		public class CapsulePortPair {
			public Capsule cap;
			public MessagePort port;
		}
	'''

	private def compile(Capsule cap) '''
		«modelPackage»
		«new CapsuleGenerator(cap).generate»
	'''

	private def compileInt() '''
		«urmlRuntime»
		public class Int extends CommonObj {
			public int val;
			public Int(int v) { val = v; }
		}
	'''

	private def compileBool() '''
		«urmlRuntime»
		public class Bool extends CommonObj {
			public boolean val;
			public Bool(boolean v) { val = v; }
		}
	'''

	private def compileCommon() '''
		«urmlRuntime»
		public class CommonObj {
		}
	'''

	private def compileCommonCapsule() '''
		«urmlRuntime»
		«new CommonCapsuleGenerator().compile»
	'''

	private def compileProtocol() '''
		«urmlRuntime»
		import java.util.*;
		public class Protocol {
			protected Protocol() {}
			protected List<Signal> incomingSignals;
			protected List<Signal> outgoingSignals;
		}
	'''
	
	private def compilePort() '''
		«urmlRuntime»
		public class MessagePort {
			public String name;
			public Protocol prot;
			public MessagePort(String name, Protocol protocol) {
				this.name = name;
				this.prot = protocol;
			}
		}
	'''
	
	private def compileTimerPort() '''
		«urmlRuntime»
		public class TimerPort {
		}
	'''
	
	private def compileConnector() '''
		«urmlRuntime»
		public class Connector {
			public Capsule cap1;
			public Capsule cap2;
			public MessagePort port1;
			public MessagePort port2;
			public Connector(Capsule c1, MessagePort p1, Capsule c2, MessagePort p2) {
				cap1 = c1; cap2 = c2; port1 = p1; port2 = p2;
			}
		}
	'''
	
	private def compileLauncher() '''
		«modelPackage»
		«new LauncherGenerator(model).generate»
	'''
	
	private def compileState() '''
		«urmlRuntime»
		public class State {
			public String name;
			public Runnable entry;
			public Runnable exit;
			public State(String name, Runnable entry, Runnable exit) {
				this.name = name;
				this.entry = entry;
				this.exit = exit;
			}
			
		}
	'''
	
	private def compileTransition() '''
		«urmlRuntime»
		import java.util.*;
		import java.util.function.*;
		public class Transition {
			public String name;
			public Supplier<Boolean> guard;
			public Consumer<List<? extends CommonObj>> action;
			public List<TriggerIn> triggerIn;
			public TimerPort timerPort;
			public Transition(String name, Supplier<Boolean> guard, 
					Consumer<List<? extends CommonObj>> action, 
					List<TriggerIn> triggerIn, TimerPort timerPort) {
				this.name = name;
				this.guard = guard;
				this.action = action;
				this.triggerIn = triggerIn;
				this.timerPort = timerPort;
			}
		}	
	'''
	
	private def compileTriggerIn() '''
		«urmlRuntime»
		public class TriggerIn {
			public MessagePort port;
			public Signal signal;
			public TriggerIn(MessagePort p, Signal s) {
				port = p;
				signal = s;
			}
		}	
	'''
}
