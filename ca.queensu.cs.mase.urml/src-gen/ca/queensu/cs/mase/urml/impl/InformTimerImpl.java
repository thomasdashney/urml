/**
 */
package ca.queensu.cs.mase.urml.impl;

import ca.queensu.cs.mase.urml.Expression;
import ca.queensu.cs.mase.urml.InformTimer;
import ca.queensu.cs.mase.urml.TimerPort;
import ca.queensu.cs.mase.urml.UrmlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inform Timer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.InformTimerImpl#getTimerPort <em>Timer Port</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.InformTimerImpl#getTime <em>Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InformTimerImpl extends StatementOperationImpl implements InformTimer
{
  /**
   * The cached value of the '{@link #getTimerPort() <em>Timer Port</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimerPort()
   * @generated
   * @ordered
   */
  protected TimerPort timerPort;

  /**
   * The cached value of the '{@link #getTime() <em>Time</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTime()
   * @generated
   * @ordered
   */
  protected Expression time;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InformTimerImpl()
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
    return UrmlPackage.Literals.INFORM_TIMER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimerPort getTimerPort()
  {
    if (timerPort != null && timerPort.eIsProxy())
    {
      InternalEObject oldTimerPort = (InternalEObject)timerPort;
      timerPort = (TimerPort)eResolveProxy(oldTimerPort);
      if (timerPort != oldTimerPort)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UrmlPackage.INFORM_TIMER__TIMER_PORT, oldTimerPort, timerPort));
      }
    }
    return timerPort;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimerPort basicGetTimerPort()
  {
    return timerPort;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTimerPort(TimerPort newTimerPort)
  {
    TimerPort oldTimerPort = timerPort;
    timerPort = newTimerPort;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.INFORM_TIMER__TIMER_PORT, oldTimerPort, timerPort));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getTime()
  {
    return time;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTime(Expression newTime, NotificationChain msgs)
  {
    Expression oldTime = time;
    time = newTime;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UrmlPackage.INFORM_TIMER__TIME, oldTime, newTime);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTime(Expression newTime)
  {
    if (newTime != time)
    {
      NotificationChain msgs = null;
      if (time != null)
        msgs = ((InternalEObject)time).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UrmlPackage.INFORM_TIMER__TIME, null, msgs);
      if (newTime != null)
        msgs = ((InternalEObject)newTime).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UrmlPackage.INFORM_TIMER__TIME, null, msgs);
      msgs = basicSetTime(newTime, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.INFORM_TIMER__TIME, newTime, newTime));
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
      case UrmlPackage.INFORM_TIMER__TIME:
        return basicSetTime(null, msgs);
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
      case UrmlPackage.INFORM_TIMER__TIMER_PORT:
        if (resolve) return getTimerPort();
        return basicGetTimerPort();
      case UrmlPackage.INFORM_TIMER__TIME:
        return getTime();
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
      case UrmlPackage.INFORM_TIMER__TIMER_PORT:
        setTimerPort((TimerPort)newValue);
        return;
      case UrmlPackage.INFORM_TIMER__TIME:
        setTime((Expression)newValue);
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
      case UrmlPackage.INFORM_TIMER__TIMER_PORT:
        setTimerPort((TimerPort)null);
        return;
      case UrmlPackage.INFORM_TIMER__TIME:
        setTime((Expression)null);
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
      case UrmlPackage.INFORM_TIMER__TIMER_PORT:
        return timerPort != null;
      case UrmlPackage.INFORM_TIMER__TIME:
        return time != null;
    }
    return super.eIsSet(featureID);
  }

} //InformTimerImpl
