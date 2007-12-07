/*******************************************************************************
 * Copyright (c) 2005, 2006 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.xtend.shared.ui.expression.editor.codeassist;

import java.util.List;

import org.eclipse.internal.xtend.expression.ast.DeclaredParameter;
import org.eclipse.internal.xtend.expression.codeassist.ProposalFactory;
import org.eclipse.internal.xtend.xtend.ast.Extension;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xpand2.XpandUtil;
import org.eclipse.xtend.expression.TypeNameUtil;
import org.eclipse.xtend.shared.ui.expression.editor.EditorImages;
import org.eclipse.xtend.typesystem.Operation;
import org.eclipse.xtend.typesystem.ParameterizedType;
import org.eclipse.xtend.typesystem.Property;
import org.eclipse.xtend.typesystem.StaticProperty;
import org.eclipse.xtend.typesystem.Type;

public class ProposalFactoryEclipseImpl implements ProposalFactory {

	public int offset;

	public ProposalFactoryEclipseImpl(final int offset) {
		this.offset = offset;
	}

	public Object createCollectionSpecificOperationProposal(final String insertString, final String displayString,
			final String prefix, final int cursor, final int marked) {
		final String displayStr = displayString;
		final String insertStr = insertString;
		final Image img = EditorImages.getImage(EditorImages.OPERATION);
		return new TextSelectingProposal(insertStr, offset - prefix.length(), prefix.length(), cursor, marked, img,
				displayStr, null, null);
	}

	public Object createPropertyProposal(final Property p, final String prefix, final boolean onOperation) {
		final String returnType = computeReturnType(p.getReturnType(), onOperation);
		final String displayStr = p.getName() + " " + returnType + " - "
				+ TypeNameUtil.getSimpleName(p.getOwner().getName());
		final String insertStr = p.getName();
		final Image img = EditorImages.getImage(EditorImages.PROPERTY);
		return new CompletionProposal(insertStr, offset - prefix.length(), prefix.length(), insertStr.length(), img,
				displayStr, null, null);
	}

	/**
	 * @see ProposalFactory#createStaticPropertyProposal(StaticProperty, String, boolean)
	 */
	public Object createStaticPropertyProposal(final StaticProperty p, final String prefix, final boolean onOperation) {
		final String returnType = computeReturnType(p.getReturnType(), onOperation);
		final String displayStr = p.getName() + " " + returnType + " - "
				+ TypeNameUtil.getSimpleName(p.getOwner().getName());
		final String insertStr = p.getName();
		final Image img = EditorImages.getImage(EditorImages.STATICPROPERTY);
		return new CompletionProposal(insertStr, offset - prefix.length(), prefix.length(), insertStr.length(), img,
				displayStr, null, null);
	}

	private String computeReturnType(Type returnType, final boolean onOperation) {
		if (returnType == null) {
			return "unknown";
		}
		if (onOperation) {
			if (returnType instanceof ParameterizedType) {
				returnType = ((ParameterizedType) returnType).getInnerType();
			}
			return "List[" + XpandUtil.getLastSegment(returnType.getName()) + "]";
		}

		return TypeNameUtil.getSimpleName(returnType.getName());
	}

	public Object createOperationProposal(final Operation p, final String prefix, final boolean onOperation) {
		final String returnType = computeReturnType(p.getReturnType(), onOperation);
		final String displayStr = p.getName() + toParamString(p.getParameterTypes()) + " " + returnType + " - "
				+ TypeNameUtil.getSimpleName(p.getOwner().getName());
		final String insertStr = p.getName() + "()";
		int x = insertStr.length();
		if (p.getParameterTypes().size() > 0) {
			x--;
		}
		final Image img = EditorImages.getImage(EditorImages.OPERATION);
		return new CompletionProposal(insertStr, offset - prefix.length(), prefix.length(), x, img, displayStr, null,
				null);
	}

	public Object createExtensionProposal(final Extension p, final String prefix) {
		final String displayStr = p.getName() + toParamString(p, false);
		final String insertStr = p.getName() + "()";
		int x = insertStr.length();
		if (p.getFormalParameters().size() > 0) {
			x--;
		}
		final Image img = EditorImages.getImage(EditorImages.EXTENSION);
		return new CompletionProposal(insertStr, offset - prefix.length(), prefix.length(), x, img, displayStr, null,
				null);
	}

	public Object createExtensionOnMemberPositionProposal(final Extension p, final String prefix,
			final boolean onOperation) {
		final String displayStr = p.getName() + toParamString(p, true) + " - "
				+ ((DeclaredParameter) p.getFormalParameters().get(0)).getType();
		final String insertStr = p.getName() + "()";
		int x = insertStr.length();
		if (p.getFormalParameters().size() > 1) {
			x--;
		}
		final Image img = EditorImages.getImage(EditorImages.EXTENSION);
		return new CompletionProposal(insertStr, offset - prefix.length(), prefix.length(), x, img, displayStr, null,
				null);
	}

	private String toParamString(final List<Type> parameterTypes) {
		final StringBuffer b = new StringBuffer("(");
		for (int i = 0, x = parameterTypes.size(); i < x; i++) {
			b.append(TypeNameUtil.getSimpleName(parameterTypes.get(i).getName()));
			if (i + 1 < x) {
				b.append(",");
			}
		}
		b.append(")");
		return b.toString();
	}

	private String toParamString(final Extension p, final boolean member) {
		final StringBuffer b = new StringBuffer("(");
		int i = member ? 1 : 0;
		for (final int x = p.getFormalParameters().size(); i < x; i++) {
			b.append(((DeclaredParameter) p.getFormalParameters().get(i)).toString());
			if (i + 1 < x) {
				b.append(",");
			}
		}
		b.append(")");
		return b.toString();
	}

	public Object createVariableProposal(final String name, final Type t, final String prefix) {
		final String displayStr = name + " " + computeReturnType(t, false);
		final String insertStr = name;
		final Image img = EditorImages.getImage(EditorImages.VARIABLE);
		return new CompletionProposal(insertStr, offset - prefix.length(), prefix.length(), insertStr.length(), img,
				displayStr, null, null);
	}

	public Object createTypeProposal(final String insertString, final Type type, final String prefix) {
		String displayStr = TypeNameUtil.getSimpleName(type.getName());
		final String packName = TypeNameUtil.withoutLastSegment(type.getName());
		if (packName != null) {
			displayStr += " - " + packName;
		}

		final String insertStr = insertString;
		final Image img = EditorImages.getImage(EditorImages.TYPE);
		return new CompletionProposal(insertStr, offset - prefix.length(), prefix.length(), insertStr.length(), img,
				displayStr, null, null);
	}

	public Object createExtensionImportProposal(final String insertStr, final String displayStr, final String prefix,
			final int cursor, final int marked) {
		final Image img = EditorImages.getImage(EditorImages.EXT_IMPORT);
		return new CompletionProposal(insertStr, offset - prefix.length(), prefix.length(), insertStr.length(), img,
				displayStr, null, null);
	}

	public Object createNamespaceProposal(final String insertStr, final String displayStr, final String prefix) {
		final Image img = EditorImages.getImage(EditorImages.PACKAGE);
		return new CompletionProposal(insertStr, offset - prefix.length(), prefix.length(), insertStr.length(), img,
				displayStr, null, null);
	}

	public Object createDefinitionProposal(final String insertStr, final String displayStr, final String prefix) {
		final Image img = EditorImages.getImage(EditorImages.XPAND_DEFINE);
		return new CompletionProposal(insertStr, offset - prefix.length(), prefix.length(), insertStr.length(), img,
				displayStr, null, null);
	}

	public Object createStatementProposal(final String insertStr, final String displayStr, final String prefix,
			final int cursor, final int marked) {
		final Image img = EditorImages.getImage(EditorImages.EXT_IMPORT);
		return new CompletionProposal(insertStr, offset - prefix.length(), prefix.length(), insertStr.length(), img,
				displayStr, null, null);
	}

	public Object createStatementProposal(final String insertString, final String displayString, final String prefix) {
		throw new UnsupportedOperationException();
	}

	public Object createKeywordProposal(final String insertString, final String displayString, final String prefix) {
		throw new UnsupportedOperationException();
	}

}
