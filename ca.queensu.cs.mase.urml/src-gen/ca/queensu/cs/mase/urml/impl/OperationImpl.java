/**
 */
package ca.queensu.cs.mase.urml.impl;

import ca.queensu.cs.mase.urml.LocalVar;
import ca.queensu.cs.mase.urml.Operation;
import ca.queensu.cs.mase.urml.OperationCode;
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
 * An implementation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.OperationImpl#isIsBool <em>Is Bool</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.OperationImpl#isIsInt <em>Is Int</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.OperationImpl#isIsVoid <em>Is Void</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.OperationImpl#getName <em>Name</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.OperationImpl#getLocalVars <em>Local Vars</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.OperationImpl#getOperationCode <em>Operation Code</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationImpl extends MinimalEObjectImpl.Container implements Operation
{
  /**
   * The default value of the '{@link #isIsBool() <em>Is Bool</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsBool()
   * @generated
   * @ordered
   */
  protected static final boolean IS_BOOL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsBool() <em>Is Bool</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsBool()
   * @generated
   * @ordered
   */
  protected boolean isBool = IS_BOOL_EDEFAULT;

  /**
   * The default value of the '{@link #isIsInt() <em>Is Int</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsInt()
   * @generated
   * @ordered
   */
  protected static final boolean IS_INT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsInt() <em>Is Int</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsInt()
   * @generated
   * @ordered
   */
  protected boolean isInt = IS_INT_EDEFAULT;

  /**
   * The default value of the '{@link #isIsVoid() <em>Is Void</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsVoid()
   * @generated
   * @ordered
   */
  protected static final boolean IS_VOID_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsVoid() <em>Is Void</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsVoid()
   * @generated
   * @ordered
   */
  protected boolean isVoid = IS_VOID_EDEFAULT;

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
   * The cached value of the '{@link #getLocalVars() <em>Local Vars</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocalVars()
   * @generated
   * @ordered
   */
  protected EList<LocalVar> localVars;

  /**
   * The cached value of the '{@link #getOperationCode() <em>Operation Code</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperationCode()
   * @generated
   * @ordered
   */
  protected OperationCode operationCode;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OperationImpl()
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
    return UrmlPackage.Literals.OPERATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsBool()
  {
    return isBool;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsBool(boolean newIsBool)
  {
    boolean oldIsBool = isBool;
    isBool = newIsBool;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.OPERATION__IS_BOOL, oldIsBool, isBool));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsInt()
  {
    return isInt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsInt(boolean newIsInt)
  {
    boolean oldIsInt = isInt;
    isInt = newIsInt;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.OPERATION__IS_INT, oldIsInt, isInt));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsVoid()
  {
    return isVoid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsVoid(boolean newIsVoid)
  {
    boolean oldIsVoid = isVoid;
    isVoid = newIsVoid;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.OPERATION__IS_VOID, oldIsVoid, isVoid));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.OPERATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LocalVar> getLocalVars()
  {
    if (localVars == null)
    {
      localVars = new EObjectContainmentEList<LocalVar>(LocalVar.class, this, UrmlPackage.OPERATION__LOCAL_VARS);
    }
    return localVars;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationCode getOperationCode()
  {
    return operationCode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOperationCode(OperationCode newOperationCode, NotificationChain msgs)
  {
    OperationCode oldOperationCode = operationCode;
    operationCode = newOperationCode;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UrmlPackage.OPERATION__OPERATION_CODE, oldOperationCode, newOperationCode);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperationCode(OperationCode newOperationCode)
  {
    if (newOperationCode != operationCode)
    {
      NotificationChain msgs = null;
      if (operationCode != null)
        msgs = ((InternalEObject)operationCode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UrmlPackage.OPERATION__OPERATION_CODE, null, msgs);
      if (newOperationCode != null)
        msgs = ((InternalEObject)newOperationCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UrmlPackage.OPERATION__OPERATION_CODE, null, msgs);
      msgs = basicSetOperationCode(newOperationCode, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.OPERATION__OPERATION_CODE, newOperationCode, newOperationCode));
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
      case UrmlPackage.OPERATION__LOCAL_VARS:
        return ((InternalEList<?>)getLocalVars()).basicRemove(otherEnd, msgs);
      case UrmlPackage.OPERATION__OPERATION_CODE:
        return basicSetOperationCode(null, msgs);
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
      case UrmlPackage.OPERATION__IS_BOOL:
        return isIsBool();
      case UrmlPackage.OPERATION__IS_INT:
        return isIsInt();
      case UrmlPackage.OPERATION__IS_VOID:
        return isIsVoid();
      case UrmlPackage.OPERATION__NAME:
        return getName();
      case UrmlPackage.OPERATION__LOCAL_VARS:
        return getLocalVars();
      case UrmlPackage.OPERATION__OPERATION_CODE:
        return getOperationCode();
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
      case UrmlPackage.OPERATION__IS_BOOL:
        setIsBool((Boolean)newValue);
        return;
      case UrmlPackage.OPERATION__IS_INT:
        setIsInt((Boolean)newValue);
        return;
      case UrmlPackage.OPERATION__IS_VOID:
        setIsVoid((Boolean)newValue);
        return;
      case UrmlPackage.OPERATION__NAME:
        setName((String)newValue);
        return;
      case UrmlPackage.OPERATION__LOCAL_VARS:
        getLocalVars().clear();
        getLocalVars().addAll((Collection<? extends LocalVar>)newValue);
        return;
      case UrmlPackage.OPERATION__OPERATION_CODE:
        setOperationCode((OperationCode)newValue);
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
      case UrmlPackage.OPERATION__IS_BOOL:
        setIsBool(IS_BOOL_EDEFAULT);
        return;
      case UrmlPackage.OPERATION__IS_INT:
        setIsInt(IS_INT_EDEFAULT);
        return;
      case UrmlPackage.OPERATION__IS_VOID:
        setIsVoid(IS_VOID_EDEFAULT);
        return;
      case UrmlPackage.OPERATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case UrmlPackage.OPERATION__LOCAL_VARS:
        getLocalVars().clear();
        return;
      case UrmlPackage.OPERATION__OPERATION_CODE:
        setOperationCode((OperationCode)null);
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
      case UrmlPackage.OPERATION__IS_BOOL:
        return isBool != IS_BOOL_EDEFAULT;
      case UrmlPackage.OPERATION__IS_INT:
        return isInt != IS_INT_EDEFAULT;
      case UrmlPackage.OPERATION__IS_VOID:
        return isVoid != IS_VOID_EDEFAULT;
      case UrmlPackage.OPERATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case UrmlPackage.OPERATION__LOCAL_VARS:
        return localVars != null && !localVars.isEmpty();
      case UrmlPackage.OPERATION__OPERATION_CODE:
        return operationCode != null;
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
    result.append(" (isBool: ");
    result.append(isBool);
    result.append(", isInt: ");
    result.append(isInt);
    result.append(", isVoid: ");
    result.append(isVoid);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //OperationImpl
