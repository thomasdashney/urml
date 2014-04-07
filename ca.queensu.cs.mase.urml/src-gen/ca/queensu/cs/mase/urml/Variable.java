/**
 */
package ca.queensu.cs.mase.urml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.Variable#getVar <em>Var</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Variable#isAssign <em>Assign</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Variable#getExp <em>Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.queensu.cs.mase.urml.UrmlPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends StatementOperation, Statement
{
  /**
   * Returns the value of the '<em><b>Var</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Var</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var</em>' containment reference.
   * @see #setVar(LocalVar)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getVariable_Var()
   * @model containment="true"
   * @generated
   */
  LocalVar getVar();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Variable#getVar <em>Var</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var</em>' containment reference.
   * @see #getVar()
   * @generated
   */
  void setVar(LocalVar value);

  /**
   * Returns the value of the '<em><b>Assign</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assign</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assign</em>' attribute.
   * @see #setAssign(boolean)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getVariable_Assign()
   * @model
   * @generated
   */
  boolean isAssign();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Variable#isAssign <em>Assign</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assign</em>' attribute.
   * @see #isAssign()
   * @generated
   */
  void setAssign(boolean value);

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
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getVariable_Exp()
   * @model containment="true"
   * @generated
   */
  Expression getExp();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Variable#getExp <em>Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exp</em>' containment reference.
   * @see #getExp()
   * @generated
   */
  void setExp(Expression value);

} // Variable
