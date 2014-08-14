/**
 */
package ca.queensu.cs.mase.urml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identifiable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.Identifiable#isIsBool <em>Is Bool</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Identifiable#isIsInt <em>Is Int</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Identifiable#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.queensu.cs.mase.urml.UrmlPackage#getIdentifiable()
 * @model
 * @generated
 */
public interface Identifiable extends EObject
{
  /**
   * Returns the value of the '<em><b>Is Bool</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Bool</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Bool</em>' attribute.
   * @see #setIsBool(boolean)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getIdentifiable_IsBool()
   * @model
   * @generated
   */
  boolean isIsBool();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Identifiable#isIsBool <em>Is Bool</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Bool</em>' attribute.
   * @see #isIsBool()
   * @generated
   */
  void setIsBool(boolean value);

  /**
   * Returns the value of the '<em><b>Is Int</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Int</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Int</em>' attribute.
   * @see #setIsInt(boolean)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getIdentifiable_IsInt()
   * @model
   * @generated
   */
  boolean isIsInt();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Identifiable#isIsInt <em>Is Int</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Int</em>' attribute.
   * @see #isIsInt()
   * @generated
   */
  void setIsInt(boolean value);

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
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getIdentifiable_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Identifiable#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // Identifiable
