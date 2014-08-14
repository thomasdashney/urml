/**
 */
package ca.queensu.cs.mase.urml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.Port#isConjugated <em>Conjugated</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Port#getName <em>Name</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Port#getProtocol <em>Protocol</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.queensu.cs.mase.urml.UrmlPackage#getPort()
 * @model
 * @generated
 */
public interface Port extends EObject
{
  /**
   * Returns the value of the '<em><b>Conjugated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Conjugated</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Conjugated</em>' attribute.
   * @see #setConjugated(boolean)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getPort_Conjugated()
   * @model
   * @generated
   */
  boolean isConjugated();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Port#isConjugated <em>Conjugated</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Conjugated</em>' attribute.
   * @see #isConjugated()
   * @generated
   */
  void setConjugated(boolean value);

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
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getPort_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Port#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Protocol</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Protocol</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Protocol</em>' reference.
   * @see #setProtocol(Protocol)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getPort_Protocol()
   * @model
   * @generated
   */
  Protocol getProtocol();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Port#getProtocol <em>Protocol</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Protocol</em>' reference.
   * @see #getProtocol()
   * @generated
   */
  void setProtocol(Protocol value);

} // Port
