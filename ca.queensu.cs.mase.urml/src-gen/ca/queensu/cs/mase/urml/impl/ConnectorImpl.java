/**
 */
package ca.queensu.cs.mase.urml.impl;

import ca.queensu.cs.mase.urml.CapsuleInst;
import ca.queensu.cs.mase.urml.Connector;
import ca.queensu.cs.mase.urml.Port;
import ca.queensu.cs.mase.urml.UrmlPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.ConnectorImpl#getCapsuleInst1 <em>Capsule Inst1</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.ConnectorImpl#getPort1 <em>Port1</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.ConnectorImpl#getCapsuleInst2 <em>Capsule Inst2</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.ConnectorImpl#getPort2 <em>Port2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectorImpl extends MinimalEObjectImpl.Container implements Connector
{
  /**
   * The cached value of the '{@link #getCapsuleInst1() <em>Capsule Inst1</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCapsuleInst1()
   * @generated
   * @ordered
   */
  protected CapsuleInst capsuleInst1;

  /**
   * The cached value of the '{@link #getPort1() <em>Port1</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPort1()
   * @generated
   * @ordered
   */
  protected Port port1;

  /**
   * The cached value of the '{@link #getCapsuleInst2() <em>Capsule Inst2</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCapsuleInst2()
   * @generated
   * @ordered
   */
  protected CapsuleInst capsuleInst2;

  /**
   * The cached value of the '{@link #getPort2() <em>Port2</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPort2()
   * @generated
   * @ordered
   */
  protected Port port2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConnectorImpl()
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
    return UrmlPackage.Literals.CONNECTOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CapsuleInst getCapsuleInst1()
  {
    if (capsuleInst1 != null && capsuleInst1.eIsProxy())
    {
      InternalEObject oldCapsuleInst1 = (InternalEObject)capsuleInst1;
      capsuleInst1 = (CapsuleInst)eResolveProxy(oldCapsuleInst1);
      if (capsuleInst1 != oldCapsuleInst1)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UrmlPackage.CONNECTOR__CAPSULE_INST1, oldCapsuleInst1, capsuleInst1));
      }
    }
    return capsuleInst1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CapsuleInst basicGetCapsuleInst1()
  {
    return capsuleInst1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCapsuleInst1(CapsuleInst newCapsuleInst1)
  {
    CapsuleInst oldCapsuleInst1 = capsuleInst1;
    capsuleInst1 = newCapsuleInst1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.CONNECTOR__CAPSULE_INST1, oldCapsuleInst1, capsuleInst1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Port getPort1()
  {
    if (port1 != null && port1.eIsProxy())
    {
      InternalEObject oldPort1 = (InternalEObject)port1;
      port1 = (Port)eResolveProxy(oldPort1);
      if (port1 != oldPort1)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UrmlPackage.CONNECTOR__PORT1, oldPort1, port1));
      }
    }
    return port1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Port basicGetPort1()
  {
    return port1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPort1(Port newPort1)
  {
    Port oldPort1 = port1;
    port1 = newPort1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.CONNECTOR__PORT1, oldPort1, port1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CapsuleInst getCapsuleInst2()
  {
    if (capsuleInst2 != null && capsuleInst2.eIsProxy())
    {
      InternalEObject oldCapsuleInst2 = (InternalEObject)capsuleInst2;
      capsuleInst2 = (CapsuleInst)eResolveProxy(oldCapsuleInst2);
      if (capsuleInst2 != oldCapsuleInst2)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UrmlPackage.CONNECTOR__CAPSULE_INST2, oldCapsuleInst2, capsuleInst2));
      }
    }
    return capsuleInst2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CapsuleInst basicGetCapsuleInst2()
  {
    return capsuleInst2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCapsuleInst2(CapsuleInst newCapsuleInst2)
  {
    CapsuleInst oldCapsuleInst2 = capsuleInst2;
    capsuleInst2 = newCapsuleInst2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.CONNECTOR__CAPSULE_INST2, oldCapsuleInst2, capsuleInst2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Port getPort2()
  {
    if (port2 != null && port2.eIsProxy())
    {
      InternalEObject oldPort2 = (InternalEObject)port2;
      port2 = (Port)eResolveProxy(oldPort2);
      if (port2 != oldPort2)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UrmlPackage.CONNECTOR__PORT2, oldPort2, port2));
      }
    }
    return port2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Port basicGetPort2()
  {
    return port2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPort2(Port newPort2)
  {
    Port oldPort2 = port2;
    port2 = newPort2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.CONNECTOR__PORT2, oldPort2, port2));
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
      case UrmlPackage.CONNECTOR__CAPSULE_INST1:
        if (resolve) return getCapsuleInst1();
        return basicGetCapsuleInst1();
      case UrmlPackage.CONNECTOR__PORT1:
        if (resolve) return getPort1();
        return basicGetPort1();
      case UrmlPackage.CONNECTOR__CAPSULE_INST2:
        if (resolve) return getCapsuleInst2();
        return basicGetCapsuleInst2();
      case UrmlPackage.CONNECTOR__PORT2:
        if (resolve) return getPort2();
        return basicGetPort2();
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
      case UrmlPackage.CONNECTOR__CAPSULE_INST1:
        setCapsuleInst1((CapsuleInst)newValue);
        return;
      case UrmlPackage.CONNECTOR__PORT1:
        setPort1((Port)newValue);
        return;
      case UrmlPackage.CONNECTOR__CAPSULE_INST2:
        setCapsuleInst2((CapsuleInst)newValue);
        return;
      case UrmlPackage.CONNECTOR__PORT2:
        setPort2((Port)newValue);
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
      case UrmlPackage.CONNECTOR__CAPSULE_INST1:
        setCapsuleInst1((CapsuleInst)null);
        return;
      case UrmlPackage.CONNECTOR__PORT1:
        setPort1((Port)null);
        return;
      case UrmlPackage.CONNECTOR__CAPSULE_INST2:
        setCapsuleInst2((CapsuleInst)null);
        return;
      case UrmlPackage.CONNECTOR__PORT2:
        setPort2((Port)null);
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
      case UrmlPackage.CONNECTOR__CAPSULE_INST1:
        return capsuleInst1 != null;
      case UrmlPackage.CONNECTOR__PORT1:
        return port1 != null;
      case UrmlPackage.CONNECTOR__CAPSULE_INST2:
        return capsuleInst2 != null;
      case UrmlPackage.CONNECTOR__PORT2:
        return port2 != null;
    }
    return super.eIsSet(featureID);
  }

} //ConnectorImpl
