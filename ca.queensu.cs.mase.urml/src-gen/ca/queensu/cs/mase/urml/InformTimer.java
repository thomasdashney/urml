/**
 */
package ca.queensu.cs.mase.urml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inform Timer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.InformTimer#getTimerPort <em>Timer Port</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.InformTimer#getTime <em>Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.queensu.cs.mase.urml.UrmlPackage#getInformTimer()
 * @model
 * @generated
 */
public interface InformTimer extends StatementOperation, Statement
{
  /**
   * Returns the value of the '<em><b>Timer Port</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Timer Port</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Timer Port</em>' reference.
   * @see #setTimerPort(TimerPort)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getInformTimer_TimerPort()
   * @model
   * @generated
   */
  TimerPort getTimerPort();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.InformTimer#getTimerPort <em>Timer Port</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Timer Port</em>' reference.
   * @see #getTimerPort()
   * @generated
   */
  void setTimerPort(TimerPort value);

  /**
   * Returns the value of the '<em><b>Time</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Time</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Time</em>' containment reference.
   * @see #setTime(Expression)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getInformTimer_Time()
   * @model containment="true"
   * @generated
   */
  Expression getTime();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.InformTimer#getTime <em>Time</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Time</em>' containment reference.
   * @see #getTime()
   * @generated
   */
  void setTime(Expression value);

} // InformTimer
