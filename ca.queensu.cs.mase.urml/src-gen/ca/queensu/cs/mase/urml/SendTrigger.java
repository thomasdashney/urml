/**
 */
package ca.queensu.cs.mase.urml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Send Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.SendTrigger#getTriggers <em>Triggers</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.queensu.cs.mase.urml.UrmlPackage#getSendTrigger()
 * @model
 * @generated
 */
public interface SendTrigger extends StatementOperation, Statement
{
  /**
   * Returns the value of the '<em><b>Triggers</b></em>' containment reference list.
   * The list contents are of type {@link ca.queensu.cs.mase.urml.Trigger_out}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Triggers</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Triggers</em>' containment reference list.
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getSendTrigger_Triggers()
   * @model containment="true"
   * @generated
   */
  EList<Trigger_out> getTriggers();

} // SendTrigger
