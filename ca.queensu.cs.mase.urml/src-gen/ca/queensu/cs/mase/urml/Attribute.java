/**
 */
package ca.queensu.cs.mase.urml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.Attribute#getDefaultValue <em>Default Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.queensu.cs.mase.urml.UrmlPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends Assignable
{
  /**
   * Returns the value of the '<em><b>Default Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default Value</em>' containment reference.
   * @see #setDefaultValue(Expression)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getAttribute_DefaultValue()
   * @model containment="true"
   * @generated
   */
  Expression getDefaultValue();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Attribute#getDefaultValue <em>Default Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default Value</em>' containment reference.
   * @see #getDefaultValue()
   * @generated
   */
  void setDefaultValue(Expression value);

} // Attribute
