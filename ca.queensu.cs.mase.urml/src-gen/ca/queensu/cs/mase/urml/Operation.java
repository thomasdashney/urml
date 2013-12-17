/**
 */
package ca.queensu.cs.mase.urml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.Operation#getName <em>Name</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Operation#getVarDecls <em>Var Decls</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.Operation#getOperationCode <em>Operation Code</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.queensu.cs.mase.urml.UrmlPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getOperation_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Operation#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Var Decls</b></em>' containment reference list.
   * The list contents are of type {@link ca.queensu.cs.mase.urml.VarDecl}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Var Decls</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var Decls</em>' containment reference list.
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getOperation_VarDecls()
   * @model containment="true"
   * @generated
   */
  EList<VarDecl> getVarDecls();

  /**
   * Returns the value of the '<em><b>Operation Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operation Code</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operation Code</em>' containment reference.
   * @see #setOperationCode(OperationCode)
   * @see ca.queensu.cs.mase.urml.UrmlPackage#getOperation_OperationCode()
   * @model containment="true"
   * @generated
   */
  OperationCode getOperationCode();

  /**
   * Sets the value of the '{@link ca.queensu.cs.mase.urml.Operation#getOperationCode <em>Operation Code</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operation Code</em>' containment reference.
   * @see #getOperationCode()
   * @generated
   */
  void setOperationCode(OperationCode value);

} // Operation
