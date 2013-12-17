/**
 */
package ca.queensu.cs.mase.urml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protocol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.Protocol#getName <em>Name</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Protocol#getIncomingMessages <em>Incoming Messages</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Protocol#getOutgoingMessages <em>Outgoing Messages</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.queensu.cs.mase.urml.UrmlPackage#getProtocol()
 * @model
 * @generated
 */
public interface Protocol extends EObject
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
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getProtocol_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Protocol#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Incoming Messages</b></em>' containment reference list.
   * The list contents are of type {@link ca.queensu.cs.mase.urml.Signal}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Incoming Messages</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Incoming Messages</em>' containment reference list.
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getProtocol_IncomingMessages()
   * @model containment="true"
   * @generated
   */
  EList<Signal> getIncomingMessages();

  /**
   * Returns the value of the '<em><b>Outgoing Messages</b></em>' containment reference list.
   * The list contents are of type {@link ca.queensu.cs.mase.urml.Signal}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Outgoing Messages</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outgoing Messages</em>' containment reference list.
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getProtocol_OutgoingMessages()
   * @model containment="true"
   * @generated
   */
  EList<Signal> getOutgoingMessages();

} // Protocol
