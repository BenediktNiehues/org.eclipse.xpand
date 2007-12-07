/*
 * <copyright>
 *
 * Copyright (c) 2005-2006 Sven Efftinge (http://www.efftinge.de) and others.
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
package org.eclipse.internal.xpand2.parser;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.internal.xpand2.ast.Advice;
import org.eclipse.internal.xpand2.ast.Definition;
import org.eclipse.internal.xpand2.ast.ErrorStatement;
import org.eclipse.internal.xpand2.ast.ExpandStatement;
import org.eclipse.internal.xpand2.ast.ExpressionStatement;
import org.eclipse.internal.xpand2.ast.FileStatement;
import org.eclipse.internal.xpand2.ast.ForEachStatement;
import org.eclipse.internal.xpand2.ast.IfStatement;
import org.eclipse.internal.xpand2.ast.ImportDeclaration;
import org.eclipse.internal.xpand2.ast.LetStatement;
import org.eclipse.internal.xpand2.ast.ProtectStatement;
import org.eclipse.internal.xpand2.ast.Statement;
import org.eclipse.internal.xpand2.ast.Template;
import org.eclipse.internal.xpand2.ast.TextStatement;
import org.eclipse.internal.xpand2.codeassist.XpandTokens;
import org.eclipse.internal.xtend.expression.ast.DeclaredParameter;
import org.eclipse.internal.xtend.expression.ast.Expression;
import org.eclipse.internal.xtend.expression.ast.Identifier;
import org.eclipse.internal.xtend.expression.ast.SyntaxElement;
import org.eclipse.internal.xtend.expression.parser.ExpressionFactory;

/**
 * *
 * 
 * @author Sven Efftinge (http://www.efftinge.de) *
 */
public class XpandFactory extends ExpressionFactory {

	public XpandFactory(final String fileName) {
		super(fileName);
	}

	public Template createTemplate(final List<SyntaxElement> imports,
			final List<SyntaxElement> extensions,
			final List<SyntaxElement> defines, final List<SyntaxElement> advices) {
		final ImportDeclaration[] i = check(imports).toArray(
				new ImportDeclaration[check(imports).size()]);
		final ImportDeclaration[] ext = check(extensions).toArray(
				new ImportDeclaration[check(extensions).size()]);

		final Definition[] d = check(defines).toArray(
				new Definition[check(defines).size()]);
		final Advice[] a = check(advices).toArray(
				new Advice[check(advices).size()]);
		final Template t = new Template(i, ext, d, a);
		return handle(t);
	}

	public Definition createDefinition(final Identifier name,
			final List<DeclaredParameter> p, final Identifier type,
			final List<Statement> s) {
		final DeclaredParameter[] params = check(p).toArray(
				new DeclaredParameter[check(p).size()]);
		final Statement[] body = check(s).toArray(
				new Statement[check(s).size()]);
		Definition def = new Definition(name, type, params, body);
		for (Statement element : body)
			element.setContainingDefinition(def);
		return handle(def);
	}

	private <T> List<T> check(List<T> p) {
		if (p == null)
			return new ArrayList<T>();
		p.remove(null);
		return p;
	}

	public TextStatement createTextStatement(final Identifier t,
			final Identifier identifier) {
		String txt = t.getValue();
		if (txt.startsWith(XpandTokens.RT) && txt.endsWith(XpandTokens.LT)) {
			txt = txt.substring(1, txt.length() - 1);
		}
		return handle(new TextStatement(txt, identifier != null));
	}

	public ForEachStatement createForEachStatement(final Expression e,
			final Identifier v, final Expression sep, final Identifier iter,
			final List<Statement> s) {
		final Statement[] body = check(s).toArray(
				new Statement[check(s).size()]);
		return handle(new ForEachStatement(v, e, body, sep, iter));
	}

	public IfStatement createIfStatement(final Expression condition,
			final List<Statement> s) {
		final Statement[] body = check(s).toArray(
				new Statement[check(s).size()]);
		return handle(new IfStatement(condition, body));
	}

	public LetStatement createLetStatement(final Expression e,
			final Identifier name, final List<Statement> s) {
		final Statement[] body = check(s).toArray(
				new Statement[check(s).size()]);
		return handle(new LetStatement(name, e, body));
	}

	public ErrorStatement createErrorStatement(final Expression expr) {
		return handle(new ErrorStatement(expr));
	}

	public ExpressionStatement createExpressionStatement(final Expression e) {
		return handle(new ExpressionStatement(e));
	}

	public FileStatement createFileStatement(final Expression fileName,
			final Identifier option, final List<Statement> s) {
		final Statement[] body = check(s).toArray(
				new Statement[check(s).size()]);
		return handle(new FileStatement(fileName, body, option));
	}

	public ProtectStatement createProtectStatement(final Expression startC,
			final Expression endC, final Expression id, final boolean disabled,
			final List<Statement> s) {
		final Statement[] body = check(s).toArray(
				new Statement[check(s).size()]);
		return handle(new ProtectStatement(startC, endC, body, id, disabled));
	}

	public ExpandStatement createExpandStatement(final Identifier definition,
			final List<Expression> parameters, final Expression target,
			final boolean foreach, final Expression sep) {
		final Expression[] params = check(parameters).toArray(
				new Expression[check(parameters).size()]);
		return handle(new ExpandStatement(definition, target, sep, params,
				foreach));
	}

	public ImportDeclaration createImportDeclaration(final Identifier namespace) {
		return handle(new ImportDeclaration(namespace));
	}

	public Advice createAround(final Identifier n,
			final List<DeclaredParameter> p, final boolean wildparams,
			final Identifier t, final List<Statement> s) {
		final DeclaredParameter[] params = check(p).toArray(
				new DeclaredParameter[check(p).size()]);
		final Statement[] body = check(s).toArray(
				new Statement[check(s).size()]);
		final Advice a = new Advice(n, t, params, wildparams, body);
		for (Statement element : body)
			element.setContainingDefinition(a);
		return handle(a);
	}

}
