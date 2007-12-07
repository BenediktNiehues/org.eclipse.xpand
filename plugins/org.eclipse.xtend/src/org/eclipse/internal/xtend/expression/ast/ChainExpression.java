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
package org.eclipse.internal.xtend.expression.ast;

import java.util.Set;

import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 * @author Bernd Kolb
 */
public class ChainExpression extends Expression {

    private Expression first;

    private Expression next;

    public ChainExpression(final Expression first, final Expression next) {
        this.first = first;
        this.next = next;
    }

    @Override
    protected Object evaluateInternal(final ExecutionContext ctx) {
        getFirst().evaluate(ctx);
        return getNext().evaluate(ctx);
    }

    public Type analyze(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
        getFirst().analyze(ctx, issues);
        return getNext().analyze(ctx, issues);
    }

    public Expression getFirst() {
        return first;
    }

    public Expression getNext() {
        return next;
    }

    @Override
	protected String toStringInternal() {
    	return getFirst() + "->" + getNext();
    }
}
