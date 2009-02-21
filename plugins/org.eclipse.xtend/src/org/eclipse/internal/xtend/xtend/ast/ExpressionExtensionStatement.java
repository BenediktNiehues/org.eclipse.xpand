/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.internal.xtend.xtend.ast;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.eclipse.internal.xtend.expression.ast.DeclaredParameter;
import org.eclipse.internal.xtend.expression.ast.Expression;
import org.eclipse.internal.xtend.expression.ast.Identifier;
import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.Type;

public class ExpressionExtensionStatement extends AbstractExtension {

	private final Expression expression;

	public ExpressionExtensionStatement(final Identifier name, final Identifier returnType,
			final List<DeclaredParameter> formalParameters, final Expression expression, final boolean cached,
			final boolean isPrivate) {
		super(name, returnType, formalParameters, cached, isPrivate);
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}

	private final Stack<List<Type>> analyzations = new Stack<List<Type>>();

	@Override
	public Object evaluateInternal(final Object[] parameters, final ExecutionContext ctx) {
		return evaluateInternal2(parameters, ctx);
	}

	protected Object evaluateInternal2(final Object[] parameters, ExecutionContext ctx) {
		ctx = ctx.cloneWithoutVariables();
		ctx = ctx.cloneWithResource(file);
		final List<String> paramNames = getParameterNames();
		for (int i = 0, x = paramNames.size(); i < x; i++) {
			final String name = paramNames.get(i);
			ctx = ctx.cloneWithVariable(new Variable(name, parameters[i]));
		}
		return expression.evaluate(ctx);
	}

	@Override
	public void analyzeInternal(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
		if (expression != null) {
			expression.analyze(ctx, issues);
		}
	}

	@Override
	protected Type internalGetReturnType(final Type[] parameters, final ExecutionContext ctx,
			final Set<AnalysationIssue> issues) {
		if (getReturnTypeIdentifier() != null)
			return ctx.getTypeForName(getReturnTypeIdentifier().getValue());
		if (parameters == null || parameters.length != getParameterNames().size())
			return null;
		final List<Type> params = Arrays.asList(parameters);
		if (!analyzations.contains(params)) {
			analyzations.push(params);
			try {
				return analyzeInternal(parameters, ctx, issues);
			}
			finally {
				analyzations.pop();
			}
		}
		else {
			if (returnType == null) {
				issues.add(new AnalysationIssue(AnalysationIssue.INTERNAL_ERROR,
						"Recursive extensions need to have a return type specified!", this));
				return null;
			}
			return ctx.getTypeForName(returnType.getValue());
		}
	}

	protected Type analyzeInternal(final Type[] parameters, ExecutionContext ctx, final Set<AnalysationIssue> issues) {
		ctx = ctx.cloneWithoutVariables();
		ctx = ctx.cloneWithResource(file);
		final List<String> paramNames = getParameterNames();
		for (int i = 0, x = paramNames.size(); i < x; i++) {
			final String name = paramNames.get(i);
			final Type t = parameters[i];
			ctx = ctx.cloneWithVariable(new Variable(name, t));
		}
		return expression.analyze(ctx, issues);
	}
}
