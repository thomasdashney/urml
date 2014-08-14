/**
 */
package ca.queensu.cs.mase.urml.impl;

import ca.queensu.cs.mase.urml.Expression;
import ca.queensu.cs.mase.urml.IfStatementOperation;
import ca.queensu.cs.mase.urml.StatementOperation;
import ca.queensu.cs.mase.urml.UrmlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Statement Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.IfStatementOperationImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.IfStatementOperationImpl#getThenStatements <em>Then Statements</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.IfStatementOperationImpl#getElseStatements <em>Else Statements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfStatementOperationImpl extends StatementOperationImpl implements IfStatementOperation
{
  /**
   * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
  protected Expression condition;

  /**
   * The cached value of the '{@link #getThenStatements() <em>Then Statements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThenStatements()
   * @generated
   * @ordered
   */
  protected EList<StatementOperation> thenStatements;

  /**
   * The cached value of the '{@link #getElseStatements() <em>Else Statements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElseStatements()
   * @generated
   * @ordered
   */
  protected EList<StatementOperation> elseStatements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IfStatementOperationImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return UrmlPackage.Literals.IF_STATEMENT_OPERATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getCondition()
  {
    return condition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCondition(Expression newCondition, NotificationChain msgs)
  {
    Expression oldCondition = condition;
    condition = newCondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UrmlPackage.IF_STATEMENT_OPERATION__CONDITION, oldCondition, newCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCondition(Expression newCondition)
  {
    if (newCondition != condition)
    {
      NotificationChain msgs = null;
      if (condition != null)
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UrmlPackage.IF_STATEMENT_OPERATION__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UrmlPackage.IF_STATEMENT_OPERATION__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.IF_STATEMENT_OPERATION__CONDITION, newCondition, newCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StatementOperation> getThenStatements()
  {
    if (thenStatements == null)
    {
      thenStatements = new EObjectContainmentEList<StatementOperation>(StatementOperation.class, this, UrmlPackage.IF_STATEMENT_OPERATION__THEN_STATEMENTS);
    }
    return thenStatements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StatementOperation> getElseStatements()
  {
    if (elseStatements == null)
    {
      elseStatements = new EObjectContainmentEList<StatementOperation>(StatementOperation.class, this, UrmlPackage.IF_STATEMENT_OPERATION__ELSE_STATEMENTS);
    }
    return elseStatements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case UrmlPackage.IF_STATEMENT_OPERATION__CONDITION:
        return basicSetCondition(null, msgs);
      case UrmlPackage.IF_STATEMENT_OPERATION__THEN_STATEMENTS:
        return ((InternalEList<?>)getThenStatements()).basicRemove(otherEnd, msgs);
      case UrmlPackage.IF_STATEMENT_OPERATION__ELSE_STATEMENTS:
        return ((InternalEList<?>)getElseStatements()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case UrmlPackage.IF_STATEMENT_OPERATION__CONDITION:
        return getCondition();
      case UrmlPackage.IF_STATEMENT_OPERATION__THEN_STATEMENTS:
        return getThenStatements();
      case UrmlPackage.IF_STATEMENT_OPERATION__ELSE_STATEMENTS:
        return getElseStatements();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case UrmlPackage.IF_STATEMENT_OPERATION__CONDITION:
        setCondition((Expression)newValue);
        return;
      case UrmlPackage.IF_STATEMENT_OPERATION__THEN_STATEMENTS:
        getThenStatements().clear();
        getThenStatements().addAll((Collection<? extends StatementOperation>)newValue);
        return;
      case UrmlPackage.IF_STATEMENT_OPERATION__ELSE_STATEMENTS:
        getElseStatements().clear();
        getElseStatements().addAll((Collection<? extends StatementOperation>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case UrmlPackage.IF_STATEMENT_OPERATION__CONDITION:
        setCondition((Expression)null);
        return;
      case UrmlPackage.IF_STATEMENT_OPERATION__THEN_STATEMENTS:
        getThenStatements().clear();
        return;
      case UrmlPackage.IF_STATEMENT_OPERATION__ELSE_STATEMENTS:
        getElseStatements().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case UrmlPackage.IF_STATEMENT_OPERATION__CONDITION:
        return condition != null;
      case UrmlPackage.IF_STATEMENT_OPERATION__THEN_STATEMENTS:
        return thenStatements != null && !thenStatements.isEmpty();
      case UrmlPackage.IF_STATEMENT_OPERATION__ELSE_STATEMENTS:
        return elseStatements != null && !elseStatements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //IfStatementOperationImpl
