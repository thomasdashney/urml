/**
 */
package ca.queensu.cs.mase.urml.impl;

import ca.queensu.cs.mase.urml.Attribute;
import ca.queensu.cs.mase.urml.Capsule;
import ca.queensu.cs.mase.urml.CapsuleRef;
import ca.queensu.cs.mase.urml.Connector;
import ca.queensu.cs.mase.urml.LogPort;
import ca.queensu.cs.mase.urml.Operation;
import ca.queensu.cs.mase.urml.Port;
import ca.queensu.cs.mase.urml.StateMachine;
import ca.queensu.cs.mase.urml.TimerPort;
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
 * An implementation of the model object '<em><b>Capsule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.CapsuleImpl#isRoot <em>Root</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.CapsuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.CapsuleImpl#getInterfacePorts <em>Interface Ports</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.CapsuleImpl#getInternalPorts <em>Internal Ports</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.CapsuleImpl#getTimerPorts <em>Timer Ports</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.CapsuleImpl#getLogPorts <em>Log Ports</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.CapsuleImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.CapsuleImpl#getCapsuleRefs <em>Capsule Refs</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.CapsuleImpl#getConnectors <em>Connectors</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.CapsuleImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.CapsuleImpl#getStatemachines <em>Statemachines</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CapsuleImpl extends MinimalEObjectImpl.Container implements Capsule
{
  /**
   * The default value of the '{@link #isRoot() <em>Root</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRoot()
   * @generated
   * @ordered
   */
  protected static final boolean ROOT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isRoot() <em>Root</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRoot()
   * @generated
   * @ordered
   */
  protected boolean root = ROOT_EDEFAULT;

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
   * The cached value of the '{@link #getInterfacePorts() <em>Interface Ports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInterfacePorts()
   * @generated
   * @ordered
   */
  protected EList<Port> interfacePorts;

  /**
   * The cached value of the '{@link #getInternalPorts() <em>Internal Ports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInternalPorts()
   * @generated
   * @ordered
   */
  protected EList<Port> internalPorts;

  /**
   * The cached value of the '{@link #getTimerPorts() <em>Timer Ports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimerPorts()
   * @generated
   * @ordered
   */
  protected EList<TimerPort> timerPorts;

  /**
   * The cached value of the '{@link #getLogPorts() <em>Log Ports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLogPorts()
   * @generated
   * @ordered
   */
  protected EList<LogPort> logPorts;

  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<Attribute> attributes;

  /**
   * The cached value of the '{@link #getCapsuleRefs() <em>Capsule Refs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCapsuleRefs()
   * @generated
   * @ordered
   */
  protected EList<CapsuleRef> capsuleRefs;

  /**
   * The cached value of the '{@link #getConnectors() <em>Connectors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConnectors()
   * @generated
   * @ordered
   */
  protected EList<Connector> connectors;

  /**
   * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperations()
   * @generated
   * @ordered
   */
  protected EList<Operation> operations;

  /**
   * The cached value of the '{@link #getStatemachines() <em>Statemachines</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatemachines()
   * @generated
   * @ordered
   */
  protected EList<StateMachine> statemachines;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CapsuleImpl()
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
    return UrmlPackage.Literals.CAPSULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isRoot()
  {
    return root;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRoot(boolean newRoot)
  {
    boolean oldRoot = root;
    root = newRoot;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.CAPSULE__ROOT, oldRoot, root));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.CAPSULE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Port> getInterfacePorts()
  {
    if (interfacePorts == null)
    {
      interfacePorts = new EObjectContainmentEList<Port>(Port.class, this, UrmlPackage.CAPSULE__INTERFACE_PORTS);
    }
    return interfacePorts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Port> getInternalPorts()
  {
    if (internalPorts == null)
    {
      internalPorts = new EObjectContainmentEList<Port>(Port.class, this, UrmlPackage.CAPSULE__INTERNAL_PORTS);
    }
    return internalPorts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TimerPort> getTimerPorts()
  {
    if (timerPorts == null)
    {
      timerPorts = new EObjectContainmentEList<TimerPort>(TimerPort.class, this, UrmlPackage.CAPSULE__TIMER_PORTS);
    }
    return timerPorts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LogPort> getLogPorts()
  {
    if (logPorts == null)
    {
      logPorts = new EObjectContainmentEList<LogPort>(LogPort.class, this, UrmlPackage.CAPSULE__LOG_PORTS);
    }
    return logPorts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Attribute> getAttributes()
  {
    if (attributes == null)
    {
      attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, UrmlPackage.CAPSULE__ATTRIBUTES);
    }
    return attributes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<CapsuleRef> getCapsuleRefs()
  {
    if (capsuleRefs == null)
    {
      capsuleRefs = new EObjectContainmentEList<CapsuleRef>(CapsuleRef.class, this, UrmlPackage.CAPSULE__CAPSULE_REFS);
    }
    return capsuleRefs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Connector> getConnectors()
  {
    if (connectors == null)
    {
      connectors = new EObjectContainmentEList<Connector>(Connector.class, this, UrmlPackage.CAPSULE__CONNECTORS);
    }
    return connectors;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Operation> getOperations()
  {
    if (operations == null)
    {
      operations = new EObjectContainmentEList<Operation>(Operation.class, this, UrmlPackage.CAPSULE__OPERATIONS);
    }
    return operations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StateMachine> getStatemachines()
  {
    if (statemachines == null)
    {
      statemachines = new EObjectContainmentEList<StateMachine>(StateMachine.class, this, UrmlPackage.CAPSULE__STATEMACHINES);
    }
    return statemachines;
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
      case UrmlPackage.CAPSULE__INTERFACE_PORTS:
        return ((InternalEList<?>)getInterfacePorts()).basicRemove(otherEnd, msgs);
      case UrmlPackage.CAPSULE__INTERNAL_PORTS:
        return ((InternalEList<?>)getInternalPorts()).basicRemove(otherEnd, msgs);
      case UrmlPackage.CAPSULE__TIMER_PORTS:
        return ((InternalEList<?>)getTimerPorts()).basicRemove(otherEnd, msgs);
      case UrmlPackage.CAPSULE__LOG_PORTS:
        return ((InternalEList<?>)getLogPorts()).basicRemove(otherEnd, msgs);
      case UrmlPackage.CAPSULE__ATTRIBUTES:
        return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
      case UrmlPackage.CAPSULE__CAPSULE_REFS:
        return ((InternalEList<?>)getCapsuleRefs()).basicRemove(otherEnd, msgs);
      case UrmlPackage.CAPSULE__CONNECTORS:
        return ((InternalEList<?>)getConnectors()).basicRemove(otherEnd, msgs);
      case UrmlPackage.CAPSULE__OPERATIONS:
        return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
      case UrmlPackage.CAPSULE__STATEMACHINES:
        return ((InternalEList<?>)getStatemachines()).basicRemove(otherEnd, msgs);
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
      case UrmlPackage.CAPSULE__ROOT:
        return isRoot();
      case UrmlPackage.CAPSULE__NAME:
        return getName();
      case UrmlPackage.CAPSULE__INTERFACE_PORTS:
        return getInterfacePorts();
      case UrmlPackage.CAPSULE__INTERNAL_PORTS:
        return getInternalPorts();
      case UrmlPackage.CAPSULE__TIMER_PORTS:
        return getTimerPorts();
      case UrmlPackage.CAPSULE__LOG_PORTS:
        return getLogPorts();
      case UrmlPackage.CAPSULE__ATTRIBUTES:
        return getAttributes();
      case UrmlPackage.CAPSULE__CAPSULE_REFS:
        return getCapsuleRefs();
      case UrmlPackage.CAPSULE__CONNECTORS:
        return getConnectors();
      case UrmlPackage.CAPSULE__OPERATIONS:
        return getOperations();
      case UrmlPackage.CAPSULE__STATEMACHINES:
        return getStatemachines();
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
      case UrmlPackage.CAPSULE__ROOT:
        setRoot((Boolean)newValue);
        return;
      case UrmlPackage.CAPSULE__NAME:
        setName((String)newValue);
        return;
      case UrmlPackage.CAPSULE__INTERFACE_PORTS:
        getInterfacePorts().clear();
        getInterfacePorts().addAll((Collection<? extends Port>)newValue);
        return;
      case UrmlPackage.CAPSULE__INTERNAL_PORTS:
        getInternalPorts().clear();
        getInternalPorts().addAll((Collection<? extends Port>)newValue);
        return;
      case UrmlPackage.CAPSULE__TIMER_PORTS:
        getTimerPorts().clear();
        getTimerPorts().addAll((Collection<? extends TimerPort>)newValue);
        return;
      case UrmlPackage.CAPSULE__LOG_PORTS:
        getLogPorts().clear();
        getLogPorts().addAll((Collection<? extends LogPort>)newValue);
        return;
      case UrmlPackage.CAPSULE__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends Attribute>)newValue);
        return;
      case UrmlPackage.CAPSULE__CAPSULE_REFS:
        getCapsuleRefs().clear();
        getCapsuleRefs().addAll((Collection<? extends CapsuleRef>)newValue);
        return;
      case UrmlPackage.CAPSULE__CONNECTORS:
        getConnectors().clear();
        getConnectors().addAll((Collection<? extends Connector>)newValue);
        return;
      case UrmlPackage.CAPSULE__OPERATIONS:
        getOperations().clear();
        getOperations().addAll((Collection<? extends Operation>)newValue);
        return;
      case UrmlPackage.CAPSULE__STATEMACHINES:
        getStatemachines().clear();
        getStatemachines().addAll((Collection<? extends StateMachine>)newValue);
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
      case UrmlPackage.CAPSULE__ROOT:
        setRoot(ROOT_EDEFAULT);
        return;
      case UrmlPackage.CAPSULE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case UrmlPackage.CAPSULE__INTERFACE_PORTS:
        getInterfacePorts().clear();
        return;
      case UrmlPackage.CAPSULE__INTERNAL_PORTS:
        getInternalPorts().clear();
        return;
      case UrmlPackage.CAPSULE__TIMER_PORTS:
        getTimerPorts().clear();
        return;
      case UrmlPackage.CAPSULE__LOG_PORTS:
        getLogPorts().clear();
        return;
      case UrmlPackage.CAPSULE__ATTRIBUTES:
        getAttributes().clear();
        return;
      case UrmlPackage.CAPSULE__CAPSULE_REFS:
        getCapsuleRefs().clear();
        return;
      case UrmlPackage.CAPSULE__CONNECTORS:
        getConnectors().clear();
        return;
      case UrmlPackage.CAPSULE__OPERATIONS:
        getOperations().clear();
        return;
      case UrmlPackage.CAPSULE__STATEMACHINES:
        getStatemachines().clear();
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
      case UrmlPackage.CAPSULE__ROOT:
        return root != ROOT_EDEFAULT;
      case UrmlPackage.CAPSULE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case UrmlPackage.CAPSULE__INTERFACE_PORTS:
        return interfacePorts != null && !interfacePorts.isEmpty();
      case UrmlPackage.CAPSULE__INTERNAL_PORTS:
        return internalPorts != null && !internalPorts.isEmpty();
      case UrmlPackage.CAPSULE__TIMER_PORTS:
        return timerPorts != null && !timerPorts.isEmpty();
      case UrmlPackage.CAPSULE__LOG_PORTS:
        return logPorts != null && !logPorts.isEmpty();
      case UrmlPackage.CAPSULE__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
      case UrmlPackage.CAPSULE__CAPSULE_REFS:
        return capsuleRefs != null && !capsuleRefs.isEmpty();
      case UrmlPackage.CAPSULE__CONNECTORS:
        return connectors != null && !connectors.isEmpty();
      case UrmlPackage.CAPSULE__OPERATIONS:
        return operations != null && !operations.isEmpty();
      case UrmlPackage.CAPSULE__STATEMACHINES:
        return statemachines != null && !statemachines.isEmpty();
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
    result.append(" (root: ");
    result.append(root);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //CapsuleImpl
