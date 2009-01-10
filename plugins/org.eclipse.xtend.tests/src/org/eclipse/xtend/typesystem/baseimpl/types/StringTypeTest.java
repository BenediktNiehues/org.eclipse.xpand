/*******************************************************************************
 * Copyright (c) 2005-2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtend.typesystem.baseimpl.types;

import junit.framework.TestCase;

import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.expression.ExpressionFacade;

public class StringTypeTest extends TestCase {

    ExecutionContextImpl ec;

    private ExpressionFacade ef;

    @Override
    protected void setUp() throws Exception {
        ec = new ExecutionContextImpl();
        ef = new ExpressionFacade(ec);
    }

    public final void testMatches() {
        assertEquals(Boolean.TRUE, ef.evaluate("'test'.matches('\\\\w+')"));
        assertEquals(Boolean.TRUE, ef.evaluate("'test'.matches('[a-zA-Z]+')"));
    }
    
    public final void testAsInteger() {
        assertEquals(new Integer(42),ef.evaluate("'42'.asInteger()"));
    }

    public final void testSplit() {
    	assertEquals("a",ef.evaluate("'(test,a,b)'.split(',').get(1)"));
    }
    
    public final void testReplaceFirst() {
    	assertEquals("test,a,b)",ef.evaluate("'(test,a,b)'.replaceFirst('\\\\(','')"));
    }
    public final void testReplaceLast() {
    	assertEquals("(testab)",ef.evaluate("'(test,a,b)'.replaceAll(',','')"));
    	assertEquals("(test,a,b",ef.evaluate("'(test,a,b)'.replaceAll('\\\\)','')"));
    }
    
    public final void testCombination() {
    	assertEquals("test",ef.evaluate("'(test,a,b)'.replaceFirst('\\\\(','').replaceAll('\\\\)','').split(',').get(0)"));
    }
}
