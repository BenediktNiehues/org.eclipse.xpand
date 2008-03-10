/*
Copyright (c) 2008 Arno Haase.
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html

Contributors:
    Arno Haase - initial API and implementation
 */
package org.eclipse.xtend.backend.functions;

import java.util.List;

import org.eclipse.xtend.backend.common.BackendType;
import org.eclipse.xtend.backend.common.ExecutionContext;
import org.eclipse.xtend.backend.common.ExpressionBase;
import org.eclipse.xtend.backend.common.LocalVarContext;
import org.eclipse.xtend.backend.common.StacktraceEntry;


/**
 * 
 * @author Arno Haase (http://www.haase-consulting.com)
 */
public final class SourceDefinedFunction extends AbstractFunction {
	private final String _name;
    private final List<String> _paramNames;
    private final ExpressionBase _def;

    public SourceDefinedFunction (String name, List<String> paramNames, List<BackendType> paramTypes, ExpressionBase def, boolean cached, ExpressionBase guard) {
        super (guard, paramTypes, cached);
    	_name = name;
        _paramNames = paramNames;
        _def = def;
    }

    public Object invoke (ExecutionContext ctx, Object[] params) {
        final LocalVarContext lvc = new LocalVarContext ();
        for (int i=0; i<_paramNames.size(); i++) {
            lvc.getLocalVars().put(_paramNames.get(i), params[i]);
        }
        
        final LocalVarContext oldLvc = ctx.getLocalVarContext();
        try {
            ctx.setLocalVarContext(lvc);
            
            if (ctx.isLogStacktrace())
                ctx.getStacktrace().add (new StacktraceEntry (_def.getPos(), ctx));
            
            return _def.evaluate(ctx);
        }
        finally {
            if (ctx.isLogStacktrace())
                ctx.getStacktrace().remove (ctx.getStacktrace().size() - 1);
            
            ctx.setLocalVarContext(oldLvc);
        }
    }

	@Override
	public String toString () {
	    return "SourceDefinedFunction '" + _name + "' " + getParameterTypes();
	}
}

