/**
 */
package ca.queensu.cs.mase.urml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>While Loop Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.WhileLoopOperation#getCondition <em>Condition</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.WhileLoopOperation#getStatements <em>Statements</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.queensu.cs.mase.urml.UrmlPackage#getWhileLoopOperation()
 * @model
 * @generated
 */
public interface WhileLoopOperation extends StatementOperation
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
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getWhileLoopOperation_Condition()
   * @model containment="true"
   * @generated
   */
  Expression getCondition();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.WhileLoopOperation#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(Expression value);

  /**
   * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
   * The list contents are of type {@link ca.queensu.cs.mase.urml.StatementOperation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statements</em>' containment reference list.
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getWhileLoopOperation_Statements()
   * @model containment="true"
   * @generated
   */
  EList<StatementOperation> getStatements();

} // WhileLoopOperation
