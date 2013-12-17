/**
 */
package ca.queensu.cs.mase.urml.impl;

import ca.queensu.cs.mase.urml.CapsuleRef;
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
 *   <li>{@link ca.queensu.cs.mase.urml.impl.ConnectorImpl#getCapsuleRef1 <em>Capsule Ref1</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.ConnectorImpl#getPort1 <em>Port1</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.ConnectorImpl#getCapsuleRef2 <em>Capsule Ref2</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.ConnectorImpl#getPort2 <em>Port2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectorImpl extends MinimalEObjectImpl.Container implements Connector
{
  /**
   * The cached value of the '{@link #getCapsuleRef1() <em>Capsule Ref1</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCapsuleRef1()
   * @generated
   * @ordered
   */
  protected CapsuleRef capsuleRef1;

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
   * The cached value of the '{@link #getCapsuleRef2() <em>Capsule Ref2</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCapsuleRef2()
   * @generated
   * @ordered
   */
  protected CapsuleRef capsuleRef2;

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
  public CapsuleRef getCapsuleRef1()
  {
    if (capsuleRef1 != null && capsuleRef1.eIsProxy())
    {
      InternalEObject oldCapsuleRef1 = (InternalEObject)capsuleRef1;
      capsuleRef1 = (CapsuleRef)eResolveProxy(oldCapsuleRef1);
      if (capsuleRef1 != oldCapsuleRef1)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UrmlPackage.CONNECTOR__CAPSULE_REF1, oldCapsuleRef1, capsuleRef1));
      }
    }
    return capsuleRef1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CapsuleRef basicGetCapsuleRef1()
  {
    return capsuleRef1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCapsuleRef1(CapsuleRef newCapsuleRef1)
  {
    CapsuleRef oldCapsuleRef1 = capsuleRef1;
    capsuleRef1 = newCapsuleRef1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.CONNECTOR__CAPSULE_REF1, oldCapsuleRef1, capsuleRef1));
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
  public CapsuleRef getCapsuleRef2()
  {
    if (capsuleRef2 != null && capsuleRef2.eIsProxy())
    {
      InternalEObject oldCapsuleRef2 = (InternalEObject)capsuleRef2;
      capsuleRef2 = (CapsuleRef)eResolveProxy(oldCapsuleRef2);
      if (capsuleRef2 != oldCapsuleRef2)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UrmlPackage.CONNECTOR__CAPSULE_REF2, oldCapsuleRef2, capsuleRef2));
      }
    }
    return capsuleRef2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CapsuleRef basicGetCapsuleRef2()
  {
    return capsuleRef2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCapsuleRef2(CapsuleRef newCapsuleRef2)
  {
    CapsuleRef oldCapsuleRef2 = capsuleRef2;
    capsuleRef2 = newCapsuleRef2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.CONNECTOR__CAPSULE_REF2, oldCapsuleRef2, capsuleRef2));
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
      case UrmlPackage.CONNECTOR__CAPSULE_REF1:
        if (resolve) return getCapsuleRef1();
        return basicGetCapsuleRef1();
      case UrmlPackage.CONNECTOR__PORT1:
        if (resolve) return getPort1();
        return basicGetPort1();
      case UrmlPackage.CONNECTOR__CAPSULE_REF2:
        if (resolve) return getCapsuleRef2();
        return basicGetCapsuleRef2();
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
      case UrmlPackage.CONNECTOR__CAPSULE_REF1:
        setCapsuleRef1((CapsuleRef)newValue);
        return;
      case UrmlPackage.CONNECTOR__PORT1:
        setPort1((Port)newValue);
        return;
      case UrmlPackage.CONNECTOR__CAPSULE_REF2:
        setCapsuleRef2((CapsuleRef)newValue);
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
      case UrmlPackage.CONNECTOR__CAPSULE_REF1:
        setCapsuleRef1((CapsuleRef)null);
        return;
      case UrmlPackage.CONNECTOR__PORT1:
        setPort1((Port)null);
        return;
      case UrmlPackage.CONNECTOR__CAPSULE_REF2:
        setCapsuleRef2((CapsuleRef)null);
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
      case UrmlPackage.CONNECTOR__CAPSULE_REF1:
        return capsuleRef1 != null;
      case UrmlPackage.CONNECTOR__PORT1:
        return port1 != null;
      case UrmlPackage.CONNECTOR__CAPSULE_REF2:
        return capsuleRef2 != null;
      case UrmlPackage.CONNECTOR__PORT2:
        return port2 != null;
    }
    return super.eIsSet(featureID);
  }

} //ConnectorImpl
