/**
 */
package ca.queensu.cs.mase.urml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Less Than Or Equal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.LessThanOrEqual#getLeft <em>Left</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.LessThanOrEqual#getRest <em>Rest</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.queensu.cs.mase.urml.UrmlPackage#getLessThanOrEqual()
 * @model
 * @generated
 */
public interface LessThanOrEqual extends Expression
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Expression)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getLessThanOrEqual_Left()
   * @model containment="true"
   * @generated
   */
  Expression getLeft();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.LessThanOrEqual#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Expression value);

  /**
   * Returns the value of the '<em><b>Rest</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rest</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rest</em>' containment reference.
   * @see #setRest(Expression)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getLessThanOrEqual_Rest()
   * @model containment="true"
   * @generated
   */
  Expression getRest();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.LessThanOrEqual#getRest <em>Rest</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rest</em>' containment reference.
   * @see #getRest()
   * @generated
   */
  void setRest(Expression value);

} // LessThanOrEqual
