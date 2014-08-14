/**
 */
package ca.queensu.cs.mase.urml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invoke</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.Invoke#getOperation <em>Operation</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Invoke#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.queensu.cs.mase.urml.UrmlPackage#getInvoke()
 * @model
 * @generated
 */
public interface Invoke extends StatementOperation, Statement
{
  /**
   * Returns the value of the '<em><b>Operation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operation</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operation</em>' reference.
   * @see #setOperation(Operation)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getInvoke_Operation()
   * @model
   * @generated
   */
  Operation getOperation();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Invoke#getOperation <em>Operation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operation</em>' reference.
   * @see #getOperation()
   * @generated
   */
  void setOperation(Operation value);

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
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getInvoke_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getParameters();

} // Invoke
