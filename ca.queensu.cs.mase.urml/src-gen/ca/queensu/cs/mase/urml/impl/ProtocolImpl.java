/**
 */
package ca.queensu.cs.mase.urml.impl;

import ca.queensu.cs.mase.urml.Protocol;
import ca.queensu.cs.mase.urml.Signal;
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
 * An implementation of the model object '<em><b>Protocol</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.ProtocolImpl#getName <em>Name</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.ProtocolImpl#getIncomingMessages <em>Incoming Messages</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.ProtocolImpl#getOutgoingMessages <em>Outgoing Messages</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProtocolImpl extends MinimalEObjectImpl.Container implements Protocol
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
   * The cached value of the '{@link #getIncomingMessages() <em>Incoming Messages</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIncomingMessages()
   * @generated
   * @ordered
   */
  protected EList<Signal> incomingMessages;

  /**
   * The cached value of the '{@link #getOutgoingMessages() <em>Outgoing Messages</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutgoingMessages()
   * @generated
   * @ordered
   */
  protected EList<Signal> outgoingMessages;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProtocolImpl()
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
    return UrmlPackage.Literals.PROTOCOL;
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
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.PROTOCOL__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Signal> getIncomingMessages()
  {
    if (incomingMessages == null)
    {
      incomingMessages = new EObjectContainmentEList<Signal>(Signal.class, this, UrmlPackage.PROTOCOL__INCOMING_MESSAGES);
    }
    return incomingMessages;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Signal> getOutgoingMessages()
  {
    if (outgoingMessages == null)
    {
      outgoingMessages = new EObjectContainmentEList<Signal>(Signal.class, this, UrmlPackage.PROTOCOL__OUTGOING_MESSAGES);
    }
    return outgoingMessages;
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
      case UrmlPackage.PROTOCOL__INCOMING_MESSAGES:
        return ((InternalEList<?>)getIncomingMessages()).basicRemove(otherEnd, msgs);
      case UrmlPackage.PROTOCOL__OUTGOING_MESSAGES:
        return ((InternalEList<?>)getOutgoingMessages()).basicRemove(otherEnd, msgs);
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
      case UrmlPackage.PROTOCOL__NAME:
        return getName();
      case UrmlPackage.PROTOCOL__INCOMING_MESSAGES:
        return getIncomingMessages();
      case UrmlPackage.PROTOCOL__OUTGOING_MESSAGES:
        return getOutgoingMessages();
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
      case UrmlPackage.PROTOCOL__NAME:
        setName((String)newValue);
        return;
      case UrmlPackage.PROTOCOL__INCOMING_MESSAGES:
        getIncomingMessages().clear();
        getIncomingMessages().addAll((Collection<? extends Signal>)newValue);
        return;
      case UrmlPackage.PROTOCOL__OUTGOING_MESSAGES:
        getOutgoingMessages().clear();
        getOutgoingMessages().addAll((Collection<? extends Signal>)newValue);
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
      case UrmlPackage.PROTOCOL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case UrmlPackage.PROTOCOL__INCOMING_MESSAGES:
        getIncomingMessages().clear();
        return;
      case UrmlPackage.PROTOCOL__OUTGOING_MESSAGES:
        getOutgoingMessages().clear();
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
      case UrmlPackage.PROTOCOL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case UrmlPackage.PROTOCOL__INCOMING_MESSAGES:
        return incomingMessages != null && !incomingMessages.isEmpty();
      case UrmlPackage.PROTOCOL__OUTGOING_MESSAGES:
        return outgoingMessages != null && !outgoingMessages.isEmpty();
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
    result.append(')');
    return result.toString();
  }

} //ProtocolImpl
