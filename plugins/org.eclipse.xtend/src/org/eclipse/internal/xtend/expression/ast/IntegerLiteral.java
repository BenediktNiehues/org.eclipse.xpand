/*******************************************************************************
 * Copyright (c) 2005-2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.internal.xtend.expression.ast;

import java.util.Set;

import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.typesystem.Type;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 */
public class IntegerLiteral extends Literal {

    public IntegerLiteral(final Identifier literalValue) {
        super(literalValue);
    }

    @Override
    public Object evaluateInternal(final ExecutionContext ctx) {
        return new Long(getLiteralValue().getValue());
    }

    public Type analyzeInternal(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
        return ctx.getIntegerType();
    }

}
