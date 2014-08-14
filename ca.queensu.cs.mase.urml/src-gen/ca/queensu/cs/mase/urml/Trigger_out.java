/**
 */
package ca.queensu.cs.mase.urml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trigger out</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.Trigger_out#getTo <em>To</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Trigger_out#getSignal <em>Signal</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Trigger_out#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.queensu.cs.mase.urml.UrmlPackage#getTrigger_out()
 * @model
 * @generated
 */
public interface Trigger_out extends EObject
{
  /**
   * Returns the value of the '<em><b>To</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>To</em>' reference.
   * @see #setTo(Port)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getTrigger_out_To()
   * @model
   * @generated
   */
  Port getTo();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Trigger_out#getTo <em>To</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To</em>' reference.
   * @see #getTo()
   * @generated
   */
  void setTo(Port value);

  /**
   * Returns the value of the '<em><b>Signal</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Signal</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Signal</em>' reference.
   * @see #setSignal(Signal)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getTrigger_out_Signal()
   * @model
   * @generated
   */
  Signal getSignal();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Trigger_out#getSignal <em>Signal</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Signal</em>' reference.
   * @see #getSignal()
   * @generated
   */
  void setSignal(Signal value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link ca.queensu.cs.mase.urml.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getTrigger_out_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getParameters();

} // Trigger_out
