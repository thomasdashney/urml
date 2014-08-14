/**
 */
package ca.queensu.cs.mase.urml.impl;

import ca.queensu.cs.mase.urml.Expression;
import ca.queensu.cs.mase.urml.Port;
import ca.queensu.cs.mase.urml.Signal;
import ca.queensu.cs.mase.urml.Trigger_out;
import ca.queensu.cs.mase.urml.UrmlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trigger out</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.Trigger_outImpl#getTo <em>To</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.Trigger_outImpl#getSignal <em>Signal</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.Trigger_outImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Trigger_outImpl extends MinimalEObjectImpl.Container implements Trigger_out
{
  /**
   * The cached value of the '{@link #getTo() <em>To</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTo()
   * @generated
   * @ordered
   */
  protected Port to;

  /**
   * The cached value of the '{@link #getSignal() <em>Signal</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSignal()
   * @generated
   * @ordered
   */
  protected Signal signal;

  /**
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
  protected EList<Expression> parameters;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Trigger_outImpl()
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
    return UrmlPackage.Literals.TRIGGER_OUT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Port getTo()
  {
    if (to != null && to.eIsProxy())
    {
      InternalEObject oldTo = (InternalEObject)to;
      to = (Port)eResolveProxy(oldTo);
      if (to != oldTo)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UrmlPackage.TRIGGER_OUT__TO, oldTo, to));
      }
    }
    return to;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Port basicGetTo()
  {
    return to;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTo(Port newTo)
  {
    Port oldTo = to;
    to = newTo;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.TRIGGER_OUT__TO, oldTo, to));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Signal getSignal()
  {
    if (signal != null && signal.eIsProxy())
    {
      InternalEObject oldSignal = (InternalEObject)signal;
      signal = (Signal)eResolveProxy(oldSignal);
      if (signal != oldSignal)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UrmlPackage.TRIGGER_OUT__SIGNAL, oldSignal, signal));
      }
    }
    return signal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Signal basicGetSignal()
  {
    return signal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSignal(Signal newSignal)
  {
    Signal oldSignal = signal;
    signal = newSignal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.TRIGGER_OUT__SIGNAL, oldSignal, signal));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expression> getParameters()
  {
    if (parameters == null)
    {
      parameters = new EObjectContainmentEList<Expression>(Expression.class, this, UrmlPackage.TRIGGER_OUT__PARAMETERS);
    }
    return parameters;
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
      case UrmlPackage.TRIGGER_OUT__PARAMETERS:
        return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
      case UrmlPackage.TRIGGER_OUT__TO:
        if (resolve) return getTo();
        return basicGetTo();
      case UrmlPackage.TRIGGER_OUT__SIGNAL:
        if (resolve) return getSignal();
        return basicGetSignal();
      case UrmlPackage.TRIGGER_OUT__PARAMETERS:
        return getParameters();
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
      case UrmlPackage.TRIGGER_OUT__TO:
        setTo((Port)newValue);
        return;
      case UrmlPackage.TRIGGER_OUT__SIGNAL:
        setSignal((Signal)newValue);
        return;
      case UrmlPackage.TRIGGER_OUT__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends Expression>)newValue);
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
      case UrmlPackage.TRIGGER_OUT__TO:
        setTo((Port)null);
        return;
      case UrmlPackage.TRIGGER_OUT__SIGNAL:
        setSignal((Signal)null);
        return;
      case UrmlPackage.TRIGGER_OUT__PARAMETERS:
        getParameters().clear();
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
      case UrmlPackage.TRIGGER_OUT__TO:
        return to != null;
      case UrmlPackage.TRIGGER_OUT__SIGNAL:
        return signal != null;
      case UrmlPackage.TRIGGER_OUT__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Trigger_outImpl
