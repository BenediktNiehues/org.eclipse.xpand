/*******************************************************************************
 * Copyright (c) 2005-2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtend.typesystem.baseimpl.types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.internal.xtend.type.impl.java.JavaMetaModel;
import org.eclipse.internal.xtend.type.impl.java.beans.JavaBeansStrategy;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.expression.ExpressionFacade;

public class IntegerTypeTest extends TestCase {

    ExecutionContextImpl ec;

    private ExpressionFacade ef;

    @Override
    protected void setUp() throws Exception {
        ec = new ExecutionContextImpl();
        ec.registerMetaModel(new JavaMetaModel("asdf", new JavaBeansStrategy()));
        ef = new ExpressionFacade(ec);
    }

    public final void testUpTo1() {
        final List r = (List) ef.evaluate("1.upTo(5)", Collections.EMPTY_MAP);
        final List<Long> c = new ArrayList<Long>();
        for (int i = 1; i <= 5; i++) {
            c.add(new Long(i));
        }
        assertEquals(c, r);
    }
    
    public void testBug172154Equals() {
    	Boolean result = (Boolean) ef.evaluate("1==null");
    	assertNotNull(result);
    	assertFalse(result.booleanValue());
    }

    public void testBug172154NotEquals() {
    	Boolean result = (Boolean) ef.evaluate("1!=null");
    	assertNotNull(result);
    	assertTrue(result.booleanValue());
    }
}
