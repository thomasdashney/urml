/**
 */
package ca.queensu.cs.mase.urml.impl;

import ca.queensu.cs.mase.urml.Identifiable;
import ca.queensu.cs.mase.urml.UrmlPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Identifiable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.IdentifiableImpl#isIsBool <em>Is Bool</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.IdentifiableImpl#isIsInt <em>Is Int</em>}</li>
 *   <li>{@link ca.queensu.cs.mase.urml.impl.IdentifiableImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IdentifiableImpl extends MinimalEObjectImpl.Container implements Identifiable
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IdentifiableImpl()
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
    return UrmlPackage.Literals.IDENTIFIABLE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.IDENTIFIABLE__IS_BOOL, oldIsBool, isBool));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.IDENTIFIABLE__IS_INT, oldIsInt, isInt));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UrmlPackage.IDENTIFIABLE__NAME, oldName, name));
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
      case UrmlPackage.IDENTIFIABLE__IS_BOOL:
        return isIsBool();
      case UrmlPackage.IDENTIFIABLE__IS_INT:
        return isIsInt();
      case UrmlPackage.IDENTIFIABLE__NAME:
        return getName();
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
      case UrmlPackage.IDENTIFIABLE__IS_BOOL:
        setIsBool((Boolean)newValue);
        return;
      case UrmlPackage.IDENTIFIABLE__IS_INT:
        setIsInt((Boolean)newValue);
        return;
      case UrmlPackage.IDENTIFIABLE__NAME:
        setName((String)newValue);
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
      case UrmlPackage.IDENTIFIABLE__IS_BOOL:
        setIsBool(IS_BOOL_EDEFAULT);
        return;
      case UrmlPackage.IDENTIFIABLE__IS_INT:
        setIsInt(IS_INT_EDEFAULT);
        return;
      case UrmlPackage.IDENTIFIABLE__NAME:
        setName(NAME_EDEFAULT);
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
      case UrmlPackage.IDENTIFIABLE__IS_BOOL:
        return isBool != IS_BOOL_EDEFAULT;
      case UrmlPackage.IDENTIFIABLE__IS_INT:
        return isInt != IS_INT_EDEFAULT;
      case UrmlPackage.IDENTIFIABLE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //IdentifiableImpl
