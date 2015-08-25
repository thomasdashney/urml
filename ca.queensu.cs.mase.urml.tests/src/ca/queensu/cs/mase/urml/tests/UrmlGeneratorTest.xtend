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
	def void testSimpleConnectors() {
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
		chan sender.hand_receiver.hand = [0] of mtype;
		chan Handshake.internalHand_receiver.hand = [0] of mtype;
		
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
	def void testRelayConnectors() {
		'''
		model handshake {
			root capsule OuterCapsule {
				capsuleInstance innerCapsule1 : InnerCapsule1
				capsuleInstance innerCapsule2 : InnerCapsule2
				connector innerCapsule1.externPort and innerCapsule2.externPort
			}
			
			capsule InnerCapsule1 {
				capsuleInstance nestedCapsule : NestedCapsule1
				external port ~externPort : TestProtocol
				connector externPort and nestedCapsule.nestedPort
			}
			capsule NestedCapsule1 {
				external port nestedPort : TestProtocol
			}
			
			capsule InnerCapsule2 {
				capsuleInstance nestedCapsule : NestedCapsule2
				external port externPort : TestProtocol
				connector externPort and nestedCapsule.nestedPort
			}
			
			capsule NestedCapsule2 {
				external port ~nestedPort : TestProtocol
			}
			
			protocol TestProtocol {
			}
		}
		'''.assertCompilesTo(
		'''
		chan innerCapsule1_nestedCapsule.nestedPort_innerCapsule2_nestedCapsule.nestedPort = [0] of mtype;
		
		active proctype OuterCapsule() {
		}
		active proctype innerCapsule1() {
		}
		active proctype innerCapsule1_nestedCapsule() {
		}
		active proctype innerCapsule2() {
		}
		active proctype innerCapsule2_nestedCapsule() {
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
	def void testHandshake() {
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
		chan sender.hand_receiver.hand = [0] of mtype;
		mtype = {shake}
		
		active proctype Handshake() {
		}
		active proctype sender() {
			goto start
			start:
				if
					::(true)
						sender.hand_receiver.hand!shake
						printf("(unknown capsule): logging to logger with: sent a handshake");
				fi
			end:
				goto process_termination
			process_termination: skip
		}
		active proctype receiver() {
			goto start
			start:
				if
					::(sender.hand_receiver.hand?shake)
						printf("(unknown capsule): logging to logger with: received a handshake");
				fi
			end:
				goto process_termination
			process_termination: skip
		}
		''')
	}
	
	
	
	@Test
	//XXX
	def void testFailures() {
		'''
model ConsumerProducer { 
	root capsule ConsumerProducer {
		capsuleInstance c : Consumer
		capsuleInstance p : Producer
		capsuleInstance b : BoundedBuffer
		connector c.toGet and b.consumer 
		connector p.toPut and b.producer
	}
	capsule Consumer {
		external port toGet : BufferProtocol
		logPort logger
		stateMachine {
			state single
			transition : initial -> single {
			}
			transition : single -> single {
				triggeredBy toGet.get(int toDisplay)
				action {
					log logger with toDisplay
				}
			}
		}
	}
	capsule Producer {
		external port toPut : BufferProtocol
		stateMachine {
			state single {
				entry {
					var int x := 1
					while (x < 8) {
						send toPut.put(x)
						x := x + 1
					}
				}
			}
			transition : initial -> single {
			}
		}
	}
	capsule BoundedBuffer {
		attribute int a := 0
		attribute int b := 0
		attribute int c := 0
		attribute int d := 0
		attribute int e := 0
		external port ~consumer : BufferProtocol
		external port ~producer : BufferProtocol
		stateMachine {
			state zero
			state one
			state two
			state three
			state four
			state five
			transition init : initial -> zero {
			}
			transition : zero -> one {
				triggeredBy producer.put(int a_)
				action {
					a := a_
				}
			}
			transition : one -> two {
				triggeredBy producer.put(int b_)
				action {
					b := b_
				}
			}
			transition : two -> three {
				triggeredBy producer.put(int c_)
				action {
					c := c_
				}
			}
			transition : three -> four {
				triggeredBy producer.put(int d_)
				action {
					d := d_
				}
			}
			transition : four -> five {
				triggeredBy producer.put(int e_)
				action {
					e := e_
				}
			}
			transition : five -> four {
				action {
					send consumer.get(e)
					e := 0
				}
			}
			transition : four -> three {
				action {
					send consumer.get(d)
					d := 0
				}
			}
			transition : three -> two {
				action {
					send consumer.get(c)
					c := 0
				}
			}
			transition : two -> one {
				action {
					send consumer.get(b)
					b := 0
				}
			}
			transition : one -> zero {
				action {
					send consumer.get(a)
					a := 0
				}
			}
		}
	}
	protocol BufferProtocol {
		incoming {
			get(int data)
		}
		outgoing {
			put(int data)
		}
	}
}'''.assertCompilesTo(
		'''
		chan sender.hand_receiver.hand = [0] of mtype;
		mtype = {shake}
		
		active proctype Handshake() {
		}
		active proctype sender() {
			goto start
			start:
				if
					::(true)
						sender.hand_receiver.hand!shake
						printf("(unknown capsule): logging to logger with: sent a handshake");
				fi
			end:
				goto process_termination
			process_termination: skip
		}
		active proctype receiver() {
			goto start
			start:
				if
					::(sender.hand_receiver.hand?shake)
						printf("(unknown capsule): logging to logger with: received a handshake");
				fi
			end:
				goto process_termination
			process_termination: skip
		}
		''')
	}
}