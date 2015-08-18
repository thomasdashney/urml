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
	
	@Test
	//XXX
	def void testAttributes() {
		'''
		model handshake {
			root capsule RootCapsule {
				attribute int testAttribute1
				attribute int testAttribute2 := 1
				capsuleInstance secondCapsule : SecondCapsule
			}
			capsule SecondCapsule {
				attribute bool testAttribute1 := true
			}
		}
		'''.assertCompilesTo(
		'''
		active proctype RootCapsule() {
			int testAttribute1
			int testAttribute2 = 1
		}
		active proctype secondCapsule() {
			bool testAttribute1 = true
		}
		''')
	}
	
	@Test
	//XXX
	def void testStateMachines() {
		'''
		/**
		 * A simple example that consists of a producer and a consumer of a message.
		 */
		model handshake {
			root capsule Handshake {
				capsuleInstance sender : Originator
				capsuleInstance receiver : Receiver
				connector sender.hand and receiver.hand
			}
			capsule Originator {
				external port hand : HandshakeProtocol
				logPort logger
				stateMachine {
					state start
					final state end
					transition init : initial -> start {
					}
					transition doHandShake : start -> end {
						action {
							send hand.shake()
							log logger with "sent a handshake"
						}
					}
				}
			}
			capsule Receiver {
				external port ~hand : HandshakeProtocol
				logPort logger
				stateMachine {
					state start
					final state end
					transition init : initial -> start {
					}
					transition receiveHandshake : start -> end {
						triggeredBy hand.shake()
						action {
							log logger with "received a handshake"
						}
					}
				}
			}
			protocol HandshakeProtocol {
				outgoing {
					shake()
				}
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