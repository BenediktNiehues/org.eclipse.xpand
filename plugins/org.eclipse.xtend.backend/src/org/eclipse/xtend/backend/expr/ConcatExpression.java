/*
Copyright (c) 2008 Arno Haase.
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html

Contributors:
    Arno Haase - initial API and implementation
 */
package org.eclipse.xtend.backend.expr;

import java.util.List;

import org.eclipse.xtend.backend.common.EfficientLazyString;
import org.eclipse.xtend.backend.common.ExecutionContext;
import org.eclipse.xtend.backend.common.ExpressionBase;
import org.eclipse.xtend.backend.common.Helpers;
import org.eclipse.xtend.backend.common.SourcePos;


/**
 * 
 * @author Arno Haase (http://www.haase-consulting.com)
 */
public final class ConcatExpression extends ExpressionBase {
    private final List<? extends ExpressionBase> _parts;

    public ConcatExpression (List<? extends ExpressionBase> parts, SourcePos sourcePos) {
        super(sourcePos);
        
        _parts = parts;
    }

    @Override
    protected Object evaluateInternal (ExecutionContext ctx) {
        final EfficientLazyString result = new EfficientLazyString ();

        for (ExpressionBase expr: _parts)
            result.append (Helpers.overridableToString (ctx, expr.evaluate(ctx)));

        return result;
    }

}
