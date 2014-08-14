/**
 */
package ca.queensu.cs.mase.urml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Log Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.LogStatement#getLogPort <em>Log Port</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.LogStatement#getLeft <em>Left</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.queensu.cs.mase.urml.UrmlPackage#getLogStatement()
 * @model
 * @generated
 */
public interface LogStatement extends StatementOperation, Statement
{
  /**
   * Returns the value of the '<em><b>Log Port</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Log Port</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Log Port</em>' reference.
   * @see #setLogPort(LogPort)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getLogStatement_LogPort()
   * @model
   * @generated
   */
  LogPort getLogPort();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.LogStatement#getLogPort <em>Log Port</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Log Port</em>' reference.
   * @see #getLogPort()
   * @generated
   */
  void setLogPort(LogPort value);

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
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getLogStatement_Left()
   * @model containment="true"
   * @generated
   */
  StringExpression getLeft();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.LogStatement#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(StringExpression value);

} // LogStatement
