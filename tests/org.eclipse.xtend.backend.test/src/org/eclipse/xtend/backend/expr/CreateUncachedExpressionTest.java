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

import static org.eclipse.xtend.backend.testhelpers.BackendTestHelper.SOURCE_POS;
import static org.eclipse.xtend.backend.testhelpers.BackendTestHelper.createEmptyExecutionContext;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.xtend.backend.common.ExecutionContext;
import org.eclipse.xtend.backend.types.builtin.ListType;
import org.junit.Test;


/**
 * 
 * @author Arno Haase (http://www.haase-consulting.com)
 * @author Andr� Arnold
 */
public class CreateUncachedExpressionTest {
    private ExecutionContext _ctx = null;
    
    @Test public void testLogic () {
        _ctx = createEmptyExecutionContext();

        final List<Object> l1 = eval ();
        l1.add ("a");
        
        assertNotSame (l1, eval());
        assertTrue (eval ().isEmpty());
    }
    
    @SuppressWarnings("unchecked")
    private List<Object> eval () {
        return (List<Object>) new CreateUncachedExpression (ListType.INSTANCE, SOURCE_POS).evaluate (_ctx);
    }
}
