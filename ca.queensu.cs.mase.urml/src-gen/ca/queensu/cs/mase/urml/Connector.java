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
 *   <li>{@link ca.queensu.cs.mase.urml.Connector#getCapsuleRef1 <em>Capsule Ref1</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Connector#getPort1 <em>Port1</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Connector#getCapsuleRef2 <em>Capsule Ref2</em>}</li>
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
   * Returns the value of the '<em><b>Capsule Ref1</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Capsule Ref1</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Capsule Ref1</em>' reference.
   * @see #setCapsuleRef1(CapsuleRef)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getConnector_CapsuleRef1()
   * @model
   * @generated
   */
  CapsuleRef getCapsuleRef1();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Connector#getCapsuleRef1 <em>Capsule Ref1</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Capsule Ref1</em>' reference.
   * @see #getCapsuleRef1()
   * @generated
   */
  void setCapsuleRef1(CapsuleRef value);

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
   * Returns the value of the '<em><b>Capsule Ref2</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Capsule Ref2</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Capsule Ref2</em>' reference.
   * @see #setCapsuleRef2(CapsuleRef)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getConnector_CapsuleRef2()
   * @model
   * @generated
   */
  CapsuleRef getCapsuleRef2();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Connector#getCapsuleRef2 <em>Capsule Ref2</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Capsule Ref2</em>' reference.
   * @see #getCapsuleRef2()
   * @generated
   */
  void setCapsuleRef2(CapsuleRef value);

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
