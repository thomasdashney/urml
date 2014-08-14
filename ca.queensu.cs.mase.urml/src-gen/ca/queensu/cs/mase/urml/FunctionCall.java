/**
 */
package ca.queensu.cs.mase.urml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.FunctionCall#getCall <em>Call</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.FunctionCall#getParams <em>Params</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.queensu.cs.mase.urml.UrmlPackage#getFunctionCall()
 * @model
 * @generated
 */
public interface FunctionCall extends Literal
{
  /**
   * Returns the value of the '<em><b>Call</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Call</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Call</em>' reference.
   * @see #setCall(Operation)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getFunctionCall_Call()
   * @model
   * @generated
   */
  Operation getCall();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.FunctionCall#getCall <em>Call</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Call</em>' reference.
   * @see #getCall()
   * @generated
   */
  void setCall(Operation value);

  /**
   * Returns the value of the '<em><b>Params</b></em>' containment reference list.
   * The list contents are of type {@link ca.queensu.cs.mase.urml.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Params</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Params</em>' containment reference list.
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getFunctionCall_Params()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getParams();

} // FunctionCall
