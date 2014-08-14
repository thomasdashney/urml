/**
 */
package ca.queensu.cs.mase.urml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.Transition#getName <em>Name</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Transition#isInit <em>Init</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Transition#getFrom <em>From</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Transition#getTo <em>To</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Transition#getGuard <em>Guard</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Transition#getTriggers <em>Triggers</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Transition#getTimerPort <em>Timer Port</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Transition#isUniversal <em>Universal</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Transition#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.queensu.cs.mase.urml.UrmlPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends EObject
{
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
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getTransition_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Transition#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Init</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Init</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Init</em>' attribute.
   * @see #setInit(boolean)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getTransition_Init()
   * @model
   * @generated
   */
  boolean isInit();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Transition#isInit <em>Init</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Init</em>' attribute.
   * @see #isInit()
   * @generated
   */
  void setInit(boolean value);

  /**
   * Returns the value of the '<em><b>From</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>From</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>From</em>' reference.
   * @see #setFrom(State_)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getTransition_From()
   * @model
   * @generated
   */
  State_ getFrom();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Transition#getFrom <em>From</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>From</em>' reference.
   * @see #getFrom()
   * @generated
   */
  void setFrom(State_ value);

  /**
   * Returns the value of the '<em><b>To</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>To</em>' reference.
   * @see #setTo(State_)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getTransition_To()
   * @model
   * @generated
   */
  State_ getTo();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Transition#getTo <em>To</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To</em>' reference.
   * @see #getTo()
   * @generated
   */
  void setTo(State_ value);

  /**
   * Returns the value of the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Guard</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Guard</em>' containment reference.
   * @see #setGuard(Expression)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getTransition_Guard()
   * @model containment="true"
   * @generated
   */
  Expression getGuard();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Transition#getGuard <em>Guard</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Guard</em>' containment reference.
   * @see #getGuard()
   * @generated
   */
  void setGuard(Expression value);

  /**
   * Returns the value of the '<em><b>Triggers</b></em>' containment reference list.
   * The list contents are of type {@link ca.queensu.cs.mase.urml.Trigger_in}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Triggers</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Triggers</em>' containment reference list.
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getTransition_Triggers()
   * @model containment="true"
   * @generated
   */
  EList<Trigger_in> getTriggers();

  /**
   * Returns the value of the '<em><b>Timer Port</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Timer Port</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Timer Port</em>' reference.
   * @see #setTimerPort(TimerPort)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getTransition_TimerPort()
   * @model
   * @generated
   */
  TimerPort getTimerPort();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Transition#getTimerPort <em>Timer Port</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Timer Port</em>' reference.
   * @see #getTimerPort()
   * @generated
   */
  void setTimerPort(TimerPort value);

  /**
   * Returns the value of the '<em><b>Universal</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Universal</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Universal</em>' attribute.
   * @see #setUniversal(boolean)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getTransition_Universal()
   * @model
   * @generated
   */
  boolean isUniversal();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Transition#isUniversal <em>Universal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Universal</em>' attribute.
   * @see #isUniversal()
   * @generated
   */
  void setUniversal(boolean value);

  /**
   * Returns the value of the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Action</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Action</em>' containment reference.
   * @see #setAction(ActionCode)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getTransition_Action()
   * @model containment="true"
   * @generated
   */
  ActionCode getAction();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Transition#getAction <em>Action</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Action</em>' containment reference.
   * @see #getAction()
   * @generated
   */
  void setAction(ActionCode value);

} // Transition
