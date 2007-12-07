/*
 * <copyright>
 *
 * Copyright (c) 2005-2007 Sven Efftinge (http://www.efftinge.de) and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge (http://www.efftinge.de) - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.internal.xtend.type.baseimpl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.internal.xtend.expression.parser.SyntaxConstants;
import org.eclipse.internal.xtend.type.baseimpl.types.BooleanTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.CollectionTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.FeatureTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.IntegerTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.ListTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.ObjectTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.OperationTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.PropertyTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.RealTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.SetTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.StaticPropertyTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.StringTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.TypeTypeImpl;
import org.eclipse.internal.xtend.type.baseimpl.types.VoidType;
import org.eclipse.internal.xtend.util.Cache;
import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.typesystem.MetaModel;
import org.eclipse.xtend.typesystem.ParameterizedType;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 */
public final class BuiltinMetaModel implements MetaModel {

	public static final String OBJECT = "Object";

	// Datatypes
	public final static String STRING = "String";

	public final static String BOOLEAN = "Boolean";

	public final static String INTEGER = "Integer";

	public final static String REAL = "Real";

	// Collection types
	public final static String COLLECTION = "Collection";

	public final static String SET = "Set";

	public final static String LIST = "List";

	// reflection layer types
	public static final String TYPE = "oaw::Type";

	public static final String FEATURE = "oaw::Feature";

	public static final String PROPERTY = "oaw::Property";

	public static final String OPERATION = "oaw::Operation";

	private static final String STATIC_PROPERTY = "oaw::StaticProperty";

	public static final String VOID = "Void";

	// singleton instances
	private Type stringType = null;

	private Type booleanType = null;

	private Type integerType = null;

	private Type realType = null;

	private Type objectType = null;

	private Type typeType = null;

	private Type featureType = null;

	private Type propertyType = null;

	private Type operationType = null;

	private Type staticPropertyType = null;

	private Type voidType = null;

	private final Map<String, Type> _builtinTypes = new HashMap<String, Type>();

	private TypeSystem typeSystem;

	public TypeSystem getTypeSystem() {
		return typeSystem;
	}

	public BuiltinMetaModel(final TypeSystem typeSystem) {
		this.typeSystem = typeSystem;

		stringType = new StringTypeImpl(getTypeSystem(), BuiltinMetaModel.STRING);

		booleanType = new BooleanTypeImpl(getTypeSystem(), BuiltinMetaModel.BOOLEAN);

		integerType = new IntegerTypeImpl(getTypeSystem(), BuiltinMetaModel.INTEGER);

		realType = new RealTypeImpl(getTypeSystem(), BuiltinMetaModel.REAL);

		objectType = new ObjectTypeImpl(getTypeSystem(), BuiltinMetaModel.OBJECT);

		typeType = new TypeTypeImpl(getTypeSystem(), BuiltinMetaModel.TYPE);

		featureType = new FeatureTypeImpl(getTypeSystem(), BuiltinMetaModel.FEATURE);

		propertyType = new PropertyTypeImpl(getTypeSystem(), BuiltinMetaModel.PROPERTY);

		staticPropertyType = new StaticPropertyTypeImpl(getTypeSystem(), BuiltinMetaModel.STATIC_PROPERTY);

		operationType = new OperationTypeImpl(getTypeSystem(), BuiltinMetaModel.OPERATION);

		voidType = new VoidType(getTypeSystem(), BuiltinMetaModel.VOID);

		_builtinTypes.put(BuiltinMetaModel.OBJECT, objectType);
		_builtinTypes.put(convert(Object.class.getName()), objectType);

		_builtinTypes.put(BuiltinMetaModel.VOID, voidType);

		_builtinTypes.put(BuiltinMetaModel.STRING, stringType);
		_builtinTypes.put(convert(String.class.getName()), stringType);
		_builtinTypes.put(convert(StringBuffer.class.getName()), stringType);
		_builtinTypes.put(Character.TYPE.getName(), stringType);
		_builtinTypes.put(convert(Character.class.getName()), stringType);

		_builtinTypes.put(BuiltinMetaModel.BOOLEAN, booleanType);
		_builtinTypes.put(Boolean.TYPE.getName(), booleanType);
		_builtinTypes.put(convert(Boolean.class.getName()), booleanType);

		_builtinTypes.put(BuiltinMetaModel.INTEGER, integerType);
		_builtinTypes.put(Integer.TYPE.getName(), integerType);
		_builtinTypes.put(convert(Integer.class.getName()), integerType);
		_builtinTypes.put(convert(Long.class.getName()), integerType);
		_builtinTypes.put(convert(Short.class.getName()), integerType);
		_builtinTypes.put(convert(Byte.class.getName()), integerType);
		_builtinTypes.put(convert(BigInteger.class.getName()), integerType);

		_builtinTypes.put(BuiltinMetaModel.REAL, realType);
		_builtinTypes.put(Double.TYPE.getName(), realType);
		_builtinTypes.put(convert(Double.class.getName()), realType);
		_builtinTypes.put(convert(Float.class.getName()), realType);
		_builtinTypes.put(convert(BigDecimal.class.getName()), realType);

		_builtinTypes.put(BuiltinMetaModel.TYPE, typeType);
		_builtinTypes.put(BuiltinMetaModel.FEATURE, featureType);
		_builtinTypes.put(BuiltinMetaModel.PROPERTY, propertyType);
		_builtinTypes.put(BuiltinMetaModel.OPERATION, operationType);
		_builtinTypes.put(BuiltinMetaModel.STATIC_PROPERTY, staticPropertyType);

		_builtinTypes.put(BuiltinMetaModel.COLLECTION, getCollectionType(objectType));
		_builtinTypes.put(Collection.class.getName(), getCollectionType(objectType));
		_builtinTypes.put(convert(Collection.class.getName()), getCollectionType(objectType));
		_builtinTypes.put(BuiltinMetaModel.SET, getSetType(objectType));
		_builtinTypes.put(Set.class.getName(), getSetType(objectType));
		_builtinTypes.put(convert(Set.class.getName()), getSetType(objectType));
		_builtinTypes.put(BuiltinMetaModel.LIST, getListType(objectType));
		_builtinTypes.put(List.class.getName(), getListType(objectType));
		_builtinTypes.put(convert(List.class.getName()), getListType(objectType));

		_knownTypes = new HashSet<Type>(_builtinTypes.values());
	}

	public String getName() {
		return "built-in";
	}

	public final Type getObjectType() {
		return objectType;
	}

	public final Type getBooleanType() {
		return booleanType;
	}

	public final Type getIntegerType() {
		return integerType;
	}

	public Type getRealType() {
		return realType;
	}

	public final Type getStringType() {
		return stringType;
	}

	public final Type getTypeType() {
		return typeType;
	}

	public final Type getFeatureType() {
		return featureType;
	}

	public final Type getPropertyType() {
		return propertyType;
	}

	public final Type getOperationType() {
		return operationType;
	}

	public Type getStaticPropertyType() {
		return staticPropertyType;
	}

	public final ParameterizedType getCollectionType(final Type innerType) {
		return new CollectionTypeImpl(innerType, getTypeSystem(), BuiltinMetaModel.COLLECTION);
	}

	public final ParameterizedType getListType(final Type innerType) {
		return new ListTypeImpl(innerType, getTypeSystem(), BuiltinMetaModel.LIST);
	}

	public final ParameterizedType getSetType(final Type innerType) {
		return new SetTypeImpl(innerType, getTypeSystem(), BuiltinMetaModel.SET);
	}

	private final Cache<Object, Type> typeCache = new Cache<Object, Type>() {

		@Override
		protected Type createNew(Object obj) {
			if (obj == null) {
				return getVoidType();
			}
			if (obj instanceof Set) {
				return getSetType(null);
			}
			if (obj instanceof List) {
				return getListType(null);
			}
			if (obj instanceof Collection) {
				return getCollectionType(null);
			}
			// datatypes
			if (stringType.isInstance(obj)) {
				return stringType;
			}
			if (integerType.isInstance(obj)) {
				return integerType;
			}
			if (booleanType.isInstance(obj)) {
				return booleanType;
			}
			if (realType.isInstance(obj)) {
				return realType;
			}
			if (typeType.isInstance(obj)) {
				return typeType;
			}
			if (propertyType.isInstance(obj)) {
				return propertyType;
			}
			if (operationType.isInstance(obj)) {
				return operationType;
			}
			if (staticPropertyType.isInstance(obj)) {
				return staticPropertyType;
			}
			
			return objectType;
		}
	};

	public Type getType(final Object obj) {
		return typeCache.get(obj);
	}

	public Type getTypeForName(final String typeName) {
		return _builtinTypes.get(typeName);
	}

	HashSet<Type> _knownTypes;
	public Set<Type> getKnownTypes() {
		return _knownTypes;
	}

	private final static String convert(final String javaclassname) {
		final StringBuffer sb = new StringBuffer();
		for (int i = 0; i < javaclassname.length(); i++) {
			final char c = javaclassname.charAt(i);
			if (c == '.') {
				sb.append(SyntaxConstants.NS_DELIM);
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public Type getVoidType() {
		return voidType;
	}

	public void setTypeSystem(final TypeSystem typeSystem) {
		if (typeSystem != null) {
			this.typeSystem = typeSystem;
		}
	}

	public Set<String> getNamespaces() {
		// TODO: provide real implementation
		return new HashSet<String>();
	}

}
