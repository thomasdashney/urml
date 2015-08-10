package ca.queensu.cs.mase.urml.tests

import ca.queensu.cs.mase.urml.tests.UrmlInjectorProviderCustom
import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(UrmlInjectorProviderCustom))
class UrmlGeneratorTest {

	@Inject extension CompilationTestHelper
	
	@Test
	def void testRootCapsule() {
		'''
		model Test {
			root capsule Handshake {
			}
		}
		'''.assertCompilesTo(
		'''
		active proctype Handshake() {
		}
		''')
	}
	
	@Test
	def void testCapsuleInstances() {
		'''
		model Test {
			root capsule Handshake {
				capsuleInstance sender : Originator
			}
			capsule Originator {
				capsuleInstance test1 : Test
				capsuleInstance test2 : Test
			}
			capsule Test {}
		}
		'''.assertCompilesTo(
		'''
		active proctype Handshake() {
		}
		active proctype sender() {
		}
		active proctype sender_test1() {
		}
		active proctype sender_test2() {
		}
		''')
	}
	
	@Test
	//XXX
	def void testConnectors() {
		'''
		model handshake {
			root capsule Handshake {
				capsuleInstance sender : Originator
				capsuleInstance receiver : Receiver
				connector sender.hand and receiver.hand
				
				port internalHand : HandshakeProtocol
				connector internalHand and receiver.hand
			}
			capsule Originator {
				external port hand : HandshakeProtocol
			}
			capsule Receiver {
				external port ~hand : HandshakeProtocol
			}
			protocol HandshakeProtocol {
			}
		}
		'''.assertCompilesTo(
		'''
		chan sender.hand_receiver.hand;
		chan Handshake.internalHand_receiver.hand;
		
		active proctype Handshake() {
		}
		active proctype sender() {
		}
		active proctype receiver() {
		}
		''')
	}
}