/**
 */
package ca.queensu.cs.mase.urml;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ca.queensu.cs.mase.urml.UrmlFactory
 * @model kind="package"
 * @generated
 */
public interface UrmlPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "urml";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.queensu.ca/cs/mase/Urml";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "urml";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  UrmlPackage eINSTANCE = ca.queensu.cs.mase.urml.impl.UrmlPackageImpl.init();

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.ModelImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__NAME = 0;

  /**
   * The feature id for the '<em><b>Capsules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__CAPSULES = 1;

  /**
   * The feature id for the '<em><b>Protocols</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__PROTOCOLS = 2;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.AssignableImpl <em>Assignable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.AssignableImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getAssignable()
   * @generated
   */
  int ASSIGNABLE = 31;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNABLE__NAME = 0;

  /**
   * The number of structural features of the '<em>Assignable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNABLE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.VarDeclImpl <em>Var Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.VarDeclImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getVarDecl()
   * @generated
   */
  int VAR_DECL = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DECL__NAME = ASSIGNABLE__NAME;

  /**
   * The number of structural features of the '<em>Var Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DECL_FEATURE_COUNT = ASSIGNABLE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.AttributeImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__NAME = ASSIGNABLE__NAME;

  /**
   * The feature id for the '<em><b>Default Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__DEFAULT_VALUE = ASSIGNABLE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = ASSIGNABLE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.ProtocolImpl <em>Protocol</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.ProtocolImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getProtocol()
   * @generated
   */
  int PROTOCOL = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL__NAME = 0;

  /**
   * The feature id for the '<em><b>Incoming Messages</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL__INCOMING_MESSAGES = 1;

  /**
   * The feature id for the '<em><b>Outgoing Messages</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL__OUTGOING_MESSAGES = 2;

  /**
   * The number of structural features of the '<em>Protocol</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOCOL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.SignalImpl <em>Signal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.SignalImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getSignal()
   * @generated
   */
  int SIGNAL = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIGNAL__NAME = 0;

  /**
   * The feature id for the '<em><b>Var Decls</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIGNAL__VAR_DECLS = 1;

  /**
   * The number of structural features of the '<em>Signal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIGNAL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.CapsuleImpl <em>Capsule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.CapsuleImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getCapsule()
   * @generated
   */
  int CAPSULE = 5;

  /**
   * The feature id for the '<em><b>Root</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPSULE__ROOT = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPSULE__NAME = 1;

  /**
   * The feature id for the '<em><b>Interface Ports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPSULE__INTERFACE_PORTS = 2;

  /**
   * The feature id for the '<em><b>Internal Ports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPSULE__INTERNAL_PORTS = 3;

  /**
   * The feature id for the '<em><b>Timer Ports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPSULE__TIMER_PORTS = 4;

  /**
   * The feature id for the '<em><b>Log Ports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPSULE__LOG_PORTS = 5;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPSULE__ATTRIBUTES = 6;

  /**
   * The feature id for the '<em><b>Capsule Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPSULE__CAPSULE_REFS = 7;

  /**
   * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPSULE__CONNECTORS = 8;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPSULE__OPERATIONS = 9;

  /**
   * The feature id for the '<em><b>Statemachines</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPSULE__STATEMACHINES = 10;

  /**
   * The number of structural features of the '<em>Capsule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPSULE_FEATURE_COUNT = 11;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.OperationImpl <em>Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.OperationImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getOperation()
   * @generated
   */
  int OPERATION = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Var Decls</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__VAR_DECLS = 1;

  /**
   * The feature id for the '<em><b>Operation Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__OPERATION_CODE = 2;

  /**
   * The number of structural features of the '<em>Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.TimerPortImpl <em>Timer Port</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.TimerPortImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getTimerPort()
   * @generated
   */
  int TIMER_PORT = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMER_PORT__NAME = 0;

  /**
   * The number of structural features of the '<em>Timer Port</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMER_PORT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.LogPortImpl <em>Log Port</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.LogPortImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getLogPort()
   * @generated
   */
  int LOG_PORT = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOG_PORT__NAME = 0;

  /**
   * The number of structural features of the '<em>Log Port</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOG_PORT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.PortImpl <em>Port</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.PortImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getPort()
   * @generated
   */
  int PORT = 9;

  /**
   * The feature id for the '<em><b>Conjugated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT__CONJUGATED = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT__NAME = 1;

  /**
   * The feature id for the '<em><b>Protocol</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT__PROTOCOL = 2;

  /**
   * The number of structural features of the '<em>Port</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.ConnectorImpl <em>Connector</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.ConnectorImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getConnector()
   * @generated
   */
  int CONNECTOR = 10;

  /**
   * The feature id for the '<em><b>Capsule Ref1</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTOR__CAPSULE_REF1 = 0;

  /**
   * The feature id for the '<em><b>Port1</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTOR__PORT1 = 1;

  /**
   * The feature id for the '<em><b>Capsule Ref2</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTOR__CAPSULE_REF2 = 2;

  /**
   * The feature id for the '<em><b>Port2</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTOR__PORT2 = 3;

  /**
   * The number of structural features of the '<em>Connector</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTOR_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.CapsuleRefImpl <em>Capsule Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.CapsuleRefImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getCapsuleRef()
   * @generated
   */
  int CAPSULE_REF = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPSULE_REF__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPSULE_REF__TYPE = 1;

  /**
   * The number of structural features of the '<em>Capsule Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPSULE_REF_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.StateMachineImpl <em>State Machine</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.StateMachineImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getStateMachine()
   * @generated
   */
  int STATE_MACHINE = 12;

  /**
   * The feature id for the '<em><b>States</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MACHINE__STATES = 0;

  /**
   * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MACHINE__TRANSITIONS = 1;

  /**
   * The number of structural features of the '<em>State Machine</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MACHINE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.State_Impl <em>State </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.State_Impl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getState_()
   * @generated
   */
  int STATE_ = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE___NAME = 0;

  /**
   * The feature id for the '<em><b>Entry Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE___ENTRY_CODE = 1;

  /**
   * The feature id for the '<em><b>Exit Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE___EXIT_CODE = 2;

  /**
   * The feature id for the '<em><b>Substatemachine</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE___SUBSTATEMACHINE = 3;

  /**
   * The number of structural features of the '<em>State </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.TransitionImpl <em>Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.TransitionImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getTransition()
   * @generated
   */
  int TRANSITION = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__NAME = 0;

  /**
   * The feature id for the '<em><b>Init</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__INIT = 1;

  /**
   * The feature id for the '<em><b>From</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__FROM = 2;

  /**
   * The feature id for the '<em><b>To</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__TO = 3;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__GUARD = 4;

  /**
   * The feature id for the '<em><b>Triggers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__TRIGGERS = 5;

  /**
   * The feature id for the '<em><b>Timer Port</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__TIMER_PORT = 6;

  /**
   * The feature id for the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__ACTION = 7;

  /**
   * The number of structural features of the '<em>Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_FEATURE_COUNT = 8;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.Trigger_inImpl <em>Trigger in</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.Trigger_inImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getTrigger_in()
   * @generated
   */
  int TRIGGER_IN = 15;

  /**
   * The feature id for the '<em><b>From</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER_IN__FROM = 0;

  /**
   * The feature id for the '<em><b>Signal</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER_IN__SIGNAL = 1;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER_IN__PARAMETERS = 2;

  /**
   * The number of structural features of the '<em>Trigger in</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER_IN_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.IncomingVariableImpl <em>Incoming Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.IncomingVariableImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getIncomingVariable()
   * @generated
   */
  int INCOMING_VARIABLE = 16;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCOMING_VARIABLE__NAME = ASSIGNABLE__NAME;

  /**
   * The number of structural features of the '<em>Incoming Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCOMING_VARIABLE_FEATURE_COUNT = ASSIGNABLE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.Trigger_outImpl <em>Trigger out</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.Trigger_outImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getTrigger_out()
   * @generated
   */
  int TRIGGER_OUT = 17;

  /**
   * The feature id for the '<em><b>To</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER_OUT__TO = 0;

  /**
   * The feature id for the '<em><b>Signal</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER_OUT__SIGNAL = 1;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER_OUT__PARAMETERS = 2;

  /**
   * The number of structural features of the '<em>Trigger out</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER_OUT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.OperationCodeImpl <em>Operation Code</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.OperationCodeImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getOperationCode()
   * @generated
   */
  int OPERATION_CODE = 18;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CODE__STATEMENTS = 0;

  /**
   * The number of structural features of the '<em>Operation Code</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CODE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.StatementOperationImpl <em>Statement Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.StatementOperationImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getStatementOperation()
   * @generated
   */
  int STATEMENT_OPERATION = 19;

  /**
   * The number of structural features of the '<em>Statement Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_OPERATION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.WhileLoopOperationImpl <em>While Loop Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.WhileLoopOperationImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getWhileLoopOperation()
   * @generated
   */
  int WHILE_LOOP_OPERATION = 20;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_LOOP_OPERATION__CONDITION = STATEMENT_OPERATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_LOOP_OPERATION__STATEMENTS = STATEMENT_OPERATION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>While Loop Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_LOOP_OPERATION_FEATURE_COUNT = STATEMENT_OPERATION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.IfStatementOperationImpl <em>If Statement Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.IfStatementOperationImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getIfStatementOperation()
   * @generated
   */
  int IF_STATEMENT_OPERATION = 21;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT_OPERATION__CONDITION = STATEMENT_OPERATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Then Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT_OPERATION__THEN_STATEMENTS = STATEMENT_OPERATION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Else Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT_OPERATION__ELSE_STATEMENTS = STATEMENT_OPERATION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>If Statement Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT_OPERATION_FEATURE_COUNT = STATEMENT_OPERATION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.ReturnStatementImpl <em>Return Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.ReturnStatementImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getReturnStatement()
   * @generated
   */
  int RETURN_STATEMENT = 22;

  /**
   * The feature id for the '<em><b>Return Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RETURN_STATEMENT__RETURN_VALUE = STATEMENT_OPERATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Return Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RETURN_STATEMENT_FEATURE_COUNT = STATEMENT_OPERATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.ActionCodeImpl <em>Action Code</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.ActionCodeImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getActionCode()
   * @generated
   */
  int ACTION_CODE = 23;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_CODE__STATEMENTS = 0;

  /**
   * The number of structural features of the '<em>Action Code</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_CODE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.StatementImpl <em>Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.StatementImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getStatement()
   * @generated
   */
  int STATEMENT = 24;

  /**
   * The number of structural features of the '<em>Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.VariableImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 25;

  /**
   * The feature id for the '<em><b>Var</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__VAR = STATEMENT_OPERATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Assign</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__ASSIGN = STATEMENT_OPERATION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__EXP = STATEMENT_OPERATION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_FEATURE_COUNT = STATEMENT_OPERATION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.SendTriggerImpl <em>Send Trigger</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.SendTriggerImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getSendTrigger()
   * @generated
   */
  int SEND_TRIGGER = 26;

  /**
   * The feature id for the '<em><b>Triggers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEND_TRIGGER__TRIGGERS = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Send Trigger</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEND_TRIGGER_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.InformTimerImpl <em>Inform Timer</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.InformTimerImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getInformTimer()
   * @generated
   */
  int INFORM_TIMER = 27;

  /**
   * The feature id for the '<em><b>Timer Port</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORM_TIMER__TIMER_PORT = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Time</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORM_TIMER__TIME = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Inform Timer</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORM_TIMER_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.NoOpImpl <em>No Op</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.NoOpImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getNoOp()
   * @generated
   */
  int NO_OP = 28;

  /**
   * The number of structural features of the '<em>No Op</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NO_OP_FEATURE_COUNT = STATEMENT_OPERATION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.InvokeImpl <em>Invoke</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.InvokeImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getInvoke()
   * @generated
   */
  int INVOKE = 29;

  /**
   * The feature id for the '<em><b>Operation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOKE__OPERATION = STATEMENT_OPERATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOKE__PARAMETERS = STATEMENT_OPERATION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Invoke</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOKE_FEATURE_COUNT = STATEMENT_OPERATION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.AssignmentImpl <em>Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.AssignmentImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getAssignment()
   * @generated
   */
  int ASSIGNMENT = 30;

  /**
   * The feature id for the '<em><b>Lvalue</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__LVALUE = STATEMENT_OPERATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__EXP = STATEMENT_OPERATION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_FEATURE_COUNT = STATEMENT_OPERATION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.WhileLoopImpl <em>While Loop</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.WhileLoopImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getWhileLoop()
   * @generated
   */
  int WHILE_LOOP = 32;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_LOOP__CONDITION = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_LOOP__STATEMENTS = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>While Loop</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_LOOP_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.IfStatementImpl <em>If Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.IfStatementImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getIfStatement()
   * @generated
   */
  int IF_STATEMENT = 33;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__CONDITION = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Then Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__THEN_STATEMENTS = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Else Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__ELSE_STATEMENTS = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>If Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.LogStatementImpl <em>Log Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.LogStatementImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getLogStatement()
   * @generated
   */
  int LOG_STATEMENT = 34;

  /**
   * The feature id for the '<em><b>Log Port</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOG_STATEMENT__LOG_PORT = STATEMENT_OPERATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOG_STATEMENT__LEFT = STATEMENT_OPERATION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Log Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOG_STATEMENT_FEATURE_COUNT = STATEMENT_OPERATION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.StringExpressionImpl <em>String Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.StringExpressionImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getStringExpression()
   * @generated
   */
  int STRING_EXPRESSION = 35;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_EXPRESSION__EXPR = 0;

  /**
   * The feature id for the '<em><b>Str</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_EXPRESSION__STR = 1;

  /**
   * The number of structural features of the '<em>String Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.ExpressionImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 36;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.NotBooleanExpressionImpl <em>Not Boolean Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.NotBooleanExpressionImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getNotBooleanExpression()
   * @generated
   */
  int NOT_BOOLEAN_EXPRESSION = 37;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_BOOLEAN_EXPRESSION__EXP = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Not Boolean Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_BOOLEAN_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.LiteralImpl <em>Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.LiteralImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getLiteral()
   * @generated
   */
  int LITERAL = 38;

  /**
   * The number of structural features of the '<em>Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.IntLiteralImpl <em>Int Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.IntLiteralImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getIntLiteral()
   * @generated
   */
  int INT_LITERAL = 39;

  /**
   * The feature id for the '<em><b>Int</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_LITERAL__INT = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Int Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.IdentifierImpl <em>Identifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.IdentifierImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getIdentifier()
   * @generated
   */
  int IDENTIFIER = 40;

  /**
   * The feature id for the '<em><b>Id</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER__ID = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Identifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.FunctionCallImpl <em>Function Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.FunctionCallImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getFunctionCall()
   * @generated
   */
  int FUNCTION_CALL = 41;

  /**
   * The feature id for the '<em><b>Call</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_CALL__CALL = LITERAL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Params</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_CALL__PARAMS = LITERAL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Function Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_CALL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.BoolLiteralImpl <em>Bool Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.BoolLiteralImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getBoolLiteral()
   * @generated
   */
  int BOOL_LITERAL = 42;

  /**
   * The feature id for the '<em><b>True</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_LITERAL__TRUE = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Bool Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.ConcatenateExpressionImpl <em>Concatenate Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.ConcatenateExpressionImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getConcatenateExpression()
   * @generated
   */
  int CONCATENATE_EXPRESSION = 43;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCATENATE_EXPRESSION__EXPR = STRING_EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>Str</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCATENATE_EXPRESSION__STR = STRING_EXPRESSION__STR;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCATENATE_EXPRESSION__LEFT = STRING_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Rest</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCATENATE_EXPRESSION__REST = STRING_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Concatenate Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCATENATE_EXPRESSION_FEATURE_COUNT = STRING_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.ConditionalOrExpressionImpl <em>Conditional Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.ConditionalOrExpressionImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getConditionalOrExpression()
   * @generated
   */
  int CONDITIONAL_OR_EXPRESSION = 44;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_OR_EXPRESSION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Rest</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_OR_EXPRESSION__REST = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Conditional Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_OR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.ConditionalAndExpressionImpl <em>Conditional And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.ConditionalAndExpressionImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getConditionalAndExpression()
   * @generated
   */
  int CONDITIONAL_AND_EXPRESSION = 45;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_AND_EXPRESSION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Rest</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_AND_EXPRESSION__REST = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Conditional And Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_AND_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.LessThanOrEqualImpl <em>Less Than Or Equal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.LessThanOrEqualImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getLessThanOrEqual()
   * @generated
   */
  int LESS_THAN_OR_EQUAL = 46;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LESS_THAN_OR_EQUAL__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Rest</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LESS_THAN_OR_EQUAL__REST = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Less Than Or Equal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LESS_THAN_OR_EQUAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.LessThanImpl <em>Less Than</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.LessThanImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getLessThan()
   * @generated
   */
  int LESS_THAN = 47;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LESS_THAN__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Rest</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LESS_THAN__REST = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Less Than</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LESS_THAN_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.GreaterThanOrEqualImpl <em>Greater Than Or Equal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.GreaterThanOrEqualImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getGreaterThanOrEqual()
   * @generated
   */
  int GREATER_THAN_OR_EQUAL = 48;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREATER_THAN_OR_EQUAL__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Rest</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREATER_THAN_OR_EQUAL__REST = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Greater Than Or Equal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREATER_THAN_OR_EQUAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.GreaterThanImpl <em>Greater Than</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.GreaterThanImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getGreaterThan()
   * @generated
   */
  int GREATER_THAN = 49;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREATER_THAN__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Rest</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREATER_THAN__REST = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Greater Than</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREATER_THAN_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.EqualImpl <em>Equal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.EqualImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getEqual()
   * @generated
   */
  int EQUAL = 50;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUAL__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Rest</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUAL__REST = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Equal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.NotEqualImpl <em>Not Equal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.NotEqualImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getNotEqual()
   * @generated
   */
  int NOT_EQUAL = 51;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_EQUAL__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Rest</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_EQUAL__REST = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Not Equal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_EQUAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.PlusImpl <em>Plus</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.PlusImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getPlus()
   * @generated
   */
  int PLUS = 52;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUS__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Rest</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUS__REST = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Plus</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.MinusImpl <em>Minus</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.MinusImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getMinus()
   * @generated
   */
  int MINUS = 53;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINUS__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Rest</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINUS__REST = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Minus</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINUS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.MultiplyImpl <em>Multiply</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.MultiplyImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getMultiply()
   * @generated
   */
  int MULTIPLY = 54;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLY__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Rest</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLY__REST = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Multiply</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLY_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.DivideImpl <em>Divide</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.DivideImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getDivide()
   * @generated
   */
  int DIVIDE = 55;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIVIDE__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Rest</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIVIDE__REST = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Divide</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIVIDE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.ModuloImpl <em>Modulo</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.ModuloImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getModulo()
   * @generated
   */
  int MODULO = 56;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULO__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Rest</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULO__REST = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Modulo</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULO_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ca.queensu.cs.mase.urml.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ca.queensu.cs.mase.urml.impl.UnaryExpressionImpl
   * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getUnaryExpression()
   * @generated
   */
  int UNARY_EXPRESSION = 57;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__EXP = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Unary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see ca.queensu.cs.mase.urml.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute '{@link ca.queensu.cs.mase.urml.Model#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see ca.queensu.cs.mase.urml.Model#getName()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Name();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.Model#getCapsules <em>Capsules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Capsules</em>'.
   * @see ca.queensu.cs.mase.urml.Model#getCapsules()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Capsules();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.Model#getProtocols <em>Protocols</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Protocols</em>'.
   * @see ca.queensu.cs.mase.urml.Model#getProtocols()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Protocols();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.VarDecl <em>Var Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Decl</em>'.
   * @see ca.queensu.cs.mase.urml.VarDecl
   * @generated
   */
  EClass getVarDecl();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see ca.queensu.cs.mase.urml.Attribute
   * @generated
   */
  EClass getAttribute();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.Attribute#getDefaultValue <em>Default Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Default Value</em>'.
   * @see ca.queensu.cs.mase.urml.Attribute#getDefaultValue()
   * @see #getAttribute()
   * @generated
   */
  EReference getAttribute_DefaultValue();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.Protocol <em>Protocol</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Protocol</em>'.
   * @see ca.queensu.cs.mase.urml.Protocol
   * @generated
   */
  EClass getProtocol();

  /**
   * Returns the meta object for the attribute '{@link ca.queensu.cs.mase.urml.Protocol#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see ca.queensu.cs.mase.urml.Protocol#getName()
   * @see #getProtocol()
   * @generated
   */
  EAttribute getProtocol_Name();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.Protocol#getIncomingMessages <em>Incoming Messages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Incoming Messages</em>'.
   * @see ca.queensu.cs.mase.urml.Protocol#getIncomingMessages()
   * @see #getProtocol()
   * @generated
   */
  EReference getProtocol_IncomingMessages();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.Protocol#getOutgoingMessages <em>Outgoing Messages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Outgoing Messages</em>'.
   * @see ca.queensu.cs.mase.urml.Protocol#getOutgoingMessages()
   * @see #getProtocol()
   * @generated
   */
  EReference getProtocol_OutgoingMessages();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.Signal <em>Signal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Signal</em>'.
   * @see ca.queensu.cs.mase.urml.Signal
   * @generated
   */
  EClass getSignal();

  /**
   * Returns the meta object for the attribute '{@link ca.queensu.cs.mase.urml.Signal#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see ca.queensu.cs.mase.urml.Signal#getName()
   * @see #getSignal()
   * @generated
   */
  EAttribute getSignal_Name();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.Signal#getVarDecls <em>Var Decls</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Var Decls</em>'.
   * @see ca.queensu.cs.mase.urml.Signal#getVarDecls()
   * @see #getSignal()
   * @generated
   */
  EReference getSignal_VarDecls();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.Capsule <em>Capsule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Capsule</em>'.
   * @see ca.queensu.cs.mase.urml.Capsule
   * @generated
   */
  EClass getCapsule();

  /**
   * Returns the meta object for the attribute '{@link ca.queensu.cs.mase.urml.Capsule#isRoot <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Root</em>'.
   * @see ca.queensu.cs.mase.urml.Capsule#isRoot()
   * @see #getCapsule()
   * @generated
   */
  EAttribute getCapsule_Root();

  /**
   * Returns the meta object for the attribute '{@link ca.queensu.cs.mase.urml.Capsule#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see ca.queensu.cs.mase.urml.Capsule#getName()
   * @see #getCapsule()
   * @generated
   */
  EAttribute getCapsule_Name();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.Capsule#getInterfacePorts <em>Interface Ports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Interface Ports</em>'.
   * @see ca.queensu.cs.mase.urml.Capsule#getInterfacePorts()
   * @see #getCapsule()
   * @generated
   */
  EReference getCapsule_InterfacePorts();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.Capsule#getInternalPorts <em>Internal Ports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Internal Ports</em>'.
   * @see ca.queensu.cs.mase.urml.Capsule#getInternalPorts()
   * @see #getCapsule()
   * @generated
   */
  EReference getCapsule_InternalPorts();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.Capsule#getTimerPorts <em>Timer Ports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Timer Ports</em>'.
   * @see ca.queensu.cs.mase.urml.Capsule#getTimerPorts()
   * @see #getCapsule()
   * @generated
   */
  EReference getCapsule_TimerPorts();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.Capsule#getLogPorts <em>Log Ports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Log Ports</em>'.
   * @see ca.queensu.cs.mase.urml.Capsule#getLogPorts()
   * @see #getCapsule()
   * @generated
   */
  EReference getCapsule_LogPorts();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.Capsule#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see ca.queensu.cs.mase.urml.Capsule#getAttributes()
   * @see #getCapsule()
   * @generated
   */
  EReference getCapsule_Attributes();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.Capsule#getCapsuleRefs <em>Capsule Refs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Capsule Refs</em>'.
   * @see ca.queensu.cs.mase.urml.Capsule#getCapsuleRefs()
   * @see #getCapsule()
   * @generated
   */
  EReference getCapsule_CapsuleRefs();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.Capsule#getConnectors <em>Connectors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Connectors</em>'.
   * @see ca.queensu.cs.mase.urml.Capsule#getConnectors()
   * @see #getCapsule()
   * @generated
   */
  EReference getCapsule_Connectors();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.Capsule#getOperations <em>Operations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operations</em>'.
   * @see ca.queensu.cs.mase.urml.Capsule#getOperations()
   * @see #getCapsule()
   * @generated
   */
  EReference getCapsule_Operations();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.Capsule#getStatemachines <em>Statemachines</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statemachines</em>'.
   * @see ca.queensu.cs.mase.urml.Capsule#getStatemachines()
   * @see #getCapsule()
   * @generated
   */
  EReference getCapsule_Statemachines();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.Operation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operation</em>'.
   * @see ca.queensu.cs.mase.urml.Operation
   * @generated
   */
  EClass getOperation();

  /**
   * Returns the meta object for the attribute '{@link ca.queensu.cs.mase.urml.Operation#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see ca.queensu.cs.mase.urml.Operation#getName()
   * @see #getOperation()
   * @generated
   */
  EAttribute getOperation_Name();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.Operation#getVarDecls <em>Var Decls</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Var Decls</em>'.
   * @see ca.queensu.cs.mase.urml.Operation#getVarDecls()
   * @see #getOperation()
   * @generated
   */
  EReference getOperation_VarDecls();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.Operation#getOperationCode <em>Operation Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operation Code</em>'.
   * @see ca.queensu.cs.mase.urml.Operation#getOperationCode()
   * @see #getOperation()
   * @generated
   */
  EReference getOperation_OperationCode();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.TimerPort <em>Timer Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Timer Port</em>'.
   * @see ca.queensu.cs.mase.urml.TimerPort
   * @generated
   */
  EClass getTimerPort();

  /**
   * Returns the meta object for the attribute '{@link ca.queensu.cs.mase.urml.TimerPort#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see ca.queensu.cs.mase.urml.TimerPort#getName()
   * @see #getTimerPort()
   * @generated
   */
  EAttribute getTimerPort_Name();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.LogPort <em>Log Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Log Port</em>'.
   * @see ca.queensu.cs.mase.urml.LogPort
   * @generated
   */
  EClass getLogPort();

  /**
   * Returns the meta object for the attribute '{@link ca.queensu.cs.mase.urml.LogPort#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see ca.queensu.cs.mase.urml.LogPort#getName()
   * @see #getLogPort()
   * @generated
   */
  EAttribute getLogPort_Name();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.Port <em>Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port</em>'.
   * @see ca.queensu.cs.mase.urml.Port
   * @generated
   */
  EClass getPort();

  /**
   * Returns the meta object for the attribute '{@link ca.queensu.cs.mase.urml.Port#isConjugated <em>Conjugated</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Conjugated</em>'.
   * @see ca.queensu.cs.mase.urml.Port#isConjugated()
   * @see #getPort()
   * @generated
   */
  EAttribute getPort_Conjugated();

  /**
   * Returns the meta object for the attribute '{@link ca.queensu.cs.mase.urml.Port#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see ca.queensu.cs.mase.urml.Port#getName()
   * @see #getPort()
   * @generated
   */
  EAttribute getPort_Name();

  /**
   * Returns the meta object for the reference '{@link ca.queensu.cs.mase.urml.Port#getProtocol <em>Protocol</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Protocol</em>'.
   * @see ca.queensu.cs.mase.urml.Port#getProtocol()
   * @see #getPort()
   * @generated
   */
  EReference getPort_Protocol();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.Connector <em>Connector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Connector</em>'.
   * @see ca.queensu.cs.mase.urml.Connector
   * @generated
   */
  EClass getConnector();

  /**
   * Returns the meta object for the reference '{@link ca.queensu.cs.mase.urml.Connector#getCapsuleRef1 <em>Capsule Ref1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Capsule Ref1</em>'.
   * @see ca.queensu.cs.mase.urml.Connector#getCapsuleRef1()
   * @see #getConnector()
   * @generated
   */
  EReference getConnector_CapsuleRef1();

  /**
   * Returns the meta object for the reference '{@link ca.queensu.cs.mase.urml.Connector#getPort1 <em>Port1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Port1</em>'.
   * @see ca.queensu.cs.mase.urml.Connector#getPort1()
   * @see #getConnector()
   * @generated
   */
  EReference getConnector_Port1();

  /**
   * Returns the meta object for the reference '{@link ca.queensu.cs.mase.urml.Connector#getCapsuleRef2 <em>Capsule Ref2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Capsule Ref2</em>'.
   * @see ca.queensu.cs.mase.urml.Connector#getCapsuleRef2()
   * @see #getConnector()
   * @generated
   */
  EReference getConnector_CapsuleRef2();

  /**
   * Returns the meta object for the reference '{@link ca.queensu.cs.mase.urml.Connector#getPort2 <em>Port2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Port2</em>'.
   * @see ca.queensu.cs.mase.urml.Connector#getPort2()
   * @see #getConnector()
   * @generated
   */
  EReference getConnector_Port2();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.CapsuleRef <em>Capsule Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Capsule Ref</em>'.
   * @see ca.queensu.cs.mase.urml.CapsuleRef
   * @generated
   */
  EClass getCapsuleRef();

  /**
   * Returns the meta object for the attribute '{@link ca.queensu.cs.mase.urml.CapsuleRef#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see ca.queensu.cs.mase.urml.CapsuleRef#getName()
   * @see #getCapsuleRef()
   * @generated
   */
  EAttribute getCapsuleRef_Name();

  /**
   * Returns the meta object for the reference '{@link ca.queensu.cs.mase.urml.CapsuleRef#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see ca.queensu.cs.mase.urml.CapsuleRef#getType()
   * @see #getCapsuleRef()
   * @generated
   */
  EReference getCapsuleRef_Type();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.StateMachine <em>State Machine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Machine</em>'.
   * @see ca.queensu.cs.mase.urml.StateMachine
   * @generated
   */
  EClass getStateMachine();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.StateMachine#getStates <em>States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>States</em>'.
   * @see ca.queensu.cs.mase.urml.StateMachine#getStates()
   * @see #getStateMachine()
   * @generated
   */
  EReference getStateMachine_States();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.StateMachine#getTransitions <em>Transitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transitions</em>'.
   * @see ca.queensu.cs.mase.urml.StateMachine#getTransitions()
   * @see #getStateMachine()
   * @generated
   */
  EReference getStateMachine_Transitions();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.State_ <em>State </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State </em>'.
   * @see ca.queensu.cs.mase.urml.State_
   * @generated
   */
  EClass getState_();

  /**
   * Returns the meta object for the attribute '{@link ca.queensu.cs.mase.urml.State_#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see ca.queensu.cs.mase.urml.State_#getName()
   * @see #getState_()
   * @generated
   */
  EAttribute getState__Name();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.State_#getEntryCode <em>Entry Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Entry Code</em>'.
   * @see ca.queensu.cs.mase.urml.State_#getEntryCode()
   * @see #getState_()
   * @generated
   */
  EReference getState__EntryCode();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.State_#getExitCode <em>Exit Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exit Code</em>'.
   * @see ca.queensu.cs.mase.urml.State_#getExitCode()
   * @see #getState_()
   * @generated
   */
  EReference getState__ExitCode();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.State_#getSubstatemachine <em>Substatemachine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Substatemachine</em>'.
   * @see ca.queensu.cs.mase.urml.State_#getSubstatemachine()
   * @see #getState_()
   * @generated
   */
  EReference getState__Substatemachine();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.Transition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition</em>'.
   * @see ca.queensu.cs.mase.urml.Transition
   * @generated
   */
  EClass getTransition();

  /**
   * Returns the meta object for the attribute '{@link ca.queensu.cs.mase.urml.Transition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see ca.queensu.cs.mase.urml.Transition#getName()
   * @see #getTransition()
   * @generated
   */
  EAttribute getTransition_Name();

  /**
   * Returns the meta object for the attribute '{@link ca.queensu.cs.mase.urml.Transition#isInit <em>Init</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Init</em>'.
   * @see ca.queensu.cs.mase.urml.Transition#isInit()
   * @see #getTransition()
   * @generated
   */
  EAttribute getTransition_Init();

  /**
   * Returns the meta object for the reference '{@link ca.queensu.cs.mase.urml.Transition#getFrom <em>From</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>From</em>'.
   * @see ca.queensu.cs.mase.urml.Transition#getFrom()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_From();

  /**
   * Returns the meta object for the reference '{@link ca.queensu.cs.mase.urml.Transition#getTo <em>To</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>To</em>'.
   * @see ca.queensu.cs.mase.urml.Transition#getTo()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_To();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.Transition#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guard</em>'.
   * @see ca.queensu.cs.mase.urml.Transition#getGuard()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_Guard();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.Transition#getTriggers <em>Triggers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Triggers</em>'.
   * @see ca.queensu.cs.mase.urml.Transition#getTriggers()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_Triggers();

  /**
   * Returns the meta object for the reference '{@link ca.queensu.cs.mase.urml.Transition#getTimerPort <em>Timer Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Timer Port</em>'.
   * @see ca.queensu.cs.mase.urml.Transition#getTimerPort()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_TimerPort();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.Transition#getAction <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Action</em>'.
   * @see ca.queensu.cs.mase.urml.Transition#getAction()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_Action();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.Trigger_in <em>Trigger in</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trigger in</em>'.
   * @see ca.queensu.cs.mase.urml.Trigger_in
   * @generated
   */
  EClass getTrigger_in();

  /**
   * Returns the meta object for the reference '{@link ca.queensu.cs.mase.urml.Trigger_in#getFrom <em>From</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>From</em>'.
   * @see ca.queensu.cs.mase.urml.Trigger_in#getFrom()
   * @see #getTrigger_in()
   * @generated
   */
  EReference getTrigger_in_From();

  /**
   * Returns the meta object for the reference '{@link ca.queensu.cs.mase.urml.Trigger_in#getSignal <em>Signal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Signal</em>'.
   * @see ca.queensu.cs.mase.urml.Trigger_in#getSignal()
   * @see #getTrigger_in()
   * @generated
   */
  EReference getTrigger_in_Signal();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.Trigger_in#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see ca.queensu.cs.mase.urml.Trigger_in#getParameters()
   * @see #getTrigger_in()
   * @generated
   */
  EReference getTrigger_in_Parameters();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.IncomingVariable <em>Incoming Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Incoming Variable</em>'.
   * @see ca.queensu.cs.mase.urml.IncomingVariable
   * @generated
   */
  EClass getIncomingVariable();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.Trigger_out <em>Trigger out</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trigger out</em>'.
   * @see ca.queensu.cs.mase.urml.Trigger_out
   * @generated
   */
  EClass getTrigger_out();

  /**
   * Returns the meta object for the reference '{@link ca.queensu.cs.mase.urml.Trigger_out#getTo <em>To</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>To</em>'.
   * @see ca.queensu.cs.mase.urml.Trigger_out#getTo()
   * @see #getTrigger_out()
   * @generated
   */
  EReference getTrigger_out_To();

  /**
   * Returns the meta object for the reference '{@link ca.queensu.cs.mase.urml.Trigger_out#getSignal <em>Signal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Signal</em>'.
   * @see ca.queensu.cs.mase.urml.Trigger_out#getSignal()
   * @see #getTrigger_out()
   * @generated
   */
  EReference getTrigger_out_Signal();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.Trigger_out#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see ca.queensu.cs.mase.urml.Trigger_out#getParameters()
   * @see #getTrigger_out()
   * @generated
   */
  EReference getTrigger_out_Parameters();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.OperationCode <em>Operation Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operation Code</em>'.
   * @see ca.queensu.cs.mase.urml.OperationCode
   * @generated
   */
  EClass getOperationCode();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.OperationCode#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see ca.queensu.cs.mase.urml.OperationCode#getStatements()
   * @see #getOperationCode()
   * @generated
   */
  EReference getOperationCode_Statements();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.StatementOperation <em>Statement Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement Operation</em>'.
   * @see ca.queensu.cs.mase.urml.StatementOperation
   * @generated
   */
  EClass getStatementOperation();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.WhileLoopOperation <em>While Loop Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>While Loop Operation</em>'.
   * @see ca.queensu.cs.mase.urml.WhileLoopOperation
   * @generated
   */
  EClass getWhileLoopOperation();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.WhileLoopOperation#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see ca.queensu.cs.mase.urml.WhileLoopOperation#getCondition()
   * @see #getWhileLoopOperation()
   * @generated
   */
  EReference getWhileLoopOperation_Condition();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.WhileLoopOperation#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see ca.queensu.cs.mase.urml.WhileLoopOperation#getStatements()
   * @see #getWhileLoopOperation()
   * @generated
   */
  EReference getWhileLoopOperation_Statements();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.IfStatementOperation <em>If Statement Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Statement Operation</em>'.
   * @see ca.queensu.cs.mase.urml.IfStatementOperation
   * @generated
   */
  EClass getIfStatementOperation();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.IfStatementOperation#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see ca.queensu.cs.mase.urml.IfStatementOperation#getCondition()
   * @see #getIfStatementOperation()
   * @generated
   */
  EReference getIfStatementOperation_Condition();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.IfStatementOperation#getThenStatements <em>Then Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Then Statements</em>'.
   * @see ca.queensu.cs.mase.urml.IfStatementOperation#getThenStatements()
   * @see #getIfStatementOperation()
   * @generated
   */
  EReference getIfStatementOperation_ThenStatements();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.IfStatementOperation#getElseStatements <em>Else Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Else Statements</em>'.
   * @see ca.queensu.cs.mase.urml.IfStatementOperation#getElseStatements()
   * @see #getIfStatementOperation()
   * @generated
   */
  EReference getIfStatementOperation_ElseStatements();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.ReturnStatement <em>Return Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Return Statement</em>'.
   * @see ca.queensu.cs.mase.urml.ReturnStatement
   * @generated
   */
  EClass getReturnStatement();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.ReturnStatement#getReturnValue <em>Return Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Return Value</em>'.
   * @see ca.queensu.cs.mase.urml.ReturnStatement#getReturnValue()
   * @see #getReturnStatement()
   * @generated
   */
  EReference getReturnStatement_ReturnValue();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.ActionCode <em>Action Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Action Code</em>'.
   * @see ca.queensu.cs.mase.urml.ActionCode
   * @generated
   */
  EClass getActionCode();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.ActionCode#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see ca.queensu.cs.mase.urml.ActionCode#getStatements()
   * @see #getActionCode()
   * @generated
   */
  EReference getActionCode_Statements();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement</em>'.
   * @see ca.queensu.cs.mase.urml.Statement
   * @generated
   */
  EClass getStatement();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see ca.queensu.cs.mase.urml.Variable
   * @generated
   */
  EClass getVariable();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.Variable#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Var</em>'.
   * @see ca.queensu.cs.mase.urml.Variable#getVar()
   * @see #getVariable()
   * @generated
   */
  EReference getVariable_Var();

  /**
   * Returns the meta object for the attribute '{@link ca.queensu.cs.mase.urml.Variable#isAssign <em>Assign</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Assign</em>'.
   * @see ca.queensu.cs.mase.urml.Variable#isAssign()
   * @see #getVariable()
   * @generated
   */
  EAttribute getVariable_Assign();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.Variable#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp</em>'.
   * @see ca.queensu.cs.mase.urml.Variable#getExp()
   * @see #getVariable()
   * @generated
   */
  EReference getVariable_Exp();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.SendTrigger <em>Send Trigger</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Send Trigger</em>'.
   * @see ca.queensu.cs.mase.urml.SendTrigger
   * @generated
   */
  EClass getSendTrigger();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.SendTrigger#getTriggers <em>Triggers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Triggers</em>'.
   * @see ca.queensu.cs.mase.urml.SendTrigger#getTriggers()
   * @see #getSendTrigger()
   * @generated
   */
  EReference getSendTrigger_Triggers();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.InformTimer <em>Inform Timer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Inform Timer</em>'.
   * @see ca.queensu.cs.mase.urml.InformTimer
   * @generated
   */
  EClass getInformTimer();

  /**
   * Returns the meta object for the reference '{@link ca.queensu.cs.mase.urml.InformTimer#getTimerPort <em>Timer Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Timer Port</em>'.
   * @see ca.queensu.cs.mase.urml.InformTimer#getTimerPort()
   * @see #getInformTimer()
   * @generated
   */
  EReference getInformTimer_TimerPort();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.InformTimer#getTime <em>Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Time</em>'.
   * @see ca.queensu.cs.mase.urml.InformTimer#getTime()
   * @see #getInformTimer()
   * @generated
   */
  EReference getInformTimer_Time();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.NoOp <em>No Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>No Op</em>'.
   * @see ca.queensu.cs.mase.urml.NoOp
   * @generated
   */
  EClass getNoOp();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.Invoke <em>Invoke</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Invoke</em>'.
   * @see ca.queensu.cs.mase.urml.Invoke
   * @generated
   */
  EClass getInvoke();

  /**
   * Returns the meta object for the reference '{@link ca.queensu.cs.mase.urml.Invoke#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Operation</em>'.
   * @see ca.queensu.cs.mase.urml.Invoke#getOperation()
   * @see #getInvoke()
   * @generated
   */
  EReference getInvoke_Operation();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.Invoke#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see ca.queensu.cs.mase.urml.Invoke#getParameters()
   * @see #getInvoke()
   * @generated
   */
  EReference getInvoke_Parameters();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.Assignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment</em>'.
   * @see ca.queensu.cs.mase.urml.Assignment
   * @generated
   */
  EClass getAssignment();

  /**
   * Returns the meta object for the reference '{@link ca.queensu.cs.mase.urml.Assignment#getLvalue <em>Lvalue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Lvalue</em>'.
   * @see ca.queensu.cs.mase.urml.Assignment#getLvalue()
   * @see #getAssignment()
   * @generated
   */
  EReference getAssignment_Lvalue();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.Assignment#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp</em>'.
   * @see ca.queensu.cs.mase.urml.Assignment#getExp()
   * @see #getAssignment()
   * @generated
   */
  EReference getAssignment_Exp();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.Assignable <em>Assignable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignable</em>'.
   * @see ca.queensu.cs.mase.urml.Assignable
   * @generated
   */
  EClass getAssignable();

  /**
   * Returns the meta object for the attribute '{@link ca.queensu.cs.mase.urml.Assignable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see ca.queensu.cs.mase.urml.Assignable#getName()
   * @see #getAssignable()
   * @generated
   */
  EAttribute getAssignable_Name();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.WhileLoop <em>While Loop</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>While Loop</em>'.
   * @see ca.queensu.cs.mase.urml.WhileLoop
   * @generated
   */
  EClass getWhileLoop();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.WhileLoop#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see ca.queensu.cs.mase.urml.WhileLoop#getCondition()
   * @see #getWhileLoop()
   * @generated
   */
  EReference getWhileLoop_Condition();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.WhileLoop#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see ca.queensu.cs.mase.urml.WhileLoop#getStatements()
   * @see #getWhileLoop()
   * @generated
   */
  EReference getWhileLoop_Statements();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.IfStatement <em>If Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Statement</em>'.
   * @see ca.queensu.cs.mase.urml.IfStatement
   * @generated
   */
  EClass getIfStatement();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.IfStatement#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see ca.queensu.cs.mase.urml.IfStatement#getCondition()
   * @see #getIfStatement()
   * @generated
   */
  EReference getIfStatement_Condition();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.IfStatement#getThenStatements <em>Then Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Then Statements</em>'.
   * @see ca.queensu.cs.mase.urml.IfStatement#getThenStatements()
   * @see #getIfStatement()
   * @generated
   */
  EReference getIfStatement_ThenStatements();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.IfStatement#getElseStatements <em>Else Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Else Statements</em>'.
   * @see ca.queensu.cs.mase.urml.IfStatement#getElseStatements()
   * @see #getIfStatement()
   * @generated
   */
  EReference getIfStatement_ElseStatements();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.LogStatement <em>Log Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Log Statement</em>'.
   * @see ca.queensu.cs.mase.urml.LogStatement
   * @generated
   */
  EClass getLogStatement();

  /**
   * Returns the meta object for the reference '{@link ca.queensu.cs.mase.urml.LogStatement#getLogPort <em>Log Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Log Port</em>'.
   * @see ca.queensu.cs.mase.urml.LogStatement#getLogPort()
   * @see #getLogStatement()
   * @generated
   */
  EReference getLogStatement_LogPort();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.LogStatement#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see ca.queensu.cs.mase.urml.LogStatement#getLeft()
   * @see #getLogStatement()
   * @generated
   */
  EReference getLogStatement_Left();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.StringExpression <em>String Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Expression</em>'.
   * @see ca.queensu.cs.mase.urml.StringExpression
   * @generated
   */
  EClass getStringExpression();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.StringExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see ca.queensu.cs.mase.urml.StringExpression#getExpr()
   * @see #getStringExpression()
   * @generated
   */
  EReference getStringExpression_Expr();

  /**
   * Returns the meta object for the attribute '{@link ca.queensu.cs.mase.urml.StringExpression#getStr <em>Str</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Str</em>'.
   * @see ca.queensu.cs.mase.urml.StringExpression#getStr()
   * @see #getStringExpression()
   * @generated
   */
  EAttribute getStringExpression_Str();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see ca.queensu.cs.mase.urml.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.NotBooleanExpression <em>Not Boolean Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Not Boolean Expression</em>'.
   * @see ca.queensu.cs.mase.urml.NotBooleanExpression
   * @generated
   */
  EClass getNotBooleanExpression();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.NotBooleanExpression#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp</em>'.
   * @see ca.queensu.cs.mase.urml.NotBooleanExpression#getExp()
   * @see #getNotBooleanExpression()
   * @generated
   */
  EReference getNotBooleanExpression_Exp();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal</em>'.
   * @see ca.queensu.cs.mase.urml.Literal
   * @generated
   */
  EClass getLiteral();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.IntLiteral <em>Int Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int Literal</em>'.
   * @see ca.queensu.cs.mase.urml.IntLiteral
   * @generated
   */
  EClass getIntLiteral();

  /**
   * Returns the meta object for the attribute '{@link ca.queensu.cs.mase.urml.IntLiteral#getInt <em>Int</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Int</em>'.
   * @see ca.queensu.cs.mase.urml.IntLiteral#getInt()
   * @see #getIntLiteral()
   * @generated
   */
  EAttribute getIntLiteral_Int();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.Identifier <em>Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Identifier</em>'.
   * @see ca.queensu.cs.mase.urml.Identifier
   * @generated
   */
  EClass getIdentifier();

  /**
   * Returns the meta object for the reference '{@link ca.queensu.cs.mase.urml.Identifier#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Id</em>'.
   * @see ca.queensu.cs.mase.urml.Identifier#getId()
   * @see #getIdentifier()
   * @generated
   */
  EReference getIdentifier_Id();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.FunctionCall <em>Function Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Call</em>'.
   * @see ca.queensu.cs.mase.urml.FunctionCall
   * @generated
   */
  EClass getFunctionCall();

  /**
   * Returns the meta object for the reference '{@link ca.queensu.cs.mase.urml.FunctionCall#getCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Call</em>'.
   * @see ca.queensu.cs.mase.urml.FunctionCall#getCall()
   * @see #getFunctionCall()
   * @generated
   */
  EReference getFunctionCall_Call();

  /**
   * Returns the meta object for the containment reference list '{@link ca.queensu.cs.mase.urml.FunctionCall#getParams <em>Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Params</em>'.
   * @see ca.queensu.cs.mase.urml.FunctionCall#getParams()
   * @see #getFunctionCall()
   * @generated
   */
  EReference getFunctionCall_Params();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.BoolLiteral <em>Bool Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bool Literal</em>'.
   * @see ca.queensu.cs.mase.urml.BoolLiteral
   * @generated
   */
  EClass getBoolLiteral();

  /**
   * Returns the meta object for the attribute '{@link ca.queensu.cs.mase.urml.BoolLiteral#isTrue <em>True</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>True</em>'.
   * @see ca.queensu.cs.mase.urml.BoolLiteral#isTrue()
   * @see #getBoolLiteral()
   * @generated
   */
  EAttribute getBoolLiteral_True();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.ConcatenateExpression <em>Concatenate Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Concatenate Expression</em>'.
   * @see ca.queensu.cs.mase.urml.ConcatenateExpression
   * @generated
   */
  EClass getConcatenateExpression();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.ConcatenateExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see ca.queensu.cs.mase.urml.ConcatenateExpression#getLeft()
   * @see #getConcatenateExpression()
   * @generated
   */
  EReference getConcatenateExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.ConcatenateExpression#getRest <em>Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rest</em>'.
   * @see ca.queensu.cs.mase.urml.ConcatenateExpression#getRest()
   * @see #getConcatenateExpression()
   * @generated
   */
  EReference getConcatenateExpression_Rest();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.ConditionalOrExpression <em>Conditional Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Conditional Or Expression</em>'.
   * @see ca.queensu.cs.mase.urml.ConditionalOrExpression
   * @generated
   */
  EClass getConditionalOrExpression();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.ConditionalOrExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see ca.queensu.cs.mase.urml.ConditionalOrExpression#getLeft()
   * @see #getConditionalOrExpression()
   * @generated
   */
  EReference getConditionalOrExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.ConditionalOrExpression#getRest <em>Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rest</em>'.
   * @see ca.queensu.cs.mase.urml.ConditionalOrExpression#getRest()
   * @see #getConditionalOrExpression()
   * @generated
   */
  EReference getConditionalOrExpression_Rest();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.ConditionalAndExpression <em>Conditional And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Conditional And Expression</em>'.
   * @see ca.queensu.cs.mase.urml.ConditionalAndExpression
   * @generated
   */
  EClass getConditionalAndExpression();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.ConditionalAndExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see ca.queensu.cs.mase.urml.ConditionalAndExpression#getLeft()
   * @see #getConditionalAndExpression()
   * @generated
   */
  EReference getConditionalAndExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.ConditionalAndExpression#getRest <em>Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rest</em>'.
   * @see ca.queensu.cs.mase.urml.ConditionalAndExpression#getRest()
   * @see #getConditionalAndExpression()
   * @generated
   */
  EReference getConditionalAndExpression_Rest();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.LessThanOrEqual <em>Less Than Or Equal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Less Than Or Equal</em>'.
   * @see ca.queensu.cs.mase.urml.LessThanOrEqual
   * @generated
   */
  EClass getLessThanOrEqual();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.LessThanOrEqual#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see ca.queensu.cs.mase.urml.LessThanOrEqual#getLeft()
   * @see #getLessThanOrEqual()
   * @generated
   */
  EReference getLessThanOrEqual_Left();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.LessThanOrEqual#getRest <em>Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rest</em>'.
   * @see ca.queensu.cs.mase.urml.LessThanOrEqual#getRest()
   * @see #getLessThanOrEqual()
   * @generated
   */
  EReference getLessThanOrEqual_Rest();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.LessThan <em>Less Than</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Less Than</em>'.
   * @see ca.queensu.cs.mase.urml.LessThan
   * @generated
   */
  EClass getLessThan();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.LessThan#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see ca.queensu.cs.mase.urml.LessThan#getLeft()
   * @see #getLessThan()
   * @generated
   */
  EReference getLessThan_Left();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.LessThan#getRest <em>Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rest</em>'.
   * @see ca.queensu.cs.mase.urml.LessThan#getRest()
   * @see #getLessThan()
   * @generated
   */
  EReference getLessThan_Rest();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.GreaterThanOrEqual <em>Greater Than Or Equal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Greater Than Or Equal</em>'.
   * @see ca.queensu.cs.mase.urml.GreaterThanOrEqual
   * @generated
   */
  EClass getGreaterThanOrEqual();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.GreaterThanOrEqual#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see ca.queensu.cs.mase.urml.GreaterThanOrEqual#getLeft()
   * @see #getGreaterThanOrEqual()
   * @generated
   */
  EReference getGreaterThanOrEqual_Left();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.GreaterThanOrEqual#getRest <em>Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rest</em>'.
   * @see ca.queensu.cs.mase.urml.GreaterThanOrEqual#getRest()
   * @see #getGreaterThanOrEqual()
   * @generated
   */
  EReference getGreaterThanOrEqual_Rest();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.GreaterThan <em>Greater Than</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Greater Than</em>'.
   * @see ca.queensu.cs.mase.urml.GreaterThan
   * @generated
   */
  EClass getGreaterThan();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.GreaterThan#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see ca.queensu.cs.mase.urml.GreaterThan#getLeft()
   * @see #getGreaterThan()
   * @generated
   */
  EReference getGreaterThan_Left();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.GreaterThan#getRest <em>Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rest</em>'.
   * @see ca.queensu.cs.mase.urml.GreaterThan#getRest()
   * @see #getGreaterThan()
   * @generated
   */
  EReference getGreaterThan_Rest();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.Equal <em>Equal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equal</em>'.
   * @see ca.queensu.cs.mase.urml.Equal
   * @generated
   */
  EClass getEqual();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.Equal#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see ca.queensu.cs.mase.urml.Equal#getLeft()
   * @see #getEqual()
   * @generated
   */
  EReference getEqual_Left();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.Equal#getRest <em>Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rest</em>'.
   * @see ca.queensu.cs.mase.urml.Equal#getRest()
   * @see #getEqual()
   * @generated
   */
  EReference getEqual_Rest();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.NotEqual <em>Not Equal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Not Equal</em>'.
   * @see ca.queensu.cs.mase.urml.NotEqual
   * @generated
   */
  EClass getNotEqual();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.NotEqual#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see ca.queensu.cs.mase.urml.NotEqual#getLeft()
   * @see #getNotEqual()
   * @generated
   */
  EReference getNotEqual_Left();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.NotEqual#getRest <em>Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rest</em>'.
   * @see ca.queensu.cs.mase.urml.NotEqual#getRest()
   * @see #getNotEqual()
   * @generated
   */
  EReference getNotEqual_Rest();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.Plus <em>Plus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Plus</em>'.
   * @see ca.queensu.cs.mase.urml.Plus
   * @generated
   */
  EClass getPlus();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.Plus#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see ca.queensu.cs.mase.urml.Plus#getLeft()
   * @see #getPlus()
   * @generated
   */
  EReference getPlus_Left();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.Plus#getRest <em>Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rest</em>'.
   * @see ca.queensu.cs.mase.urml.Plus#getRest()
   * @see #getPlus()
   * @generated
   */
  EReference getPlus_Rest();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.Minus <em>Minus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Minus</em>'.
   * @see ca.queensu.cs.mase.urml.Minus
   * @generated
   */
  EClass getMinus();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.Minus#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see ca.queensu.cs.mase.urml.Minus#getLeft()
   * @see #getMinus()
   * @generated
   */
  EReference getMinus_Left();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.Minus#getRest <em>Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rest</em>'.
   * @see ca.queensu.cs.mase.urml.Minus#getRest()
   * @see #getMinus()
   * @generated
   */
  EReference getMinus_Rest();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.Multiply <em>Multiply</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiply</em>'.
   * @see ca.queensu.cs.mase.urml.Multiply
   * @generated
   */
  EClass getMultiply();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.Multiply#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see ca.queensu.cs.mase.urml.Multiply#getLeft()
   * @see #getMultiply()
   * @generated
   */
  EReference getMultiply_Left();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.Multiply#getRest <em>Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rest</em>'.
   * @see ca.queensu.cs.mase.urml.Multiply#getRest()
   * @see #getMultiply()
   * @generated
   */
  EReference getMultiply_Rest();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.Divide <em>Divide</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Divide</em>'.
   * @see ca.queensu.cs.mase.urml.Divide
   * @generated
   */
  EClass getDivide();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.Divide#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see ca.queensu.cs.mase.urml.Divide#getLeft()
   * @see #getDivide()
   * @generated
   */
  EReference getDivide_Left();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.Divide#getRest <em>Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rest</em>'.
   * @see ca.queensu.cs.mase.urml.Divide#getRest()
   * @see #getDivide()
   * @generated
   */
  EReference getDivide_Rest();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.Modulo <em>Modulo</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Modulo</em>'.
   * @see ca.queensu.cs.mase.urml.Modulo
   * @generated
   */
  EClass getModulo();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.Modulo#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see ca.queensu.cs.mase.urml.Modulo#getLeft()
   * @see #getModulo()
   * @generated
   */
  EReference getModulo_Left();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.Modulo#getRest <em>Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rest</em>'.
   * @see ca.queensu.cs.mase.urml.Modulo#getRest()
   * @see #getModulo()
   * @generated
   */
  EReference getModulo_Rest();

  /**
   * Returns the meta object for class '{@link ca.queensu.cs.mase.urml.UnaryExpression <em>Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Expression</em>'.
   * @see ca.queensu.cs.mase.urml.UnaryExpression
   * @generated
   */
  EClass getUnaryExpression();

  /**
   * Returns the meta object for the containment reference '{@link ca.queensu.cs.mase.urml.UnaryExpression#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp</em>'.
   * @see ca.queensu.cs.mase.urml.UnaryExpression#getExp()
   * @see #getUnaryExpression()
   * @generated
   */
  EReference getUnaryExpression_Exp();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  UrmlFactory getUrmlFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.ModelImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__NAME = eINSTANCE.getModel_Name();

    /**
     * The meta object literal for the '<em><b>Capsules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__CAPSULES = eINSTANCE.getModel_Capsules();

    /**
     * The meta object literal for the '<em><b>Protocols</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__PROTOCOLS = eINSTANCE.getModel_Protocols();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.VarDeclImpl <em>Var Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.VarDeclImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getVarDecl()
     * @generated
     */
    EClass VAR_DECL = eINSTANCE.getVarDecl();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.AttributeImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getAttribute()
     * @generated
     */
    EClass ATTRIBUTE = eINSTANCE.getAttribute();

    /**
     * The meta object literal for the '<em><b>Default Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE__DEFAULT_VALUE = eINSTANCE.getAttribute_DefaultValue();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.ProtocolImpl <em>Protocol</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.ProtocolImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getProtocol()
     * @generated
     */
    EClass PROTOCOL = eINSTANCE.getProtocol();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROTOCOL__NAME = eINSTANCE.getProtocol_Name();

    /**
     * The meta object literal for the '<em><b>Incoming Messages</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROTOCOL__INCOMING_MESSAGES = eINSTANCE.getProtocol_IncomingMessages();

    /**
     * The meta object literal for the '<em><b>Outgoing Messages</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROTOCOL__OUTGOING_MESSAGES = eINSTANCE.getProtocol_OutgoingMessages();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.SignalImpl <em>Signal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.SignalImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getSignal()
     * @generated
     */
    EClass SIGNAL = eINSTANCE.getSignal();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIGNAL__NAME = eINSTANCE.getSignal_Name();

    /**
     * The meta object literal for the '<em><b>Var Decls</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIGNAL__VAR_DECLS = eINSTANCE.getSignal_VarDecls();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.CapsuleImpl <em>Capsule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.CapsuleImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getCapsule()
     * @generated
     */
    EClass CAPSULE = eINSTANCE.getCapsule();

    /**
     * The meta object literal for the '<em><b>Root</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CAPSULE__ROOT = eINSTANCE.getCapsule_Root();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CAPSULE__NAME = eINSTANCE.getCapsule_Name();

    /**
     * The meta object literal for the '<em><b>Interface Ports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAPSULE__INTERFACE_PORTS = eINSTANCE.getCapsule_InterfacePorts();

    /**
     * The meta object literal for the '<em><b>Internal Ports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAPSULE__INTERNAL_PORTS = eINSTANCE.getCapsule_InternalPorts();

    /**
     * The meta object literal for the '<em><b>Timer Ports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAPSULE__TIMER_PORTS = eINSTANCE.getCapsule_TimerPorts();

    /**
     * The meta object literal for the '<em><b>Log Ports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAPSULE__LOG_PORTS = eINSTANCE.getCapsule_LogPorts();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAPSULE__ATTRIBUTES = eINSTANCE.getCapsule_Attributes();

    /**
     * The meta object literal for the '<em><b>Capsule Refs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAPSULE__CAPSULE_REFS = eINSTANCE.getCapsule_CapsuleRefs();

    /**
     * The meta object literal for the '<em><b>Connectors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAPSULE__CONNECTORS = eINSTANCE.getCapsule_Connectors();

    /**
     * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAPSULE__OPERATIONS = eINSTANCE.getCapsule_Operations();

    /**
     * The meta object literal for the '<em><b>Statemachines</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAPSULE__STATEMACHINES = eINSTANCE.getCapsule_Statemachines();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.OperationImpl <em>Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.OperationImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getOperation()
     * @generated
     */
    EClass OPERATION = eINSTANCE.getOperation();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPERATION__NAME = eINSTANCE.getOperation_Name();

    /**
     * The meta object literal for the '<em><b>Var Decls</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION__VAR_DECLS = eINSTANCE.getOperation_VarDecls();

    /**
     * The meta object literal for the '<em><b>Operation Code</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION__OPERATION_CODE = eINSTANCE.getOperation_OperationCode();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.TimerPortImpl <em>Timer Port</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.TimerPortImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getTimerPort()
     * @generated
     */
    EClass TIMER_PORT = eINSTANCE.getTimerPort();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIMER_PORT__NAME = eINSTANCE.getTimerPort_Name();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.LogPortImpl <em>Log Port</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.LogPortImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getLogPort()
     * @generated
     */
    EClass LOG_PORT = eINSTANCE.getLogPort();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOG_PORT__NAME = eINSTANCE.getLogPort_Name();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.PortImpl <em>Port</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.PortImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getPort()
     * @generated
     */
    EClass PORT = eINSTANCE.getPort();

    /**
     * The meta object literal for the '<em><b>Conjugated</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PORT__CONJUGATED = eINSTANCE.getPort_Conjugated();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PORT__NAME = eINSTANCE.getPort_Name();

    /**
     * The meta object literal for the '<em><b>Protocol</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT__PROTOCOL = eINSTANCE.getPort_Protocol();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.ConnectorImpl <em>Connector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.ConnectorImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getConnector()
     * @generated
     */
    EClass CONNECTOR = eINSTANCE.getConnector();

    /**
     * The meta object literal for the '<em><b>Capsule Ref1</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONNECTOR__CAPSULE_REF1 = eINSTANCE.getConnector_CapsuleRef1();

    /**
     * The meta object literal for the '<em><b>Port1</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONNECTOR__PORT1 = eINSTANCE.getConnector_Port1();

    /**
     * The meta object literal for the '<em><b>Capsule Ref2</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONNECTOR__CAPSULE_REF2 = eINSTANCE.getConnector_CapsuleRef2();

    /**
     * The meta object literal for the '<em><b>Port2</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONNECTOR__PORT2 = eINSTANCE.getConnector_Port2();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.CapsuleRefImpl <em>Capsule Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.CapsuleRefImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getCapsuleRef()
     * @generated
     */
    EClass CAPSULE_REF = eINSTANCE.getCapsuleRef();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CAPSULE_REF__NAME = eINSTANCE.getCapsuleRef_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAPSULE_REF__TYPE = eINSTANCE.getCapsuleRef_Type();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.StateMachineImpl <em>State Machine</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.StateMachineImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getStateMachine()
     * @generated
     */
    EClass STATE_MACHINE = eINSTANCE.getStateMachine();

    /**
     * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_MACHINE__STATES = eINSTANCE.getStateMachine_States();

    /**
     * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_MACHINE__TRANSITIONS = eINSTANCE.getStateMachine_Transitions();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.State_Impl <em>State </em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.State_Impl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getState_()
     * @generated
     */
    EClass STATE_ = eINSTANCE.getState_();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE___NAME = eINSTANCE.getState__Name();

    /**
     * The meta object literal for the '<em><b>Entry Code</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE___ENTRY_CODE = eINSTANCE.getState__EntryCode();

    /**
     * The meta object literal for the '<em><b>Exit Code</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE___EXIT_CODE = eINSTANCE.getState__ExitCode();

    /**
     * The meta object literal for the '<em><b>Substatemachine</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE___SUBSTATEMACHINE = eINSTANCE.getState__Substatemachine();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.TransitionImpl <em>Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.TransitionImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getTransition()
     * @generated
     */
    EClass TRANSITION = eINSTANCE.getTransition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSITION__NAME = eINSTANCE.getTransition_Name();

    /**
     * The meta object literal for the '<em><b>Init</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSITION__INIT = eINSTANCE.getTransition_Init();

    /**
     * The meta object literal for the '<em><b>From</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__FROM = eINSTANCE.getTransition_From();

    /**
     * The meta object literal for the '<em><b>To</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__TO = eINSTANCE.getTransition_To();

    /**
     * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__GUARD = eINSTANCE.getTransition_Guard();

    /**
     * The meta object literal for the '<em><b>Triggers</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__TRIGGERS = eINSTANCE.getTransition_Triggers();

    /**
     * The meta object literal for the '<em><b>Timer Port</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__TIMER_PORT = eINSTANCE.getTransition_TimerPort();

    /**
     * The meta object literal for the '<em><b>Action</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__ACTION = eINSTANCE.getTransition_Action();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.Trigger_inImpl <em>Trigger in</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.Trigger_inImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getTrigger_in()
     * @generated
     */
    EClass TRIGGER_IN = eINSTANCE.getTrigger_in();

    /**
     * The meta object literal for the '<em><b>From</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRIGGER_IN__FROM = eINSTANCE.getTrigger_in_From();

    /**
     * The meta object literal for the '<em><b>Signal</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRIGGER_IN__SIGNAL = eINSTANCE.getTrigger_in_Signal();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRIGGER_IN__PARAMETERS = eINSTANCE.getTrigger_in_Parameters();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.IncomingVariableImpl <em>Incoming Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.IncomingVariableImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getIncomingVariable()
     * @generated
     */
    EClass INCOMING_VARIABLE = eINSTANCE.getIncomingVariable();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.Trigger_outImpl <em>Trigger out</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.Trigger_outImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getTrigger_out()
     * @generated
     */
    EClass TRIGGER_OUT = eINSTANCE.getTrigger_out();

    /**
     * The meta object literal for the '<em><b>To</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRIGGER_OUT__TO = eINSTANCE.getTrigger_out_To();

    /**
     * The meta object literal for the '<em><b>Signal</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRIGGER_OUT__SIGNAL = eINSTANCE.getTrigger_out_Signal();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRIGGER_OUT__PARAMETERS = eINSTANCE.getTrigger_out_Parameters();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.OperationCodeImpl <em>Operation Code</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.OperationCodeImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getOperationCode()
     * @generated
     */
    EClass OPERATION_CODE = eINSTANCE.getOperationCode();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_CODE__STATEMENTS = eINSTANCE.getOperationCode_Statements();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.StatementOperationImpl <em>Statement Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.StatementOperationImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getStatementOperation()
     * @generated
     */
    EClass STATEMENT_OPERATION = eINSTANCE.getStatementOperation();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.WhileLoopOperationImpl <em>While Loop Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.WhileLoopOperationImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getWhileLoopOperation()
     * @generated
     */
    EClass WHILE_LOOP_OPERATION = eINSTANCE.getWhileLoopOperation();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHILE_LOOP_OPERATION__CONDITION = eINSTANCE.getWhileLoopOperation_Condition();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHILE_LOOP_OPERATION__STATEMENTS = eINSTANCE.getWhileLoopOperation_Statements();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.IfStatementOperationImpl <em>If Statement Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.IfStatementOperationImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getIfStatementOperation()
     * @generated
     */
    EClass IF_STATEMENT_OPERATION = eINSTANCE.getIfStatementOperation();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT_OPERATION__CONDITION = eINSTANCE.getIfStatementOperation_Condition();

    /**
     * The meta object literal for the '<em><b>Then Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT_OPERATION__THEN_STATEMENTS = eINSTANCE.getIfStatementOperation_ThenStatements();

    /**
     * The meta object literal for the '<em><b>Else Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT_OPERATION__ELSE_STATEMENTS = eINSTANCE.getIfStatementOperation_ElseStatements();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.ReturnStatementImpl <em>Return Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.ReturnStatementImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getReturnStatement()
     * @generated
     */
    EClass RETURN_STATEMENT = eINSTANCE.getReturnStatement();

    /**
     * The meta object literal for the '<em><b>Return Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RETURN_STATEMENT__RETURN_VALUE = eINSTANCE.getReturnStatement_ReturnValue();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.ActionCodeImpl <em>Action Code</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.ActionCodeImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getActionCode()
     * @generated
     */
    EClass ACTION_CODE = eINSTANCE.getActionCode();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTION_CODE__STATEMENTS = eINSTANCE.getActionCode_Statements();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.StatementImpl <em>Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.StatementImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getStatement()
     * @generated
     */
    EClass STATEMENT = eINSTANCE.getStatement();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.VariableImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getVariable()
     * @generated
     */
    EClass VARIABLE = eINSTANCE.getVariable();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE__VAR = eINSTANCE.getVariable_Var();

    /**
     * The meta object literal for the '<em><b>Assign</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE__ASSIGN = eINSTANCE.getVariable_Assign();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE__EXP = eINSTANCE.getVariable_Exp();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.SendTriggerImpl <em>Send Trigger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.SendTriggerImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getSendTrigger()
     * @generated
     */
    EClass SEND_TRIGGER = eINSTANCE.getSendTrigger();

    /**
     * The meta object literal for the '<em><b>Triggers</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEND_TRIGGER__TRIGGERS = eINSTANCE.getSendTrigger_Triggers();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.InformTimerImpl <em>Inform Timer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.InformTimerImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getInformTimer()
     * @generated
     */
    EClass INFORM_TIMER = eINSTANCE.getInformTimer();

    /**
     * The meta object literal for the '<em><b>Timer Port</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INFORM_TIMER__TIMER_PORT = eINSTANCE.getInformTimer_TimerPort();

    /**
     * The meta object literal for the '<em><b>Time</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INFORM_TIMER__TIME = eINSTANCE.getInformTimer_Time();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.NoOpImpl <em>No Op</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.NoOpImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getNoOp()
     * @generated
     */
    EClass NO_OP = eINSTANCE.getNoOp();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.InvokeImpl <em>Invoke</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.InvokeImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getInvoke()
     * @generated
     */
    EClass INVOKE = eINSTANCE.getInvoke();

    /**
     * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVOKE__OPERATION = eINSTANCE.getInvoke_Operation();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVOKE__PARAMETERS = eINSTANCE.getInvoke_Parameters();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.AssignmentImpl <em>Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.AssignmentImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getAssignment()
     * @generated
     */
    EClass ASSIGNMENT = eINSTANCE.getAssignment();

    /**
     * The meta object literal for the '<em><b>Lvalue</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT__LVALUE = eINSTANCE.getAssignment_Lvalue();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT__EXP = eINSTANCE.getAssignment_Exp();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.AssignableImpl <em>Assignable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.AssignableImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getAssignable()
     * @generated
     */
    EClass ASSIGNABLE = eINSTANCE.getAssignable();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGNABLE__NAME = eINSTANCE.getAssignable_Name();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.WhileLoopImpl <em>While Loop</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.WhileLoopImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getWhileLoop()
     * @generated
     */
    EClass WHILE_LOOP = eINSTANCE.getWhileLoop();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHILE_LOOP__CONDITION = eINSTANCE.getWhileLoop_Condition();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHILE_LOOP__STATEMENTS = eINSTANCE.getWhileLoop_Statements();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.IfStatementImpl <em>If Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.IfStatementImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getIfStatement()
     * @generated
     */
    EClass IF_STATEMENT = eINSTANCE.getIfStatement();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__CONDITION = eINSTANCE.getIfStatement_Condition();

    /**
     * The meta object literal for the '<em><b>Then Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__THEN_STATEMENTS = eINSTANCE.getIfStatement_ThenStatements();

    /**
     * The meta object literal for the '<em><b>Else Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__ELSE_STATEMENTS = eINSTANCE.getIfStatement_ElseStatements();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.LogStatementImpl <em>Log Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.LogStatementImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getLogStatement()
     * @generated
     */
    EClass LOG_STATEMENT = eINSTANCE.getLogStatement();

    /**
     * The meta object literal for the '<em><b>Log Port</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOG_STATEMENT__LOG_PORT = eINSTANCE.getLogStatement_LogPort();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOG_STATEMENT__LEFT = eINSTANCE.getLogStatement_Left();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.StringExpressionImpl <em>String Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.StringExpressionImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getStringExpression()
     * @generated
     */
    EClass STRING_EXPRESSION = eINSTANCE.getStringExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRING_EXPRESSION__EXPR = eINSTANCE.getStringExpression_Expr();

    /**
     * The meta object literal for the '<em><b>Str</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_EXPRESSION__STR = eINSTANCE.getStringExpression_Str();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.ExpressionImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.NotBooleanExpressionImpl <em>Not Boolean Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.NotBooleanExpressionImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getNotBooleanExpression()
     * @generated
     */
    EClass NOT_BOOLEAN_EXPRESSION = eINSTANCE.getNotBooleanExpression();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NOT_BOOLEAN_EXPRESSION__EXP = eINSTANCE.getNotBooleanExpression_Exp();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.LiteralImpl <em>Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.LiteralImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getLiteral()
     * @generated
     */
    EClass LITERAL = eINSTANCE.getLiteral();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.IntLiteralImpl <em>Int Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.IntLiteralImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getIntLiteral()
     * @generated
     */
    EClass INT_LITERAL = eINSTANCE.getIntLiteral();

    /**
     * The meta object literal for the '<em><b>Int</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INT_LITERAL__INT = eINSTANCE.getIntLiteral_Int();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.IdentifierImpl <em>Identifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.IdentifierImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getIdentifier()
     * @generated
     */
    EClass IDENTIFIER = eINSTANCE.getIdentifier();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IDENTIFIER__ID = eINSTANCE.getIdentifier_Id();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.FunctionCallImpl <em>Function Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.FunctionCallImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getFunctionCall()
     * @generated
     */
    EClass FUNCTION_CALL = eINSTANCE.getFunctionCall();

    /**
     * The meta object literal for the '<em><b>Call</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_CALL__CALL = eINSTANCE.getFunctionCall_Call();

    /**
     * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_CALL__PARAMS = eINSTANCE.getFunctionCall_Params();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.BoolLiteralImpl <em>Bool Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.BoolLiteralImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getBoolLiteral()
     * @generated
     */
    EClass BOOL_LITERAL = eINSTANCE.getBoolLiteral();

    /**
     * The meta object literal for the '<em><b>True</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOL_LITERAL__TRUE = eINSTANCE.getBoolLiteral_True();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.ConcatenateExpressionImpl <em>Concatenate Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.ConcatenateExpressionImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getConcatenateExpression()
     * @generated
     */
    EClass CONCATENATE_EXPRESSION = eINSTANCE.getConcatenateExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONCATENATE_EXPRESSION__LEFT = eINSTANCE.getConcatenateExpression_Left();

    /**
     * The meta object literal for the '<em><b>Rest</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONCATENATE_EXPRESSION__REST = eINSTANCE.getConcatenateExpression_Rest();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.ConditionalOrExpressionImpl <em>Conditional Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.ConditionalOrExpressionImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getConditionalOrExpression()
     * @generated
     */
    EClass CONDITIONAL_OR_EXPRESSION = eINSTANCE.getConditionalOrExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_OR_EXPRESSION__LEFT = eINSTANCE.getConditionalOrExpression_Left();

    /**
     * The meta object literal for the '<em><b>Rest</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_OR_EXPRESSION__REST = eINSTANCE.getConditionalOrExpression_Rest();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.ConditionalAndExpressionImpl <em>Conditional And Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.ConditionalAndExpressionImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getConditionalAndExpression()
     * @generated
     */
    EClass CONDITIONAL_AND_EXPRESSION = eINSTANCE.getConditionalAndExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_AND_EXPRESSION__LEFT = eINSTANCE.getConditionalAndExpression_Left();

    /**
     * The meta object literal for the '<em><b>Rest</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_AND_EXPRESSION__REST = eINSTANCE.getConditionalAndExpression_Rest();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.LessThanOrEqualImpl <em>Less Than Or Equal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.LessThanOrEqualImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getLessThanOrEqual()
     * @generated
     */
    EClass LESS_THAN_OR_EQUAL = eINSTANCE.getLessThanOrEqual();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LESS_THAN_OR_EQUAL__LEFT = eINSTANCE.getLessThanOrEqual_Left();

    /**
     * The meta object literal for the '<em><b>Rest</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LESS_THAN_OR_EQUAL__REST = eINSTANCE.getLessThanOrEqual_Rest();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.LessThanImpl <em>Less Than</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.LessThanImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getLessThan()
     * @generated
     */
    EClass LESS_THAN = eINSTANCE.getLessThan();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LESS_THAN__LEFT = eINSTANCE.getLessThan_Left();

    /**
     * The meta object literal for the '<em><b>Rest</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LESS_THAN__REST = eINSTANCE.getLessThan_Rest();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.GreaterThanOrEqualImpl <em>Greater Than Or Equal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.GreaterThanOrEqualImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getGreaterThanOrEqual()
     * @generated
     */
    EClass GREATER_THAN_OR_EQUAL = eINSTANCE.getGreaterThanOrEqual();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GREATER_THAN_OR_EQUAL__LEFT = eINSTANCE.getGreaterThanOrEqual_Left();

    /**
     * The meta object literal for the '<em><b>Rest</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GREATER_THAN_OR_EQUAL__REST = eINSTANCE.getGreaterThanOrEqual_Rest();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.GreaterThanImpl <em>Greater Than</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.GreaterThanImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getGreaterThan()
     * @generated
     */
    EClass GREATER_THAN = eINSTANCE.getGreaterThan();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GREATER_THAN__LEFT = eINSTANCE.getGreaterThan_Left();

    /**
     * The meta object literal for the '<em><b>Rest</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GREATER_THAN__REST = eINSTANCE.getGreaterThan_Rest();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.EqualImpl <em>Equal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.EqualImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getEqual()
     * @generated
     */
    EClass EQUAL = eINSTANCE.getEqual();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUAL__LEFT = eINSTANCE.getEqual_Left();

    /**
     * The meta object literal for the '<em><b>Rest</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUAL__REST = eINSTANCE.getEqual_Rest();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.NotEqualImpl <em>Not Equal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.NotEqualImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getNotEqual()
     * @generated
     */
    EClass NOT_EQUAL = eINSTANCE.getNotEqual();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NOT_EQUAL__LEFT = eINSTANCE.getNotEqual_Left();

    /**
     * The meta object literal for the '<em><b>Rest</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NOT_EQUAL__REST = eINSTANCE.getNotEqual_Rest();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.PlusImpl <em>Plus</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.PlusImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getPlus()
     * @generated
     */
    EClass PLUS = eINSTANCE.getPlus();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PLUS__LEFT = eINSTANCE.getPlus_Left();

    /**
     * The meta object literal for the '<em><b>Rest</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PLUS__REST = eINSTANCE.getPlus_Rest();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.MinusImpl <em>Minus</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.MinusImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getMinus()
     * @generated
     */
    EClass MINUS = eINSTANCE.getMinus();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MINUS__LEFT = eINSTANCE.getMinus_Left();

    /**
     * The meta object literal for the '<em><b>Rest</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MINUS__REST = eINSTANCE.getMinus_Rest();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.MultiplyImpl <em>Multiply</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.MultiplyImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getMultiply()
     * @generated
     */
    EClass MULTIPLY = eINSTANCE.getMultiply();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLY__LEFT = eINSTANCE.getMultiply_Left();

    /**
     * The meta object literal for the '<em><b>Rest</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLY__REST = eINSTANCE.getMultiply_Rest();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.DivideImpl <em>Divide</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.DivideImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getDivide()
     * @generated
     */
    EClass DIVIDE = eINSTANCE.getDivide();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DIVIDE__LEFT = eINSTANCE.getDivide_Left();

    /**
     * The meta object literal for the '<em><b>Rest</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DIVIDE__REST = eINSTANCE.getDivide_Rest();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.ModuloImpl <em>Modulo</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.ModuloImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getModulo()
     * @generated
     */
    EClass MODULO = eINSTANCE.getModulo();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULO__LEFT = eINSTANCE.getModulo_Left();

    /**
     * The meta object literal for the '<em><b>Rest</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULO__REST = eINSTANCE.getModulo_Rest();

    /**
     * The meta object literal for the '{@link ca.queensu.cs.mase.urml.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.queensu.cs.mase.urml.impl.UnaryExpressionImpl
     * @see ca.queensu.cs.mase.urml.impl.UrmlPackageImpl#getUnaryExpression()
     * @generated
     */
    EClass UNARY_EXPRESSION = eINSTANCE.getUnaryExpression();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_EXPRESSION__EXP = eINSTANCE.getUnaryExpression_Exp();

  }

} //UrmlPackage
