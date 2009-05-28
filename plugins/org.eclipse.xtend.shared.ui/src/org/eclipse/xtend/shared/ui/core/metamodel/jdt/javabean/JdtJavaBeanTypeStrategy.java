/*******************************************************************************
 * Copyright (c) 2005, 2009 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.xtend.shared.ui.core.metamodel.jdt.javabean;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.internal.xtend.util.StringHelper;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.xtend.shared.ui.core.metamodel.jdt.JdtTypeStrategy;
import org.eclipse.xtend.shared.ui.internal.XtendLog;

public class JdtJavaBeanTypeStrategy implements JdtTypeStrategy {

	private IJavaProject project;

	public JdtJavaBeanTypeStrategy(final IJavaProject project) {
		super();
		this.project = project;
	}

	public IType[] getSuperTypes(final IType type) throws JavaModelException {
		final ITypeHierarchy hier = type.newSupertypeHierarchy(new NullProgressMonitor());
		final IType[] ifs = hier.getSuperInterfaces(type);
		final IType st = hier.getSuperclass(type);
		if (st == null)
			return ifs;
		final IType[] result = new IType[ifs.length + 1];
		System.arraycopy(ifs, 0, result, 0, ifs.length);
		result[ifs.length] = st;
		return result;
	}

	public boolean isAssignable(final IType toAssigTo, final IType assignable) throws JavaModelException {
		return assignable.newSupertypeHierarchy(new NullProgressMonitor()).contains(toAssigTo);

	}

	public boolean isGetter(final IMethod method) {
		int flags;
		try {
			flags = method.getFlags();
		} catch (final JavaModelException e) {
			return false;
		}
		final String name = method.getElementName();
		if (!Flags.isStatic(flags) && method.getParameterTypes().length == 0
				&& (name.startsWith("get") || name.startsWith("is")))
			return true;
		return false;
	}

	public String getterToProperty(final String elementName) {
		String propName = null;
		if (elementName.startsWith("get")) {
			propName = elementName.substring(3, elementName.length());
		} else if (elementName.startsWith("is")) {
			propName = elementName.substring(2, elementName.length());
		} else {
			return elementName;
		}

		if (propName.length() == 1 || propName.matches("\\p{Upper}\\p{Lower}.*")) {
			propName = StringHelper.firstLower(propName);
			return propName;
		} else if (propName.length() > 1) {
			return propName;
		} else {
			return elementName;
		}
	}

	/**
	 * Constants are fields that are
	 * <ul>
	 * <li>Enumeration literals
	 * <li>Accessible fields in Interfaces
	 * <li>Class fields with modifier <tt>public final static</tt>
	 * </ul>
	 */
	public boolean isConstant(IField field) {
		try {
			if (field.isEnumConstant()
					|| field.getDeclaringType().isInterface()
					|| (Flags.isPublic(field.getFlags()) && Flags.isFinal(field.getFlags()) && Flags.isStatic(field
							.getFlags()))) {
				return true;
			}
		} catch (JavaModelException e) {
			return false;
		}
		return false;
	}

	/**
	 * Operations are
	 * <ul>
	 * <li>non-static methods
	 * <li>no Getter (property accessor) methods
	 * </ul>
	 */
	public boolean isOperation(final IMethod method) {
		if (!isGetter(method)) {
			try {
				final int flags = method.getFlags();
				if (!Flags.isStatic(flags)) {
					return true;
				}
			} catch (final JavaModelException e) {
				return false;
			}
		}
		return false;
	}

	public String propertyName(final IMethod method) {
		return getterToProperty(method.getElementName());
	}

	public String getPropertiesInnerType(final IMethod method) {
		try {
			String returnType = method.getReturnType();
			if (Signature.getTypeSignatureKind(returnType) == Signature.ARRAY_TYPE_SIGNATURE) {
				String elementType = Signature.getElementType(returnType);
				return elementType;
			} else if (isCollectionType(returnType, method)) {
				String[] arguments = Signature.getTypeArguments(returnType);
				if (arguments.length == 1)
					return arguments[0];
			}
		} catch (JavaModelException e) {
			// ignore
		}
		return null;
	}

	/**
	 * @param returnType
	 * @return
	 */
	private boolean isCollectionType(String returnType, IMethod method) {
		try {
			String signatureSimpleName = Signature.getTypeErasure(returnType);
			String typeName = qualifiedName(method, signatureSimpleName);
			if (typeName != null) {
				IType type = this.project.findType(typeName);
				IType collection = this.project.findType("java.util.Collection");
				if (type != null && type.exists()) {
					return type.newSupertypeHierarchy(null).contains(collection);
				}
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return false;
	}

	private String qualifiedName(IMethod method, String signatureSimpleName) {
		try {
			String[][] result = method.getDeclaringType().resolveType(Signature.toString(signatureSimpleName));
			if (result!=null && result.length > 0) {
				StringBuffer buff = new StringBuffer();
				for (int i = 0; i < result[0].length; i++) {
					String part = result[0][i];
					buff.append(part);
					if (i < result[0].length - 1) {
						buff.append(".");
					}
				}
				return buff.toString();
			}
		} catch (JavaModelException e) {
			XtendLog.logError(e);
		}
		return null;
	}

	public String propertyName(IField field) {
		return field.getElementName();
	}

}
