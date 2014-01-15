/**
 */
package ca.queensu.cs.mase.urml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.State_#isFinal <em>Final</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.State_#getName <em>Name</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.State_#getEntryCode <em>Entry Code</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.State_#getExitCode <em>Exit Code</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.State_#getSubstatemachine <em>Substatemachine</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.queensu.cs.mase.urml.UrmlPackage#getState_()
 * @model
 * @generated
 */
public interface State_ extends EObject
{
  /**
   * Returns the value of the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Final</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Final</em>' attribute.
   * @see #setFinal(boolean)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getState__Final()
   * @model
   * @generated
   */
  boolean isFinal();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.State_#isFinal <em>Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Final</em>' attribute.
   * @see #isFinal()
   * @generated
   */
  void setFinal(boolean value);

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
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getState__Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.State_#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Entry Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Entry Code</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Entry Code</em>' containment reference.
   * @see #setEntryCode(ActionCode)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getState__EntryCode()
   * @model containment="true"
   * @generated
   */
  ActionCode getEntryCode();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.State_#getEntryCode <em>Entry Code</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Entry Code</em>' containment reference.
   * @see #getEntryCode()
   * @generated
   */
  void setEntryCode(ActionCode value);

  /**
   * Returns the value of the '<em><b>Exit Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exit Code</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exit Code</em>' containment reference.
   * @see #setExitCode(ActionCode)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getState__ExitCode()
   * @model containment="true"
   * @generated
   */
  ActionCode getExitCode();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.State_#getExitCode <em>Exit Code</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exit Code</em>' containment reference.
   * @see #getExitCode()
   * @generated
   */
  void setExitCode(ActionCode value);

  /**
   * Returns the value of the '<em><b>Substatemachine</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Substatemachine</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Substatemachine</em>' containment reference.
   * @see #setSubstatemachine(StateMachine)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getState__Substatemachine()
   * @model containment="true"
   * @generated
   */
  StateMachine getSubstatemachine();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.State_#getSubstatemachine <em>Substatemachine</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Substatemachine</em>' containment reference.
   * @see #getSubstatemachine()
   * @generated
   */
  void setSubstatemachine(StateMachine value);

} // State_
