package ca.queensu.cs.mase.urml.tests

import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.InjectWith
import ca.queensu.cs.mase.UrmlInjectorProvider
import com.google.inject.Inject
import org.eclipse.xtext.junit4.util.ParseHelper
import ca.queensu.cs.mase.urml.Model
import org.junit.Test
import org.junit.Assert
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import ca.queensu.cs.mase.urml.UrmlPackage
import ca.queensu.cs.mase.validation.UrmlJavaValidator
import ca.queensu.cs.mase.urml.impl.NoOpImpl
import ca.queensu.cs.mase.urml.UrmlFactory
import ca.queensu.cs.mase.urml.NoOp

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(UrmlInjectorProvider))
class ModelBasicTest {

	@Inject extension ParseHelper<Model>
	@Inject extension ValidationTestHelper

	@Test
	def void testEmptyModel() {
		val model = '''
			model emptyModel {}
		'''.parse

		Assert::assertEquals("emptyModel", model.name)
		Assert::assertTrue(model.protocols.size == 0)
		Assert::assertTrue(model.capsules.size == 0)
		
		model.assertError(UrmlPackage::eINSTANCE.model, UrmlJavaValidator::NO_ROOT)
	}

	@Test
	def void testCapsule() {
		val model = '''
		model capsule1 {
			root capsule cap {}
		}'''.parse

		Assert::assertEquals("capsule1", model.name)
		Assert::assertTrue(model.protocols.size == 0)
		Assert::assertTrue(model.capsules.size == 1)

		val cap = model.capsules.get(0)
		Assert::assertEquals("cap", cap.name)
		Assert::assertTrue(cap.root)
		model.assertNoErrors
	}

	@Test
	def void testCapsuleNoRoot() {
		val model = '''
		model capsule1noRoot {
			capsule cap {}
		}'''.parse

		model.assertError(UrmlPackage::eINSTANCE.model, UrmlJavaValidator::NO_ROOT)
	}
	
	@Test
	def void testProtocolEmpty() {
		val model = '''
		model proto {
			root capsule cap{}
			protocol one {}
		}'''.parse
		
		Assert::assertTrue(model.protocols.size == 1)
		Assert::assertEquals("one", model.protocols.get(0).name)
		model.assertNoErrors
	}
	
	@Test
	def void testProtocolInOut() {
		val model = '''
		model proto {
			root capsule cap {}
			protocol one {
				incoming {}
				outgoing {}
			}
		}'''.parse
		
		model.assertNoErrors
		Assert::assertTrue(model.protocols.size == 1)
		Assert::assertTrue(model.protocols.get(0).incomingMessages.size == 0)
		Assert::assertTrue(model.protocols.get(0).outgoingMessages.size == 0)
	}

	@Test
	def void testProtocolSignal() {
		val model = '''
		model protoSignal {
			root capsule cap {}
			protocol one {
				incoming {
					signal1()
				}
			}
		}'''.parse
		
		model.assertNoErrors
		Assert::assertTrue(model.protocols.size == 1)
		val one = model.protocols.get(0)
		Assert::assertTrue(one.incomingMessages.size == 1)
		val signal1 = one.incomingMessages.get(0)
		Assert::assertTrue(signal1.varDecls.size == 0)
		Assert::assertEquals("signal1", signal1.name)
	}
	
	@Test
	def void testProtocolSignals() {
		val model = '''
		model protoSignal {
			root capsule cap {}
			protocol one {
				incoming {
					signal1()
					signal2()
				}
			}
		}'''.parse
		
		model.assertNoErrors
		Assert::assertTrue(model.protocols.size == 1)
		val one = model.protocols.get(0)
		Assert::assertTrue(one.incomingMessages.size == 2)
		val signal1 = one.incomingMessages.get(0)
		val signal2 = one.incomingMessages.get(1)
		Assert::assertTrue(signal1.varDecls.size == 0)
		Assert::assertEquals("signal1", signal1.name)
		Assert::assertTrue(signal2.varDecls.size == 0)
		Assert::assertEquals("signal2", signal2.name)
	}
	
	@Test
	def void testProtocolSignalParam() {
		val model = '''
		model protoSignalParam {
			root capsule cap {}
			protocol one {
				incoming {
					signal1(a)
				}
			}
		}'''.parse
		
		model.assertNoErrors
		val one = model.protocols.get(0).incomingMessages.get(0)
		Assert::assertTrue(one.varDecls.size == 1)
		Assert::assertEquals("a", one.varDecls.get(0).name)
	}
	
	@Test
	def void testProtocolSignalParams() {
		val model = '''
		model protoSignalParam {
			root capsule cap {}
			protocol one {
				incoming {
					signal1(a,b)
				}
			}
		}'''.parse
		
		model.assertNoErrors
		val one = model.protocols.get(0).incomingMessages.get(0)
		Assert::assertTrue(one.varDecls.size == 2)
		Assert::assertEquals("a", one.varDecls.get(0).name)
		Assert::assertEquals("b", one.varDecls.get(1).name)
	}
	
	def void testCapsuleAttribute() {
		val model = '''
		model capAttrib {
			root capsule cap {
				attribute a
			}
		}'''.parse
		
		model.assertNoErrors
		val attribs = model.capsules.get(0).attributes
		Assert::assertTrue(attribs.size == 1)
		Assert::assertEquals(attribs.get(0).name, "a")
	}
	
	@Test
	def void testCapsuleRootExternalPort() {
		val model = '''
		model test {
			root capsule cap {
				external port Port1 : One
			}
			protocol One {}
		}'''.parse
		
		model.assertError(UrmlPackage::eINSTANCE.capsule, UrmlJavaValidator::ROOT_EXTERN_PORT)
		Assert::assertTrue(model.capsules.get(0).interfacePorts.size == 1)
		Assert::assertEquals(model.capsules.get(0).interfacePorts.get(0).name, "Port1")
	}
	
	@Test
	def void testCapsuleNonRootExternalPort() {
		val model = '''
		model test {
			root capsule rootCap {}
			capsule cap {
				external port Port1: One
			}
			protocol One {}
		}'''.parse
		
		model.assertNoErrors
		val extPorts = model.capsules.get(1).interfacePorts
		Assert::assertTrue(extPorts.size == 1)
		Assert::assertEquals(extPorts.get(0).name, "Port1")
		Assert::assertEquals(extPorts.get(0).protocol.name, "One")
	}
	
	@Test
	def void testCapsuleInternalPort() {
		val model = '''
		model test {
			root capsule rootCap {
				port InPort1: One
			}
			protocol One {}
		}'''.parse
		
		model.assertNoErrors
		val intPorts = model.capsules.get(0).internalPorts
		Assert::assertTrue(intPorts.size == 1)
		Assert::assertEquals(intPorts.get(0).name, "InPort1")
		Assert::assertEquals(intPorts.get(0).protocol.name, "One")
	}
	
	@Test
	def void testCapsuleTimerPort() {
		val model = '''
		model test {
			root capsule cap {
				timerPort tp
			}
		}'''.parse
		
		model.assertNoErrors
		Assert::assertEquals(model.capsules.get(0).timerPorts.get(0).name, "tp")
	}
	
	@Test
	def void testCapsuleLogPort() {
		val model = '''
		model test {
			root capsule cap {
				logPort lp
			}
		}'''.parse
		
		model.assertNoErrors
		Assert::assertEquals(model.capsules.get(0).logPorts.get(0).name, "lp")
	}
	
	@Test
	def void testCapsuleRef() {
		val model = '''
		model test {
			root capsule cap {
				capsuleRef cr: a
			}
			
			capsule a {}
		}'''.parse
		
		model.assertNoErrors
		Assert::assertEquals(model.capsules.get(0).capsuleInsts.get(0).name, "cr")
		Assert::assertEquals(model.capsules.get(0).capsuleInsts.get(0).type,
			model.capsules.get(1))
	}
	
	@Test
	def void testCapsuleConnector() {
		val model = '''
		model test {
			root capsule cap {
				capsuleRef aRef: a
				capsuleRef bRef: b
				connector aRef.one and bRef.two
			}
			capsule a { external port one: alpha }
			capsule b { external port two: alpha }
			protocol alpha {}
		}'''.parse
		
		model.assertNoErrors
		Assert::assertEquals(model.capsules.get(0).connectors.get(0).port1,
			model.capsules.get(1).interfacePorts.get(0))
		Assert::assertEquals(model.capsules.get(0).connectors.get(0).port2,
			model.capsules.get(2).interfacePorts.get(0))
	}
	
	@Test
	def void testCapsuleOperation() {
		val model = '''
		model test {
			root capsule cap {
				operation oper() {
					noop
				}
			}
		}'''.parse
		
		model.assertNoErrors
		
		val oper = model.capsules.get(0).operations.get(0)
		Assert::assertEquals(oper.name, "oper")
		Assert::assertEquals(oper.varDecls.size, 0)
		val noop = oper.operationCode.statements.get(0)
		Assert::assertTrue(noop instanceof NoOp)
	}
	
	@Test
	def void testCapsuleSMachine() {
		val model = '''
		model test {
			root capsule cap {
				state
		}'''
	}
	
}
