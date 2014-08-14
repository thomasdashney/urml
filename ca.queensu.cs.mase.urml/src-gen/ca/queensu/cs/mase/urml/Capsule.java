/**
 */
package ca.queensu.cs.mase.urml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Capsule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.Capsule#isRoot <em>Root</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Capsule#getName <em>Name</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Capsule#getInterfacePorts <em>Interface Ports</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Capsule#getInternalPorts <em>Internal Ports</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Capsule#getTimerPorts <em>Timer Ports</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Capsule#getLogPorts <em>Log Ports</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Capsule#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Capsule#getCapsuleInsts <em>Capsule Insts</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Capsule#getConnectors <em>Connectors</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Capsule#getOperations <em>Operations</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Capsule#getStatemachines <em>Statemachines</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.queensu.cs.mase.urml.UrmlPackage#getCapsule()
 * @model
 * @generated
 */
public interface Capsule extends EObject
{
  /**
   * Returns the value of the '<em><b>Root</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Root</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Root</em>' attribute.
   * @see #setRoot(boolean)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getCapsule_Root()
   * @model
   * @generated
   */
  boolean isRoot();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Capsule#isRoot <em>Root</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Root</em>' attribute.
   * @see #isRoot()
   * @generated
   */
  void setRoot(boolean value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getCapsule_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Capsule#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Interface Ports</b></em>' containment reference list.
   * The list contents are of type {@link ca.queensu.cs.mase.urml.Port}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Interface Ports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Interface Ports</em>' containment reference list.
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getCapsule_InterfacePorts()
   * @model containment="true"
   * @generated
   */
  EList<Port> getInterfacePorts();

  /**
   * Returns the value of the '<em><b>Internal Ports</b></em>' containment reference list.
   * The list contents are of type {@link ca.queensu.cs.mase.urml.Port}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Internal Ports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Internal Ports</em>' containment reference list.
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getCapsule_InternalPorts()
   * @model containment="true"
   * @generated
   */
  EList<Port> getInternalPorts();

  /**
   * Returns the value of the '<em><b>Timer Ports</b></em>' containment reference list.
   * The list contents are of type {@link ca.queensu.cs.mase.urml.TimerPort}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Timer Ports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Timer Ports</em>' containment reference list.
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getCapsule_TimerPorts()
   * @model containment="true"
   * @generated
   */
  EList<TimerPort> getTimerPorts();

  /**
   * Returns the value of the '<em><b>Log Ports</b></em>' containment reference list.
   * The list contents are of type {@link ca.queensu.cs.mase.urml.LogPort}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Log Ports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Log Ports</em>' containment reference list.
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getCapsule_LogPorts()
   * @model containment="true"
   * @generated
   */
  EList<LogPort> getLogPorts();

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link ca.queensu.cs.mase.urml.Attribute}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getCapsule_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<Attribute> getAttributes();

  /**
   * Returns the value of the '<em><b>Capsule Insts</b></em>' containment reference list.
   * The list contents are of type {@link ca.queensu.cs.mase.urml.CapsuleInst}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Capsule Insts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Capsule Insts</em>' containment reference list.
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getCapsule_CapsuleInsts()
   * @model containment="true"
   * @generated
   */
  EList<CapsuleInst> getCapsuleInsts();

  /**
   * Returns the value of the '<em><b>Connectors</b></em>' containment reference list.
   * The list contents are of type {@link ca.queensu.cs.mase.urml.Connector}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Connectors</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Connectors</em>' containment reference list.
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getCapsule_Connectors()
   * @model containment="true"
   * @generated
   */
  EList<Connector> getConnectors();

  /**
   * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
   * The list contents are of type {@link ca.queensu.cs.mase.urml.Operation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operations</em>' containment reference list.
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getCapsule_Operations()
   * @model containment="true"
   * @generated
   */
  EList<Operation> getOperations();

  /**
   * Returns the value of the '<em><b>Statemachines</b></em>' containment reference list.
   * The list contents are of type {@link ca.queensu.cs.mase.urml.StateMachine}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statemachines</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statemachines</em>' containment reference list.
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getCapsule_Statemachines()
   * @model containment="true"
   * @generated
   */
  EList<StateMachine> getStatemachines();

} // Capsule
