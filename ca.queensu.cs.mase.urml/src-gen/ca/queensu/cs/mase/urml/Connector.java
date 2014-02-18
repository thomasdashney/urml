/**
 */
package ca.queensu.cs.mase.urml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.Connector#getCapsuleInst1 <em>Capsule Inst1</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Connector#getPort1 <em>Port1</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Connector#getCapsuleInst2 <em>Capsule Inst2</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Connector#getPort2 <em>Port2</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.queensu.cs.mase.urml.UrmlPackage#getConnector()
 * @model
 * @generated
 */
public interface Connector extends EObject
{
  /**
   * Returns the value of the '<em><b>Capsule Inst1</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Capsule Inst1</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Capsule Inst1</em>' reference.
   * @see #setCapsuleInst1(CapsuleInst)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getConnector_CapsuleInst1()
   * @model
   * @generated
   */
  CapsuleInst getCapsuleInst1();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Connector#getCapsuleInst1 <em>Capsule Inst1</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Capsule Inst1</em>' reference.
   * @see #getCapsuleInst1()
   * @generated
   */
  void setCapsuleInst1(CapsuleInst value);

  /**
   * Returns the value of the '<em><b>Port1</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Port1</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Port1</em>' reference.
   * @see #setPort1(Port)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getConnector_Port1()
   * @model
   * @generated
   */
  Port getPort1();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Connector#getPort1 <em>Port1</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Port1</em>' reference.
   * @see #getPort1()
   * @generated
   */
  void setPort1(Port value);

  /**
   * Returns the value of the '<em><b>Capsule Inst2</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Capsule Inst2</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Capsule Inst2</em>' reference.
   * @see #setCapsuleInst2(CapsuleInst)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getConnector_CapsuleInst2()
   * @model
   * @generated
   */
  CapsuleInst getCapsuleInst2();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Connector#getCapsuleInst2 <em>Capsule Inst2</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Capsule Inst2</em>' reference.
   * @see #getCapsuleInst2()
   * @generated
   */
  void setCapsuleInst2(CapsuleInst value);

  /**
   * Returns the value of the '<em><b>Port2</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Port2</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Port2</em>' reference.
   * @see #setPort2(Port)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getConnector_Port2()
   * @model
   * @generated
   */
  Port getPort2();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Connector#getPort2 <em>Port2</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Port2</em>' reference.
   * @see #getPort2()
   * @generated
   */
  void setPort2(Port value);

} // Connector
