/**
 */
package ca.queensu.cs.mase.urml.impl;

import ca.queensu.cs.mase.urml.ActionCode;
import ca.queensu.cs.mase.urml.StateMachine;
import ca.queensu.cs.mase.urml.State_;
import ca.queensu.cs.mase.urml.UrmlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.State_Impl#isFinal <em>Final</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.State_Impl#getName <em>Name</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.State_Impl#getEntryCode <em>Entry Code</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.State_Impl#getExitCode <em>Exit Code</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.State_Impl#getSubstatemachine <em>Substatemachine</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class State_Impl extends MinimalEObjectImpl.Container implements State_
{
  /**
   * The default value of the '{@link #isFinal() <em>Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFinal()
   * @generated
   * @ordered
   */
  protected static final boolean FINAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isFinal() <em>Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFinal()
   * @generated
   * @ordered
   */
  protected boolean final_ = FINAL_EDEFAULT;

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
   * The cached value of the '{@link #getEntryCode() <em>Entry Code</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEntryCode()
   * @generated
   * @ordered
   */
  protected ActionCode entryCode;

  /**
   * The cached value of the '{@link #getExitCode() <em>Exit Code</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExitCode()
   * @generated
   * @ordered
   */
  protected ActionCode exitCode;

  /**
   * The cached value of the '{@link #getSubstatemachine() <em>Substatemachine</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubstatemachine()
   * @generated
   * @ordered
   */
  protected StateMachine substatemachine;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected State_Impl()
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
    return UrmlPackage.Literals.STATE_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isFinal()
  {
    return final_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFinal(boolean newFinal)
  {
    boolean oldFinal = final_;
    final_ = newFinal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.STATE___FINAL, oldFinal, final_));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.STATE___NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActionCode getEntryCode()
  {
    return entryCode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEntryCode(ActionCode newEntryCode, NotificationChain msgs)
  {
    ActionCode oldEntryCode = entryCode;
    entryCode = newEntryCode;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UrmlPackage.STATE___ENTRY_CODE, oldEntryCode, newEntryCode);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEntryCode(ActionCode newEntryCode)
  {
    if (newEntryCode != entryCode)
    {
      NotificationChain msgs = null;
      if (entryCode != null)
        msgs = ((InternalEObject)entryCode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UrmlPackage.STATE___ENTRY_CODE, null, msgs);
      if (newEntryCode != null)
        msgs = ((InternalEObject)newEntryCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UrmlPackage.STATE___ENTRY_CODE, null, msgs);
      msgs = basicSetEntryCode(newEntryCode, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.STATE___ENTRY_CODE, newEntryCode, newEntryCode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActionCode getExitCode()
  {
    return exitCode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExitCode(ActionCode newExitCode, NotificationChain msgs)
  {
    ActionCode oldExitCode = exitCode;
    exitCode = newExitCode;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UrmlPackage.STATE___EXIT_CODE, oldExitCode, newExitCode);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExitCode(ActionCode newExitCode)
  {
    if (newExitCode != exitCode)
    {
      NotificationChain msgs = null;
      if (exitCode != null)
        msgs = ((InternalEObject)exitCode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UrmlPackage.STATE___EXIT_CODE, null, msgs);
      if (newExitCode != null)
        msgs = ((InternalEObject)newExitCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UrmlPackage.STATE___EXIT_CODE, null, msgs);
      msgs = basicSetExitCode(newExitCode, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.STATE___EXIT_CODE, newExitCode, newExitCode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateMachine getSubstatemachine()
  {
    return substatemachine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSubstatemachine(StateMachine newSubstatemachine, NotificationChain msgs)
  {
    StateMachine oldSubstatemachine = substatemachine;
    substatemachine = newSubstatemachine;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UrmlPackage.STATE___SUBSTATEMACHINE, oldSubstatemachine, newSubstatemachine);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubstatemachine(StateMachine newSubstatemachine)
  {
    if (newSubstatemachine != substatemachine)
    {
      NotificationChain msgs = null;
      if (substatemachine != null)
        msgs = ((InternalEObject)substatemachine).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UrmlPackage.STATE___SUBSTATEMACHINE, null, msgs);
      if (newSubstatemachine != null)
        msgs = ((InternalEObject)newSubstatemachine).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UrmlPackage.STATE___SUBSTATEMACHINE, null, msgs);
      msgs = basicSetSubstatemachine(newSubstatemachine, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.STATE___SUBSTATEMACHINE, newSubstatemachine, newSubstatemachine));
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
      case UrmlPackage.STATE___ENTRY_CODE:
        return basicSetEntryCode(null, msgs);
      case UrmlPackage.STATE___EXIT_CODE:
        return basicSetExitCode(null, msgs);
      case UrmlPackage.STATE___SUBSTATEMACHINE:
        return basicSetSubstatemachine(null, msgs);
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
      case UrmlPackage.STATE___FINAL:
        return isFinal();
      case UrmlPackage.STATE___NAME:
        return getName();
      case UrmlPackage.STATE___ENTRY_CODE:
        return getEntryCode();
      case UrmlPackage.STATE___EXIT_CODE:
        return getExitCode();
      case UrmlPackage.STATE___SUBSTATEMACHINE:
        return getSubstatemachine();
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
      case UrmlPackage.STATE___FINAL:
        setFinal((Boolean)newValue);
        return;
      case UrmlPackage.STATE___NAME:
        setName((String)newValue);
        return;
      case UrmlPackage.STATE___ENTRY_CODE:
        setEntryCode((ActionCode)newValue);
        return;
      case UrmlPackage.STATE___EXIT_CODE:
        setExitCode((ActionCode)newValue);
        return;
      case UrmlPackage.STATE___SUBSTATEMACHINE:
        setSubstatemachine((StateMachine)newValue);
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
      case UrmlPackage.STATE___FINAL:
        setFinal(FINAL_EDEFAULT);
        return;
      case UrmlPackage.STATE___NAME:
        setName(NAME_EDEFAULT);
        return;
      case UrmlPackage.STATE___ENTRY_CODE:
        setEntryCode((ActionCode)null);
        return;
      case UrmlPackage.STATE___EXIT_CODE:
        setExitCode((ActionCode)null);
        return;
      case UrmlPackage.STATE___SUBSTATEMACHINE:
        setSubstatemachine((StateMachine)null);
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
      case UrmlPackage.STATE___FINAL:
        return final_ != FINAL_EDEFAULT;
      case UrmlPackage.STATE___NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case UrmlPackage.STATE___ENTRY_CODE:
        return entryCode != null;
      case UrmlPackage.STATE___EXIT_CODE:
        return exitCode != null;
      case UrmlPackage.STATE___SUBSTATEMACHINE:
        return substatemachine != null;
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
    result.append(" (final: ");
    result.append(final_);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //State_Impl
