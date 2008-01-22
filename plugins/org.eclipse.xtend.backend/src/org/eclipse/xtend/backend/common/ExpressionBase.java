/*
Copyright (c) 2008 Arno Haase.
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html

Contributors:
    Arno Haase - initial API and implementation
 */
package org.eclipse.xtend.backend.common;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author Arno Haase (http://www.haase-consulting.com)
 */
public abstract class ExpressionBase {
    private final SourcePos _sourcePos;
    private final List<ExecutionListener> _listeners = new ArrayList<ExecutionListener> ();

    public ExpressionBase (SourcePos sourcePos) {
        _sourcePos = sourcePos;
    }

    public SourcePos getPos () {
        return _sourcePos;
    }
    
    public void registerExecutionListener (ExecutionListener l) {
        _listeners.add (l);
    }
    
    private void firePreEvent (ExecutionContext ctx) {
        for (ExecutionListener l: _listeners)
            l.preExecute (ctx);
    }

    private void firePostEvent (Object result, ExecutionContext ctx) {
        for (int i=_listeners.size()-1; i >= 0; i--)
            _listeners.get(i).postExecute (result, ctx);
    }
    
    public final Object evaluate (ExecutionContext ctx) {
        try {
            firePreEvent (ctx);
            final Object result = evaluateInternal (ctx);
            firePostEvent (result, ctx);
            return result;
        }
        catch (ExecutionException exc) {
            exc.addStackTraceElement (_sourcePos, ctx.getLocalVarContext().getLocalVars());
            throw exc;
        }
        catch (Exception exc) {
            throw new ExecutionException (exc, _sourcePos, ctx.getLocalVarContext().getLocalVars());
        }
    }
    
    protected abstract Object evaluateInternal (ExecutionContext ctx);
}
