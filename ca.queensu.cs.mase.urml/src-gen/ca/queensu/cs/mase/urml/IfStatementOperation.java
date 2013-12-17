/**
 */
package ca.queensu.cs.mase.urml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Statement Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.IfStatementOperation#getCondition <em>Condition</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.IfStatementOperation#getThenStatements <em>Then Statements</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.IfStatementOperation#getElseStatements <em>Else Statements</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.queensu.cs.mase.urml.UrmlPackage#getIfStatementOperation()
 * @model
 * @generated
 */
public interface IfStatementOperation extends StatementOperation
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
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getIfStatementOperation_Condition()
   * @model containment="true"
   * @generated
   */
  Expression getCondition();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.IfStatementOperation#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(Expression value);

  /**
   * Returns the value of the '<em><b>Then Statements</b></em>' containment reference list.
   * The list contents are of type {@link ca.queensu.cs.mase.urml.StatementOperation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Then Statements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then Statements</em>' containment reference list.
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getIfStatementOperation_ThenStatements()
   * @model containment="true"
   * @generated
   */
  EList<StatementOperation> getThenStatements();

  /**
   * Returns the value of the '<em><b>Else Statements</b></em>' containment reference list.
   * The list contents are of type {@link ca.queensu.cs.mase.urml.StatementOperation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Else Statements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else Statements</em>' containment reference list.
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getIfStatementOperation_ElseStatements()
   * @model containment="true"
   * @generated
   */
  EList<StatementOperation> getElseStatements();

} // IfStatementOperation
