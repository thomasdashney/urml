/**
 */
package ca.queensu.cs.mase.urml.impl;

import ca.queensu.cs.mase.urml.IncomingVariable;
import ca.queensu.cs.mase.urml.Port;
import ca.queensu.cs.mase.urml.Signal;
import ca.queensu.cs.mase.urml.Trigger_in;
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
 * An implementation of the model object '<em><b>Trigger in</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.Trigger_inImpl#getFrom <em>From</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.Trigger_inImpl#getSignal <em>Signal</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.Trigger_inImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Trigger_inImpl extends MinimalEObjectImpl.Container implements Trigger_in
{
  /**
   * The cached value of the '{@link #getFrom() <em>From</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFrom()
   * @generated
   * @ordered
   */
  protected Port from;

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
  protected EList<IncomingVariable> parameters;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Trigger_inImpl()
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
    return UrmlPackage.Literals.TRIGGER_IN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Port getFrom()
  {
    if (from != null && from.eIsProxy())
    {
      InternalEObject oldFrom = (InternalEObject)from;
      from = (Port)eResolveProxy(oldFrom);
      if (from != oldFrom)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UrmlPackage.TRIGGER_IN__FROM, oldFrom, from));
      }
    }
    return from;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Port basicGetFrom()
  {
    return from;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFrom(Port newFrom)
  {
    Port oldFrom = from;
    from = newFrom;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.TRIGGER_IN__FROM, oldFrom, from));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UrmlPackage.TRIGGER_IN__SIGNAL, oldSignal, signal));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.TRIGGER_IN__SIGNAL, oldSignal, signal));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<IncomingVariable> getParameters()
  {
    if (parameters == null)
    {
      parameters = new EObjectContainmentEList<IncomingVariable>(IncomingVariable.class, this, UrmlPackage.TRIGGER_IN__PARAMETERS);
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
      case UrmlPackage.TRIGGER_IN__PARAMETERS:
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
      case UrmlPackage.TRIGGER_IN__FROM:
        if (resolve) return getFrom();
        return basicGetFrom();
      case UrmlPackage.TRIGGER_IN__SIGNAL:
        if (resolve) return getSignal();
        return basicGetSignal();
      case UrmlPackage.TRIGGER_IN__PARAMETERS:
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
      case UrmlPackage.TRIGGER_IN__FROM:
        setFrom((Port)newValue);
        return;
      case UrmlPackage.TRIGGER_IN__SIGNAL:
        setSignal((Signal)newValue);
        return;
      case UrmlPackage.TRIGGER_IN__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends IncomingVariable>)newValue);
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
      case UrmlPackage.TRIGGER_IN__FROM:
        setFrom((Port)null);
        return;
      case UrmlPackage.TRIGGER_IN__SIGNAL:
        setSignal((Signal)null);
        return;
      case UrmlPackage.TRIGGER_IN__PARAMETERS:
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
      case UrmlPackage.TRIGGER_IN__FROM:
        return from != null;
      case UrmlPackage.TRIGGER_IN__SIGNAL:
        return signal != null;
      case UrmlPackage.TRIGGER_IN__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Trigger_inImpl
