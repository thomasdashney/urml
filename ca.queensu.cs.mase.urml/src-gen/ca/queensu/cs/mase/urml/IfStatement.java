/**
 */
package ca.queensu.cs.mase.urml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.IfStatement#getCondition <em>Condition</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.IfStatement#getThenStatements <em>Then Statements</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.IfStatement#getElseStatements <em>Else Statements</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.queensu.cs.mase.urml.UrmlPackage#getIfStatement()
 * @model
 * @generated
 */
public interface IfStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(Expression)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getIfStatement_Condition()
   * @model containment="true"
   * @generated
   */
  Expression getCondition();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.IfStatement#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(Expression value);

  /**
   * Returns the value of the '<em><b>Then Statements</b></em>' containment reference list.
   * The list contents are of type {@link ca.queensu.cs.mase.urml.Statement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Then Statements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then Statements</em>' containment reference list.
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getIfStatement_ThenStatements()
   * @model containment="true"
   * @generated
   */
  EList<Statement> getThenStatements();

  /**
   * Returns the value of the '<em><b>Else Statements</b></em>' containment reference list.
   * The list contents are of type {@link ca.queensu.cs.mase.urml.Statement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Else Statements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else Statements</em>' containment reference list.
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getIfStatement_ElseStatements()
   * @model containment="true"
   * @generated
   */
  EList<Statement> getElseStatements();

} // IfStatement
