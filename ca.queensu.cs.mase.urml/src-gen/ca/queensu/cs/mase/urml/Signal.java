/**
 */
package ca.queensu.cs.mase.urml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Signal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.Signal#getName <em>Name</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Signal#getLocalVars <em>Local Vars</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.queensu.cs.mase.urml.UrmlPackage#getSignal()
 * @model
 * @generated
 */
public interface Signal extends EObject
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
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getSignal_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Signal#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Local Vars</b></em>' containment reference list.
   * The list contents are of type {@link ca.queensu.cs.mase.urml.LocalVar}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Local Vars</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Local Vars</em>' containment reference list.
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getSignal_LocalVars()
   * @model containment="true"
   * @generated
   */
  EList<LocalVar> getLocalVars();

} // Signal
