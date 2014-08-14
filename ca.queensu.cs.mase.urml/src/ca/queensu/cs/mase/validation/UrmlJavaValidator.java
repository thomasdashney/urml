package ca.queensu.cs.mase.validation;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.validation.Check;

import ca.queensu.cs.mase.urml.Capsule;
import ca.queensu.cs.mase.urml.CapsuleInst;
import ca.queensu.cs.mase.urml.Connector;
import ca.queensu.cs.mase.urml.FunctionCall;
import ca.queensu.cs.mase.urml.Invoke;
import ca.queensu.cs.mase.urml.Model;
import ca.queensu.cs.mase.urml.Port;
import ca.queensu.cs.mase.urml.Protocol;
import ca.queensu.cs.mase.urml.ReturnStatement;
import ca.queensu.cs.mase.urml.State_;
import ca.queensu.cs.mase.urml.Transition;
import ca.queensu.cs.mase.urml.Trigger_in;
import ca.queensu.cs.mase.urml.Trigger_out;
import ca.queensu.cs.mase.urml.UrmlPackage;

public class UrmlJavaValidator extends AbstractUrmlJavaValidator {

	// @Check
	// public void checkGreetingStartsWithCapital(Greeting greeting) {
	// if (!Character.isUpperCase(greeting.getName().charAt(0))) {
	// warning("Name should start with a capital",
	// MyDslPackage.Literals.GREETING__NAME);
	// }
	// }

	public static String PARAM_NUM_INCONSISTENT = "ca.queensu.cs.mase.ParamNumInconsistent";
	public static String PARAM_NUM_INCONSISTENT_TRIG_OUT = PARAM_NUM_INCONSISTENT
			+ ".Trigger_out";
	public static String PARAM_NUM_INCONSISTENT_TRIG_IN = PARAM_NUM_INCONSISTENT
			+ ".Trigger_in";
	public static String PARAM_NUM_INCONSISTENT_INVOKE = PARAM_NUM_INCONSISTENT
			+ ".Invoke";
	public static String PARAM_NUM_INCONSISTENT_FUNCTION = PARAM_NUM_INCONSISTENT
			+ ".Function";

	@Check
	public void checkParamNumConsistent(Trigger_out to) {
		int toParamNum = to.getParameters().size();
		int signalVarDeclNum = to.getSignal().getLocalVars().size();
		if (toParamNum != signalVarDeclNum) {
			error("Number of arguments sent from the trigger is not "
					+ "consistent to that defined from the protocol ",
					UrmlPackage.eINSTANCE.getTrigger_out_Parameters(),
					PARAM_NUM_INCONSISTENT_TRIG_OUT);
		}
	}

	@Check
	public void checkParamNumConsistent(Trigger_in ti) {
		if (ti.getParameters().size() != ti.getSignal().getLocalVars().size())
			error("Number of arguments received from the trigger is "
					+ "not consistent to that defined from the protocol",
					UrmlPackage.eINSTANCE.getTrigger_in_Parameters(),
					PARAM_NUM_INCONSISTENT_TRIG_IN);
	}

	@Check
	public void checkParamNumConsistent(Invoke inv) {
		int formalParameterNum = inv.getOperation().getLocalVars().size();
		int actualArgumentNum = inv.getParameters().size();
		if (formalParameterNum != actualArgumentNum)
			error("Number of actual arguments in invocation ("
					+ actualArgumentNum
					+ ") != number of formal parameter in operation header "
					+ inv.getOperation().getName() + " (" + formalParameterNum
					+ ")", UrmlPackage.eINSTANCE.getInvoke_Parameters(),
					PARAM_NUM_INCONSISTENT_INVOKE);
	}

	@Check
	public void checkParamNumConsistent(FunctionCall call) {
		int formalParameterNum = call.getCall().getLocalVars().size();
		int actualArgumentNum = call.getParams().size();
		if (formalParameterNum != actualArgumentNum)
			error("Number of actual arguments in function call ("
					+ actualArgumentNum
					+ ") != number of formal parameter in function header "
					+ call.getCall().getName() + " (" + formalParameterNum
					+ ")", UrmlPackage.eINSTANCE.getFunctionCall_Params(),
					PARAM_NUM_INCONSISTENT_FUNCTION);
	}

	public static String NOT_ONE_INIT = "ca.queensu.cs.mase.NotOneInit";

	@Check
	public void checkOnlyOneInitialTransition(Transition t) {
		// checkOnlyOneInitialTransitionIn(t, StateMachine.class);
		if (!t.isInit())
			return;

		List<Transition> siblings = EcoreUtil2.getSiblingsOfType(t,
				Transition.class);
		for (Transition t2 : siblings) {
			if (t2.isInit()) {
				error("Cannot have more than 1 initial transition in a "
						+ "state machine.",
						UrmlPackage.eINSTANCE.getTransition_Name(),
						NOT_ONE_INIT);
			}
		}
	}

	// @Check
	// public void checkIfNeedTopCapsule(Model model) {
	// if (model.getCapsules().size() <= 1)
	// return;
	// if (model.getTopCapsule() == null) {
	// error("Please specify the top capsule to run.",
	// UrmlPackage.Literals.MODEL__NAME);
	// }
	// }

	public static String NO_ROOT = "ca.queensu.cs.mase.NoRoot";

	@Check
	public void rootCapsuleRefExists(Model model) {
		int root = 0;
		for (Capsule c : model.getCapsules()) {
			if (c.isRoot()) {
				root++;
			}
		}
		if (root != 1) {
			error("Need 1 root capsule to execute.",
					UrmlPackage.eINSTANCE.getModel_Name(), NO_ROOT);
		}
	}

	public static String ROOT_EXTERN_PORT = "ca.queensu.cs.mase.RootExternPort";

	@Check
	public void rootCapsuleCannotHaveExternalPorts(Capsule capsule) {
		if (!capsule.isRoot()) {
			return;
		}

		if (capsule.getInterfacePorts().size() > 0) {
			error("the root capsule cannot have external ports",
					UrmlPackage.eINSTANCE.getCapsule_Name(), ROOT_EXTERN_PORT);
		}
	}

	public static String CONNECTOR_DIFFERENT_PROTOCOL = "ca.queensu.cs.mase.ConnectorDifferentProtocol";

	@Check
	public void connectorPortsHaveSameProtocol(Connector conn) {
		Protocol protocol1 = conn.getPort1().getProtocol();
		Protocol protocol2 = conn.getPort2().getProtocol();
		if (protocol1 != protocol2) {
			for (EStructuralFeature feature : new EStructuralFeature[] {
					UrmlPackage.eINSTANCE.getConnector_Port1(),
					UrmlPackage.eINSTANCE.getConnector_Port2() }) {
				error("both sides of the connector must have the same protocol",
						feature, CONNECTOR_DIFFERENT_PROTOCOL);
			}
		}
	}

	public static String CONNECTOR_SAME_PORT = "ca.queensu.cs.mase.ConnectorSamePort";

	@Check
	public void connectorCannotHaveSamePort(Connector conn) {
		CapsuleInst inst1 = conn.getCapsuleInst1();
		CapsuleInst inst2 = conn.getCapsuleInst2();
		Port port1 = conn.getPort1();
		Port port2 = conn.getPort2();
		if (inst1 == inst2 && port1 == port2) {
			for (EStructuralFeature feature : new EStructuralFeature[] {
					UrmlPackage.eINSTANCE.getConnector_Port1(),
					UrmlPackage.eINSTANCE.getConnector_Port2() }) {
				error("cannot have same port on both side of a connector",
						feature, CONNECTOR_SAME_PORT);
			}
		}
	}

	// public static String CONNECTOR_SAME_CAPSULE =
	// "ca.queensu.cs.mase.ConnectorSameCapsule";
	//
	// @Check
	// public void connectorCannotHavePortsFromSameCapsule(Connector conn) {
	// Port port1 = conn.getPort1();
	// Port port2 = conn.getPort2();
	//
	// Capsule cap1 = EcoreUtil2.getContainerOfType(port1, Capsule.class);
	// Capsule cap2 = EcoreUtil2.getContainerOfType(port2, Capsule.class);
	//
	// if (cap1 == cap2) {
	// for (EStructuralFeature feature : new EStructuralFeature[] {
	// UrmlPackage.eINSTANCE.getConnector_Port1(),
	// UrmlPackage.eINSTANCE.getConnector_Port2() }) {
	// error("two sides of a connector cannot belong to the same capsule",
	// feature, CONNECTOR_SAME_CAPSULE);
	// }
	// }
	// }

	public static String MORE_THAN_ONE_STATEMACHINE = "ca.queensu.cs.mase.MoreThanOneStateMachine";

	@Check
	public void hasOnlyOneStateMachine(Capsule c) {
		if (c.getStatemachines().size() > 1) {
			error("Cannot have more than 1 state machine in a capsule",
					UrmlPackage.eINSTANCE.getCapsule_Name(),
					MORE_THAN_ONE_STATEMACHINE);
		}
	}

	@Check
	public void checkFinalState(State_ state) {
		if (state.isFinal()) {
			if (state.getExitCode() != null) {
				error("Final state cannot have exit code",
						UrmlPackage.eINSTANCE.getState__ExitCode());
			}
			if (state.getSubstatemachine() != null) {
				error("Final state cannot have sub-statemachine",
						UrmlPackage.eINSTANCE.getState__Substatemachine());
			}
		}
	}

	@Check
	public void checkFunctionMustReturnSomething(FunctionCall f) {
		List<ReturnStatement> list = EcoreUtil2.getAllContentsOfType(
				f.getCall(), ReturnStatement.class);
		if (list.size() == 0) {
			error("Function call must return something",
					UrmlPackage.eINSTANCE.getFunctionCall_Call());
		} else {
			for (ReturnStatement rs : list)
				if (rs.getReturnValue() == null)
					error("This function must return something", rs, null, -1);
		}
	}

	public static String DUPLICATE_STATE = "ca.queensu.cs.mase.DuplicateState";

	@Check
	public void checkStateDuplicates(State_ state) {
		checkDuplicates(state, UrmlPackage.eINSTANCE.getState__Name(),
				DUPLICATE_STATE);
	}

	public static String DUPLICATE_TRANSITION = "ca.queensu.cs.mase.DuplicateTransition";

	@Check
	public void checkTransitionDuplicates(Transition trans) {
		checkDuplicates(trans, UrmlPackage.eINSTANCE.getTransition_Name(),
				DUPLICATE_TRANSITION);
	}

	// public static String DUPLICATE_IDENTIFIER =
	// "ca.queensu.cs.mase.DuplicateIdentifier";
	//
	// @Check
	// public void checkIdentifierDuplicates(Identifiable id) {
	// checkDuplicates(id, UrmlPackage.eINSTANCE.getIdentifiable_Name(),
	// DUPLICATE_IDENTIFIER);
	// }

	private <T extends EObject> void checkDuplicates(T first,
			EStructuralFeature feature, String code) {
		String nameOfFirst = SimpleAttributeResolver.NAME_RESOLVER.apply(first);
		Capsule cap = EcoreUtil2.getContainerOfType(first, Capsule.class);
		if (cap == null)
			return;
		for (EObject second : EcoreUtil2.getAllContentsOfType(cap,
				first.getClass())) {
			String nameOfSecond = SimpleAttributeResolver.NAME_RESOLVER
					.apply(second);
			if (nameOfFirst.equals(nameOfSecond) && first != second) {
				error("Duplicate " + first.eClass().getName() + ": "
						+ nameOfFirst, feature, code);
			}
		}
	}

	public static String INIT_GUARD = "ca.queensu.cs.mase.InitGuard";

	@Check
	public void makeSureInitialTransitionDoesNotHaveGuard(Transition t) {
		if (t.isInit())
			if (t.getGuard() != null)
				error("Cannot have guard expressions in an initial transition",
						UrmlPackage.eINSTANCE.getTransition_Name(), INIT_GUARD);
	}

}
