/**
 */
package ca.queensu.cs.mase.urml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.Assignment#getLvalue <em>Lvalue</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Assignment#getExp <em>Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.queensu.cs.mase.urml.UrmlPackage#getAssignment()
 * @model
 * @generated
 */
public interface Assignment extends StatementOperation, Statement
{
  /**
   * Returns the value of the '<em><b>Lvalue</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lvalue</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lvalue</em>' reference.
   * @see #setLvalue(Assignable)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getAssignment_Lvalue()
   * @model
   * @generated
   */
  Assignable getLvalue();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Assignment#getLvalue <em>Lvalue</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lvalue</em>' reference.
   * @see #getLvalue()
   * @generated
   */
  void setLvalue(Assignable value);

  /**
   * Returns the value of the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exp</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exp</em>' containment reference.
   * @see #setExp(Expression)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getAssignment_Exp()
   * @model containment="true"
   * @generated
   */
  Expression getExp();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Assignment#getExp <em>Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exp</em>' containment reference.
   * @see #getExp()
   * @generated
   */
  void setExp(Expression value);

} // Assignment
