/**
 */
package ca.queensu.cs.mase.urml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concatenate Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.ConcatenateExpression#getLeft <em>Left</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.ConcatenateExpression#getRest <em>Rest</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.queensu.cs.mase.urml.UrmlPackage#getConcatenateExpression()
 * @model
 * @generated
 */
public interface ConcatenateExpression extends StringExpression
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
   * @see #setLeft(StringExpression)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getConcatenateExpression_Left()
   * @model containment="true"
   * @generated
   */
  StringExpression getLeft();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.ConcatenateExpression#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(StringExpression value);

  /**
   * Returns the value of the '<em><b>Rest</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rest</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rest</em>' containment reference.
   * @see #setRest(StringExpression)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getConcatenateExpression_Rest()
   * @model containment="true"
   * @generated
   */
  StringExpression getRest();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.ConcatenateExpression#getRest <em>Rest</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rest</em>' containment reference.
   * @see #getRest()
   * @generated
   */
  void setRest(StringExpression value);

} // ConcatenateExpression
