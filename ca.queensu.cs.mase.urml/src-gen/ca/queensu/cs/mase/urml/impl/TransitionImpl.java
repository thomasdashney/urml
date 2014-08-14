/**
 */
package ca.queensu.cs.mase.urml.impl;

import ca.queensu.cs.mase.urml.ActionCode;
import ca.queensu.cs.mase.urml.Expression;
import ca.queensu.cs.mase.urml.State_;
import ca.queensu.cs.mase.urml.TimerPort;
import ca.queensu.cs.mase.urml.Transition;
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
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.TransitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.TransitionImpl#isInit <em>Init</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.TransitionImpl#getFrom <em>From</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.TransitionImpl#getTo <em>To</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.TransitionImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.TransitionImpl#getTriggers <em>Triggers</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.TransitionImpl#getTimerPort <em>Timer Port</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.TransitionImpl#isUniversal <em>Universal</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.TransitionImpl#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionImpl extends MinimalEObjectImpl.Container implements Transition
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #isInit() <em>Init</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isInit()
   * @generated
   * @ordered
   */
  protected static final boolean INIT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isInit() <em>Init</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isInit()
   * @generated
   * @ordered
   */
  protected boolean init = INIT_EDEFAULT;

  /**
   * The cached value of the '{@link #getFrom() <em>From</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFrom()
   * @generated
   * @ordered
   */
  protected State_ from;

  /**
   * The cached value of the '{@link #getTo() <em>To</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTo()
   * @generated
   * @ordered
   */
  protected State_ to;

  /**
   * The cached value of the '{@link #getGuard() <em>Guard</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGuard()
   * @generated
   * @ordered
   */
  protected Expression guard;

  /**
   * The cached value of the '{@link #getTriggers() <em>Triggers</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTriggers()
   * @generated
   * @ordered
   */
  protected EList<Trigger_in> triggers;

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
   * The default value of the '{@link #isUniversal() <em>Universal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUniversal()
   * @generated
   * @ordered
   */
  protected static final boolean UNIVERSAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isUniversal() <em>Universal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUniversal()
   * @generated
   * @ordered
   */
  protected boolean universal = UNIVERSAL_EDEFAULT;

  /**
   * The cached value of the '{@link #getAction() <em>Action</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAction()
   * @generated
   * @ordered
   */
  protected ActionCode action;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TransitionImpl()
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
    return UrmlPackage.Literals.TRANSITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.TRANSITION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isInit()
  {
    return init;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInit(boolean newInit)
  {
    boolean oldInit = init;
    init = newInit;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.TRANSITION__INIT, oldInit, init));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State_ getFrom()
  {
    if (from != null && from.eIsProxy())
    {
      InternalEObject oldFrom = (InternalEObject)from;
      from = (State_)eResolveProxy(oldFrom);
      if (from != oldFrom)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UrmlPackage.TRANSITION__FROM, oldFrom, from));
      }
    }
    return from;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State_ basicGetFrom()
  {
    return from;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFrom(State_ newFrom)
  {
    State_ oldFrom = from;
    from = newFrom;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.TRANSITION__FROM, oldFrom, from));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State_ getTo()
  {
    if (to != null && to.eIsProxy())
    {
      InternalEObject oldTo = (InternalEObject)to;
      to = (State_)eResolveProxy(oldTo);
      if (to != oldTo)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UrmlPackage.TRANSITION__TO, oldTo, to));
      }
    }
    return to;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State_ basicGetTo()
  {
    return to;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTo(State_ newTo)
  {
    State_ oldTo = to;
    to = newTo;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.TRANSITION__TO, oldTo, to));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getGuard()
  {
    return guard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGuard(Expression newGuard, NotificationChain msgs)
  {
    Expression oldGuard = guard;
    guard = newGuard;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UrmlPackage.TRANSITION__GUARD, oldGuard, newGuard);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGuard(Expression newGuard)
  {
    if (newGuard != guard)
    {
      NotificationChain msgs = null;
      if (guard != null)
        msgs = ((InternalEObject)guard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UrmlPackage.TRANSITION__GUARD, null, msgs);
      if (newGuard != null)
        msgs = ((InternalEObject)newGuard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UrmlPackage.TRANSITION__GUARD, null, msgs);
      msgs = basicSetGuard(newGuard, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.TRANSITION__GUARD, newGuard, newGuard));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Trigger_in> getTriggers()
  {
    if (triggers == null)
    {
      triggers = new EObjectContainmentEList<Trigger_in>(Trigger_in.class, this, UrmlPackage.TRANSITION__TRIGGERS);
    }
    return triggers;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UrmlPackage.TRANSITION__TIMER_PORT, oldTimerPort, timerPort));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.TRANSITION__TIMER_PORT, oldTimerPort, timerPort));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isUniversal()
  {
    return universal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUniversal(boolean newUniversal)
  {
    boolean oldUniversal = universal;
    universal = newUniversal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.TRANSITION__UNIVERSAL, oldUniversal, universal));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActionCode getAction()
  {
    return action;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAction(ActionCode newAction, NotificationChain msgs)
  {
    ActionCode oldAction = action;
    action = newAction;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UrmlPackage.TRANSITION__ACTION, oldAction, newAction);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAction(ActionCode newAction)
  {
    if (newAction != action)
    {
      NotificationChain msgs = null;
      if (action != null)
        msgs = ((InternalEObject)action).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UrmlPackage.TRANSITION__ACTION, null, msgs);
      if (newAction != null)
        msgs = ((InternalEObject)newAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UrmlPackage.TRANSITION__ACTION, null, msgs);
      msgs = basicSetAction(newAction, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.TRANSITION__ACTION, newAction, newAction));
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
      case UrmlPackage.TRANSITION__GUARD:
        return basicSetGuard(null, msgs);
      case UrmlPackage.TRANSITION__TRIGGERS:
        return ((InternalEList<?>)getTriggers()).basicRemove(otherEnd, msgs);
      case UrmlPackage.TRANSITION__ACTION:
        return basicSetAction(null, msgs);
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
      case UrmlPackage.TRANSITION__NAME:
        return getName();
      case UrmlPackage.TRANSITION__INIT:
        return isInit();
      case UrmlPackage.TRANSITION__FROM:
        if (resolve) return getFrom();
        return basicGetFrom();
      case UrmlPackage.TRANSITION__TO:
        if (resolve) return getTo();
        return basicGetTo();
      case UrmlPackage.TRANSITION__GUARD:
        return getGuard();
      case UrmlPackage.TRANSITION__TRIGGERS:
        return getTriggers();
      case UrmlPackage.TRANSITION__TIMER_PORT:
        if (resolve) return getTimerPort();
        return basicGetTimerPort();
      case UrmlPackage.TRANSITION__UNIVERSAL:
        return isUniversal();
      case UrmlPackage.TRANSITION__ACTION:
        return getAction();
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
      case UrmlPackage.TRANSITION__NAME:
        setName((String)newValue);
        return;
      case UrmlPackage.TRANSITION__INIT:
        setInit((Boolean)newValue);
        return;
      case UrmlPackage.TRANSITION__FROM:
        setFrom((State_)newValue);
        return;
      case UrmlPackage.TRANSITION__TO:
        setTo((State_)newValue);
        return;
      case UrmlPackage.TRANSITION__GUARD:
        setGuard((Expression)newValue);
        return;
      case UrmlPackage.TRANSITION__TRIGGERS:
        getTriggers().clear();
        getTriggers().addAll((Collection<? extends Trigger_in>)newValue);
        return;
      case UrmlPackage.TRANSITION__TIMER_PORT:
        setTimerPort((TimerPort)newValue);
        return;
      case UrmlPackage.TRANSITION__UNIVERSAL:
        setUniversal((Boolean)newValue);
        return;
      case UrmlPackage.TRANSITION__ACTION:
        setAction((ActionCode)newValue);
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
      case UrmlPackage.TRANSITION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case UrmlPackage.TRANSITION__INIT:
        setInit(INIT_EDEFAULT);
        return;
      case UrmlPackage.TRANSITION__FROM:
        setFrom((State_)null);
        return;
      case UrmlPackage.TRANSITION__TO:
        setTo((State_)null);
        return;
      case UrmlPackage.TRANSITION__GUARD:
        setGuard((Expression)null);
        return;
      case UrmlPackage.TRANSITION__TRIGGERS:
        getTriggers().clear();
        return;
      case UrmlPackage.TRANSITION__TIMER_PORT:
        setTimerPort((TimerPort)null);
        return;
      case UrmlPackage.TRANSITION__UNIVERSAL:
        setUniversal(UNIVERSAL_EDEFAULT);
        return;
      case UrmlPackage.TRANSITION__ACTION:
        setAction((ActionCode)null);
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
      case UrmlPackage.TRANSITION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case UrmlPackage.TRANSITION__INIT:
        return init != INIT_EDEFAULT;
      case UrmlPackage.TRANSITION__FROM:
        return from != null;
      case UrmlPackage.TRANSITION__TO:
        return to != null;
      case UrmlPackage.TRANSITION__GUARD:
        return guard != null;
      case UrmlPackage.TRANSITION__TRIGGERS:
        return triggers != null && !triggers.isEmpty();
      case UrmlPackage.TRANSITION__TIMER_PORT:
        return timerPort != null;
      case UrmlPackage.TRANSITION__UNIVERSAL:
        return universal != UNIVERSAL_EDEFAULT;
      case UrmlPackage.TRANSITION__ACTION:
        return action != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", init: ");
    result.append(init);
    result.append(", universal: ");
    result.append(universal);
    result.append(')');
    return result.toString();
  }

} //TransitionImpl
