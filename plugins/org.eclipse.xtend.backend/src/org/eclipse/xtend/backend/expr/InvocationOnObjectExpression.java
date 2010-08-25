/*
Copyright (c) 2008 Arno Haase, Andr� Arnold.
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html

Contributors:
    Arno Haase - initial API and implementation
    Andr� Arnold
 */
package org.eclipse.xtend.backend.expr;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtend.backend.common.ExecutionContext;
import org.eclipse.xtend.backend.common.ExpressionBase;
import org.eclipse.xtend.backend.common.QualifiedName;
import org.eclipse.xtend.backend.common.SourcePos;
import org.eclipse.xtend.backend.common.SyntaxConstants;


/**
 * 
 * @author Arno Haase (http://www.haase-consulting.com)
 * @author Andr� Arnold
 */
public final class InvocationOnObjectExpression extends ExpressionBase {
    private final QualifiedName _functionName;
    private final List<? extends ExpressionBase> _params;
    private final boolean _nullIfFirstParamIsNull;
    
    public InvocationOnObjectExpression (QualifiedName functionName, List<? extends ExpressionBase> params, boolean nullIfFirstParamIsNull, SourcePos sourcePos) {
        super (sourcePos);
        
        _functionName = functionName;
        _params = params;
        _nullIfFirstParamIsNull = nullIfFirstParamIsNull;
    }
    
    public QualifiedName getFunctionName() {
		return _functionName;
	}

	public List<? extends ExpressionBase> getParams() {
		return _params;
	}

	public boolean isNullIfFirstParamIsNull() {
		return _nullIfFirstParamIsNull;
	}

	@Override
    protected Object evaluateInternal(ExecutionContext ctx) {
        final List<Object> params = new ArrayList<Object> ();
        boolean firstParamIsThis = false;
        if (_params.size() > 0 && _params.get(0) instanceof LocalVarEvalExpression)
        	if (((LocalVarEvalExpression)_params.get(0)).getLocalVarName().equals(SyntaxConstants.THIS))
        		firstParamIsThis = true;
        for (ExpressionBase expr: _params)
        	params.add (expr.evaluate(ctx));
        
        // this is for "method-style" invocations: if the first parameter (i.e. the one "before the dot") is null,
        //  shortcut the evaluation and return null
        //
        // CAUTION - without this shortcut, the polymorphic resolution may be ambiguous in unexpected ways
        if (_nullIfFirstParamIsNull && params.size() > 0 && params.get(0) == null) {
            ctx.logNullDeRef (getPos());
            return null;
        }
        
        return ctx.getFunctionDefContext().invoke (ctx, _functionName, params, firstParamIsThis);
    }
}
