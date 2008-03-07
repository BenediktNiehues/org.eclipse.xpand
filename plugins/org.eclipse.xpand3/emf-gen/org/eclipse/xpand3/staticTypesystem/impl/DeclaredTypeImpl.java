/**
 * <copyright>
 * </copyright>
 *
 * $Id: DeclaredTypeImpl.java,v 1.5 2008/03/07 14:21:07 sefftinge Exp $
 */
package org.eclipse.xpand3.staticTypesystem.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xpand3.staticTypesystem.AbstractTypeReference;
import org.eclipse.xpand3.staticTypesystem.DeclaredProperty;
import org.eclipse.xpand3.staticTypesystem.DeclaredStaticProperty;
import org.eclipse.xpand3.staticTypesystem.DeclaredType;
import org.eclipse.xpand3.staticTypesystem.DeclaredTypeParameter;
import org.eclipse.xpand3.staticTypesystem.StaticTypesystemPackage;

import org.eclipse.xtend.backend.common.BackendType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declared Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xpand3.staticTypesystem.impl.DeclaredTypeImpl#getStaticProperties <em>Static Properties</em>}</li>
 *   <li>{@link org.eclipse.xpand3.staticTypesystem.impl.DeclaredTypeImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.xpand3.staticTypesystem.impl.DeclaredTypeImpl#getDeclaredTypeParameters <em>Declared Type Parameters</em>}</li>
 *   <li>{@link org.eclipse.xpand3.staticTypesystem.impl.DeclaredTypeImpl#getSuperTypes <em>Super Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeclaredTypeImpl extends AbstractNamedElementImpl implements DeclaredType {
	/**
	 * The cached value of the '{@link #getStaticProperties() <em>Static Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStaticProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<DeclaredStaticProperty> staticProperties;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<DeclaredProperty> properties;

	/**
	 * The cached value of the '{@link #getDeclaredTypeParameters() <em>Declared Type Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaredTypeParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<DeclaredTypeParameter> declaredTypeParameters;

	/**
	 * The cached value of the '{@link #getSuperTypes() <em>Super Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractTypeReference> superTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeclaredTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StaticTypesystemPackage.Literals.DECLARED_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DeclaredStaticProperty> getStaticProperties() {
		if (staticProperties == null) {
			staticProperties = new EObjectContainmentEList<DeclaredStaticProperty>(DeclaredStaticProperty.class, this, StaticTypesystemPackage.DECLARED_TYPE__STATIC_PROPERTIES);
		}
		return staticProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DeclaredProperty> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<DeclaredProperty>(DeclaredProperty.class, this, StaticTypesystemPackage.DECLARED_TYPE__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DeclaredTypeParameter> getDeclaredTypeParameters() {
		if (declaredTypeParameters == null) {
			declaredTypeParameters = new EObjectContainmentEList<DeclaredTypeParameter>(DeclaredTypeParameter.class, this, StaticTypesystemPackage.DECLARED_TYPE__DECLARED_TYPE_PARAMETERS);
		}
		return declaredTypeParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractTypeReference> getSuperTypes() {
		if (superTypes == null) {
			superTypes = new EObjectContainmentEList<AbstractTypeReference>(AbstractTypeReference.class, this, StaticTypesystemPackage.DECLARED_TYPE__SUPER_TYPES);
		}
		return superTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StaticTypesystemPackage.DECLARED_TYPE__STATIC_PROPERTIES:
				return ((InternalEList<?>)getStaticProperties()).basicRemove(otherEnd, msgs);
			case StaticTypesystemPackage.DECLARED_TYPE__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case StaticTypesystemPackage.DECLARED_TYPE__DECLARED_TYPE_PARAMETERS:
				return ((InternalEList<?>)getDeclaredTypeParameters()).basicRemove(otherEnd, msgs);
			case StaticTypesystemPackage.DECLARED_TYPE__SUPER_TYPES:
				return ((InternalEList<?>)getSuperTypes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StaticTypesystemPackage.DECLARED_TYPE__STATIC_PROPERTIES:
				return getStaticProperties();
			case StaticTypesystemPackage.DECLARED_TYPE__PROPERTIES:
				return getProperties();
			case StaticTypesystemPackage.DECLARED_TYPE__DECLARED_TYPE_PARAMETERS:
				return getDeclaredTypeParameters();
			case StaticTypesystemPackage.DECLARED_TYPE__SUPER_TYPES:
				return getSuperTypes();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StaticTypesystemPackage.DECLARED_TYPE__STATIC_PROPERTIES:
				getStaticProperties().clear();
				getStaticProperties().addAll((Collection<? extends DeclaredStaticProperty>)newValue);
				return;
			case StaticTypesystemPackage.DECLARED_TYPE__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends DeclaredProperty>)newValue);
				return;
			case StaticTypesystemPackage.DECLARED_TYPE__DECLARED_TYPE_PARAMETERS:
				getDeclaredTypeParameters().clear();
				getDeclaredTypeParameters().addAll((Collection<? extends DeclaredTypeParameter>)newValue);
				return;
			case StaticTypesystemPackage.DECLARED_TYPE__SUPER_TYPES:
				getSuperTypes().clear();
				getSuperTypes().addAll((Collection<? extends AbstractTypeReference>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case StaticTypesystemPackage.DECLARED_TYPE__STATIC_PROPERTIES:
				getStaticProperties().clear();
				return;
			case StaticTypesystemPackage.DECLARED_TYPE__PROPERTIES:
				getProperties().clear();
				return;
			case StaticTypesystemPackage.DECLARED_TYPE__DECLARED_TYPE_PARAMETERS:
				getDeclaredTypeParameters().clear();
				return;
			case StaticTypesystemPackage.DECLARED_TYPE__SUPER_TYPES:
				getSuperTypes().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StaticTypesystemPackage.DECLARED_TYPE__STATIC_PROPERTIES:
				return staticProperties != null && !staticProperties.isEmpty();
			case StaticTypesystemPackage.DECLARED_TYPE__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case StaticTypesystemPackage.DECLARED_TYPE__DECLARED_TYPE_PARAMETERS:
				return declaredTypeParameters != null && !declaredTypeParameters.isEmpty();
			case StaticTypesystemPackage.DECLARED_TYPE__SUPER_TYPES:
				return superTypes != null && !superTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DeclaredTypeImpl
