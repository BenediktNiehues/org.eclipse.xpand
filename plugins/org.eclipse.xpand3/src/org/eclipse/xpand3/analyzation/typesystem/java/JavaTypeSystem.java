/**
 * <copyright> 
 *
 * Copyright (c) 2002-2007 itemis AG and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   itemis AG - Initial API and implementation
 *
 * </copyright>
 *
 */
package org.eclipse.xpand3.analyzation.typesystem.java;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xpand3.analyzation.GenericsUtil;
import org.eclipse.xpand3.analyzation.TypeSystem;
import org.eclipse.xpand3.analyzation.TypeSystemFactory;
import org.eclipse.xpand3.staticTypesystem.AbstractTypeReference;
import org.eclipse.xpand3.staticTypesystem.DeclaredFunction;
import org.eclipse.xpand3.staticTypesystem.DeclaredProperty;
import org.eclipse.xpand3.staticTypesystem.DeclaredStaticProperty;
import org.eclipse.xpand3.staticTypesystem.DeclaredType;
import org.eclipse.xpand3.staticTypesystem.DeclaredTypeParameter;
import org.eclipse.xpand3.staticTypesystem.StaticTypesystemFactory;
import org.eclipse.xpand3.staticTypesystem.Type;
import org.eclipse.xpand3.util.CreateCache;
import org.eclipse.xtend.backend.util.ErrorHandler;
import org.eclipse.xtend.middleend.javaannotations.M2tNoFunction;

/**
 * @author Sven Efftinge
 * 
 */
public class JavaTypeSystem implements TypeSystem {

	private CreateCache<String, DeclaredType> types = new CreateCache<String, DeclaredType>() {

		@Override
		protected DeclaredType create(String key) {
			if (key.equals(cls.getSimpleName())) {
				return StaticTypesystemFactory.eINSTANCE.createDeclaredType();
			}
			return null;
		}

		@Override
		protected void initialize(String key, DeclaredType value) {
			initializeDeclaredType(value, key);
		}

	};

	private TypeSystemFactory typeSystemFactory = null;
	private Class<?> cls;

	/**
	 * 
	 */
	public JavaTypeSystem(Class<?> javaClass) {
		if (javaClass == null) {
			throw new IllegalArgumentException("javaClass");
		}
		this.cls = javaClass;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xand3.analyzation.typesystem.Xpand3DeclarationsResource#setTypeSystem(org.eclipse.xand3.analyzation.TypeSystem)
	 */
	public void setTypeSystemFactory(TypeSystemFactory tsf) {
		this.typeSystemFactory = tsf;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xand3.analyzation.typesystem.DeclarationsContributor#typeForName(java.lang.String)
	 */
	public DeclaredType typeForName(String name) {
		return types.get(name);
	}

	/**
	 * @param name
	 * @return
	 */
	private DeclaredType initializeDeclaredType(DeclaredType dt, String name) {
		dt.setName(name);
		TypeVariable<?>[] typeParameters = cls.getTypeParameters();
		for (TypeVariable<?> typeVariable : typeParameters) {
			DeclaredTypeParameter dtp = StaticTypesystemFactory.eINSTANCE
					.createDeclaredTypeParameter();
			dtp.setName(typeVariable.getName());
			dtp.getUpperBounds().addAll(toTypeRefs(typeVariable.getBounds()));
			dt.getDeclaredTypeParameters().add(dtp);
		}

		// supertypes
		if (cls.getGenericSuperclass() != null && !cls.getSuperclass().equals(Object.class))
			dt.getSuperTypes().add(toTypeRef(cls.getGenericSuperclass()));
		dt.getSuperTypes().addAll(toTypeRefs(cls.getGenericInterfaces()));
		if (dt.getSuperTypes().isEmpty()) {
			DeclaredType objectType = typeSystemFactory.getBuiltInTypeSystem()
					.typeForName(TypeSystem.OBJECT);
			dt.getSuperTypes().add(GenericsUtil.typeRef(objectType));
		}

		// properties
		try {
			PropertyDescriptor[] propertyDescriptors = Introspector
					.getBeanInfo(cls).getPropertyDescriptors();
			for (PropertyDescriptor pd : propertyDescriptors) {
				if (getDeclaringClass(pd) != cls)
					continue;
				DeclaredProperty dp = StaticTypesystemFactory.eINSTANCE
						.createDeclaredProperty();
				dp.setName(pd.getName());
				dp.setType(toTypeRef(getGenericType(pd)));
				dt.getProperties().add(dp);
			}
		} catch (IntrospectionException e) {
			ErrorHandler.handle(e);
			return null;
		}

		// static properties
		Field[] fields = cls.getFields();
		for (Field field : fields) {
			if (Modifier.isPublic(field.getModifiers())) {
				if (Modifier.isStatic(field.getModifiers())) {
					DeclaredStaticProperty dsp = StaticTypesystemFactory.eINSTANCE
							.createDeclaredStaticProperty();
					dsp.setName(field.getName());
					dsp.setType((Type) toTypeRef(field.getGenericType()));
					dt.getStaticProperties().add(dsp);
				} else {
					// DeclaredProperty dp = StaticTypesystemFactory.eINSTANCE
					// .createDeclaredProperty();
					// dp.setName(field.getName());
					// dp.setType(toTypeRef(field.getGenericType()));
					// dt.getProperties().add(dp);
				}
			}
		}
		return dt;
	}

	/**
	 * @param pd
	 * @return
	 */
	private java.lang.reflect.Type getGenericType(PropertyDescriptor pd) {
		if (pd.getReadMethod() != null)
			return pd.getReadMethod().getGenericReturnType();

		return pd.getWriteMethod().getGenericParameterTypes()[0];
	}

	private Class<?> getDeclaringClass(PropertyDescriptor pd) {
		if (pd.getReadMethod() != null)
			return pd.getReadMethod().getDeclaringClass();

		return pd.getWriteMethod().getDeclaringClass();
	}

	/**
	 * @param bounds
	 * @return
	 */
	private List<? extends AbstractTypeReference> toTypeRefs(
			java.lang.reflect.Type[] bounds) {
		List<AbstractTypeReference> result = new ArrayList<AbstractTypeReference>();
		for (java.lang.reflect.Type jt : bounds) {
			result.add(toTypeRef(jt));
		}
		return result;
	}

	/**
	 * @param genericSuperclass
	 * @return
	 */
	private AbstractTypeReference toTypeRef(java.lang.reflect.Type type) {
		if (type instanceof Class<?>) {
			Class<?> c = (Class<?>) type;
			DeclaredType dt = typeSystemFactory.getBuiltInTypeSystem()
					.getBuiltinTypeForJavaClass((Class<?>) type);
			if (dt != null) {
				DeclaredType declaredType = typeSystemFactory
						.getBuiltInTypeSystem().typeForName(dt.getName());
				return GenericsUtil.typeRef(declaredType);
			}
			TypeSystem typeSystem = typeSystemFactory
					.getTypeSystem(c.getName());
			DeclaredType declaredType = typeSystem.typeForName(c
					.getSimpleName());
			return GenericsUtil.typeRef(declaredType);
		} else if (type instanceof TypeVariable) {
			TypeVariable<?> tv = (TypeVariable<?>) type;
			Object genericDeclaration = tv.getGenericDeclaration();
			if (genericDeclaration instanceof Class) {
				Class<?> c = (Class<?>) genericDeclaration;
				DeclaredType dt = getDeclaredTypeForJClass(c);
				EList<DeclaredTypeParameter> parameters = dt
						.getDeclaredTypeParameters();
				for (DeclaredTypeParameter declaredTypeParameter : parameters) {
					if (declaredTypeParameter.getName().equals(tv.getName())) {
						org.eclipse.xpand3.staticTypesystem.TypeVariable newTv = StaticTypesystemFactory.eINSTANCE
								.createTypeVariable();
						newTv.setDeclaredTypeParameter(declaredTypeParameter);
						return newTv;
					}
				}
			}
			throw new IllegalStateException(
					"Couldn't find declaration for type variable "
							+ tv.getName());
		} else if (type instanceof java.lang.reflect.ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) type;
			java.lang.reflect.Type rawType = pt.getRawType();
			Type t = StaticTypesystemFactory.eINSTANCE.createType();
			if (rawType instanceof Class) {
				DeclaredType dt = getDeclaredTypeForJClass((Class<?>) rawType);
				t.setDeclaredType(dt);
			} else {
				throw new IllegalStateException("missing implementation for "
						+ rawType.getClass());
			}
			t.getActualTypeArguments().addAll(
					toTypeRefs(pt.getActualTypeArguments()));
			return t;
		}
		throw new IllegalArgumentException("toTypeRef not implemented for "
				+ type.getClass().getSimpleName() + " - " + type);
	}

	/**
	 * @param c
	 * @return
	 */
	private DeclaredType getDeclaredTypeForJClass(Class<?> c) {
		DeclaredType declaredType = typeSystemFactory.getBuiltInTypeSystem()
				.getBuiltinTypeForJavaClass(c);
		if (declaredType != null) {
			return declaredType;
		}
		return typeSystemFactory.getTypeSystem(c.getName()).typeForName(
				c.getSimpleName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xand3.analyzation.typesystem.DeclarationsContributor#functionForName(java.lang.String,
	 *      org.eclipse.xpand3.staticTypesystem.AbstractTypeReference[])
	 */
	public DeclaredFunction functionForName(String name,
			AbstractTypeReference... parameterTypes) {
		Method[] methods = cls.getDeclaredMethods();
		for (Method method : methods) {
			if (method.getAnnotation(M2tNoFunction.class) == null) {
				DeclaredFunction f = StaticTypesystemFactory.eINSTANCE
						.createDeclaredFunction();
				f.setName(method.getName());
				// parameters
				if (!Modifier.isStatic(method.getModifiers())) {
					org.eclipse.xpand3.staticTypesystem.DeclaredParameter dp = StaticTypesystemFactory.eINSTANCE
							.createDeclaredParameter();
					dp.setName("this");
					dp.setType(toTypeRef(method.getDeclaringClass()));
					f.getDeclaredParameters().add(dp);
				}
				f.setReturnType(toTypeRef(method.getGenericReturnType()));
			}
		}
		return null;
	}

}
