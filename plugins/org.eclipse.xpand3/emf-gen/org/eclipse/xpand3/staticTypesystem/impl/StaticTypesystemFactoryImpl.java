/**
 * <copyright>
 * </copyright>
 *
 * $Id: StaticTypesystemFactoryImpl.java,v 1.3 2008/03/04 14:03:38 sefftinge Exp $
 */
package org.eclipse.xpand3.staticTypesystem.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xpand3.staticTypesystem.*;

import org.eclipse.xtend.backend.common.BackendType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StaticTypesystemFactoryImpl extends EFactoryImpl implements StaticTypesystemFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StaticTypesystemFactory init() {
		try {
			StaticTypesystemFactory theStaticTypesystemFactory = (StaticTypesystemFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/m2t/xpand3/staticTypesystem"); 
			if (theStaticTypesystemFactory != null) {
				return theStaticTypesystemFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StaticTypesystemFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticTypesystemFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case StaticTypesystemPackage.TYPE: return createType();
			case StaticTypesystemPackage.TYPE_VARIABLE: return createTypeVariable();
			case StaticTypesystemPackage.VOID_TYPE: return createVoidType();
			case StaticTypesystemPackage.WILDCARD_TYPE: return createWildcardType();
			case StaticTypesystemPackage.FUNCTION_TYPE: return createFunctionType();
			case StaticTypesystemPackage.DECLARED_TYPE: return createDeclaredType();
			case StaticTypesystemPackage.DECLARED_OPERATION: return createDeclaredOperation();
			case StaticTypesystemPackage.DECLARED_FUNCTION: return createDeclaredFunction();
			case StaticTypesystemPackage.DECLARED_PROPERTY: return createDeclaredProperty();
			case StaticTypesystemPackage.DECLARED_STATIC_PROPERTY: return createDeclaredStaticProperty();
			case StaticTypesystemPackage.DECLARED_TYPE_PARAMETER: return createDeclaredTypeParameter();
			case StaticTypesystemPackage.DECLARED_PARAMETER: return createDeclaredParameter();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case StaticTypesystemPackage.BACKEND_TYPE:
				return createBackendTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case StaticTypesystemPackage.BACKEND_TYPE:
				return convertBackendTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type createType() {
		TypeImpl type = new TypeImpl();
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeVariable createTypeVariable() {
		TypeVariableImpl typeVariable = new TypeVariableImpl();
		return typeVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VoidType createVoidType() {
		VoidTypeImpl voidType = new VoidTypeImpl();
		return voidType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WildcardType createWildcardType() {
		WildcardTypeImpl wildcardType = new WildcardTypeImpl();
		return wildcardType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionType createFunctionType() {
		FunctionTypeImpl functionType = new FunctionTypeImpl();
		return functionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclaredType createDeclaredType() {
		DeclaredTypeImpl declaredType = new DeclaredTypeImpl();
		return declaredType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclaredOperation createDeclaredOperation() {
		DeclaredOperationImpl declaredOperation = new DeclaredOperationImpl();
		return declaredOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclaredFunction createDeclaredFunction() {
		DeclaredFunctionImpl declaredFunction = new DeclaredFunctionImpl();
		return declaredFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclaredProperty createDeclaredProperty() {
		DeclaredPropertyImpl declaredProperty = new DeclaredPropertyImpl();
		return declaredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclaredStaticProperty createDeclaredStaticProperty() {
		DeclaredStaticPropertyImpl declaredStaticProperty = new DeclaredStaticPropertyImpl();
		return declaredStaticProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclaredTypeParameter createDeclaredTypeParameter() {
		DeclaredTypeParameterImpl declaredTypeParameter = new DeclaredTypeParameterImpl();
		return declaredTypeParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclaredParameter createDeclaredParameter() {
		DeclaredParameterImpl declaredParameter = new DeclaredParameterImpl();
		return declaredParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BackendType createBackendTypeFromString(EDataType eDataType, String initialValue) {
		return (BackendType)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBackendTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticTypesystemPackage getStaticTypesystemPackage() {
		return (StaticTypesystemPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StaticTypesystemPackage getPackage() {
		return StaticTypesystemPackage.eINSTANCE;
	}

} //StaticTypesystemFactoryImpl
