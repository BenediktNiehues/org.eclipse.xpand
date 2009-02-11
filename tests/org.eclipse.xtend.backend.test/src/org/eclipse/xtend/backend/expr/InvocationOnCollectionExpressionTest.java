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

import org.eclipse.xtend.backend.common.QualifiedName;
import org.junit.Test;


/**
 * 
 * @author Arno Haase (http://www.haase-consulting.com)
 * @author Andr� Arnold
 */
public class InvocationOnCollectionExpressionTest {
    @Test public void testInvocation () {
        assertEquals (Arrays.asList (3L, 4L, 5L), new InvocationOnCollectionExpression (createLiteral (Arrays.asList(1L, 2L, 3L)), new QualifiedName ("operatorPlus"), Arrays.asList (createLiteral (2L)), SOURCE_POS).evaluate (createEmptyExecutionContext ()));
        assertEquals (null, new InvocationOnCollectionExpression (createLiteral (null), new QualifiedName ("operatorPlus"), Arrays.asList (createLiteral (2L)), SOURCE_POS).evaluate (createEmptyExecutionContext ()));
    }
    
    @Test public void testFlatten () {
        assertEquals (Arrays.asList("a","b","b","c","d"), new InvocationOnCollectionExpression (createLiteral (Arrays.asList ("a,b", "b,c,d")), new QualifiedName ("split"), Arrays.asList (createLiteral (",")), SOURCE_POS).evaluate (createEmptyExecutionContext()));
    }
}
