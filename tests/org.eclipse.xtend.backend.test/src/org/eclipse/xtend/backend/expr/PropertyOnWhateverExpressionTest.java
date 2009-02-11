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
import static org.eclipse.xtend.backend.testhelpers.BackendTestHelper.createLiteral;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.eclipse.xtend.backend.testhelpers.BeanWithSizeProperty;
import org.junit.Test;


/**
 * 
 * @author Arno Haase (http://www.haase-consulting.com)
 * @author Andr� Arnold
 */
public class PropertyOnWhateverExpressionTest {
    @Test public void testLogic () {
        assertEquals (6L, eval (new BeanWithSizeProperty (6), "size"));
        assertEquals (2L, eval (Arrays.asList (new BeanWithSizeProperty (7), new BeanWithSizeProperty (12)), "size"));

        assertEquals (Arrays.asList (1L, 2L, 3L), eval (Arrays.asList ("a", "ab", "abc"), "length"));
        assertEquals (2L, eval (Arrays.asList (new BeanWithSizeProperty (7), new BeanWithSizeProperty (12)), "size"));
    }
    
    private Object eval (Object param, String propertyName) {
        return new PropertyOnWhateverExpression (createLiteral (param), propertyName, SOURCE_POS).evaluate (createEmptyExecutionContext());
    }
    
    @Test public void testFlatten () {
        assertEquals (Arrays.asList("a0","a1","a0","a1","a2"), new PropertyOnWhateverExpression (createLiteral (Arrays.asList (new BeanWithSizeProperty (2), new BeanWithSizeProperty (3))), "chunks", SOURCE_POS).evaluate (createEmptyExecutionContext()));
    }
}
