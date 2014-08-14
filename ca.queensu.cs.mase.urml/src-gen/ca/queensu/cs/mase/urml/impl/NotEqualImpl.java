/**
 */
package ca.queensu.cs.mase.urml.impl;

import ca.queensu.cs.mase.urml.Expression;
import ca.queensu.cs.mase.urml.NotEqual;
import ca.queensu.cs.mase.urml.UrmlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Not Equal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.NotEqualImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.NotEqualImpl#getRest <em>Rest</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NotEqualImpl extends ExpressionImpl implements NotEqual
{
  /**
   * The cached value of the '{@link #getLeft() <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeft()
   * @generated
   * @ordered
   */
  protected Expression left;

  /**
   * The cached value of the '{@link #getRest() <em>Rest</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRest()
   * @generated
   * @ordered
   */
  protected Expression rest;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NotEqualImpl()
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
    return UrmlPackage.Literals.NOT_EQUAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getLeft()
  {
    return left;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLeft(Expression newLeft, NotificationChain msgs)
  {
    Expression oldLeft = left;
    left = newLeft;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UrmlPackage.NOT_EQUAL__LEFT, oldLeft, newLeft);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLeft(Expression newLeft)
  {
    if (newLeft != left)
    {
      NotificationChain msgs = null;
      if (left != null)
        msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UrmlPackage.NOT_EQUAL__LEFT, null, msgs);
      if (newLeft != null)
        msgs = ((InternalEObject)newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UrmlPackage.NOT_EQUAL__LEFT, null, msgs);
      msgs = basicSetLeft(newLeft, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.NOT_EQUAL__LEFT, newLeft, newLeft));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getRest()
  {
    return rest;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRest(Expression newRest, NotificationChain msgs)
  {
    Expression oldRest = rest;
    rest = newRest;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UrmlPackage.NOT_EQUAL__REST, oldRest, newRest);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRest(Expression newRest)
  {
    if (newRest != rest)
    {
      NotificationChain msgs = null;
      if (rest != null)
        msgs = ((InternalEObject)rest).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UrmlPackage.NOT_EQUAL__REST, null, msgs);
      if (newRest != null)
        msgs = ((InternalEObject)newRest).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UrmlPackage.NOT_EQUAL__REST, null, msgs);
      msgs = basicSetRest(newRest, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.NOT_EQUAL__REST, newRest, newRest));
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
      case UrmlPackage.NOT_EQUAL__LEFT:
        return basicSetLeft(null, msgs);
      case UrmlPackage.NOT_EQUAL__REST:
        return basicSetRest(null, msgs);
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
      case UrmlPackage.NOT_EQUAL__LEFT:
        return getLeft();
      case UrmlPackage.NOT_EQUAL__REST:
        return getRest();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case UrmlPackage.NOT_EQUAL__LEFT:
        setLeft((Expression)newValue);
        return;
      case UrmlPackage.NOT_EQUAL__REST:
        setRest((Expression)newValue);
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
      case UrmlPackage.NOT_EQUAL__LEFT:
        setLeft((Expression)null);
        return;
      case UrmlPackage.NOT_EQUAL__REST:
        setRest((Expression)null);
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
      case UrmlPackage.NOT_EQUAL__LEFT:
        return left != null;
      case UrmlPackage.NOT_EQUAL__REST:
        return rest != null;
    }
    return super.eIsSet(featureID);
  }

} //NotEqualImpl
