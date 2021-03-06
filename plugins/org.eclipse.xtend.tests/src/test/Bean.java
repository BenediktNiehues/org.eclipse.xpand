/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package test;

import java.util.ArrayList;
import java.util.List;

public class Bean {

    public final static int A_ENUM = 1;

    public final static int B_ENUM = 1;

    private String test;

    private boolean ready = false;

    private int counter = 0;

	private List<Bean> childBeans = new ArrayList<Bean>();

    private Bean parentBean = null;

    public List<Bean> getChildBeans() {
        return childBeans;
    }

    public void setChildBeans(final List<Bean> childBeans) {
        this.childBeans = childBeans;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(final int counter) {
        this.counter = counter;
    }

    public Bean getParentBean() {
        return parentBean;
    }

    public void setParentBean(final Bean parentBean) {
        this.parentBean = parentBean;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(final boolean ready) {
        this.ready = ready;
    }

    public String getTest() {
        return test;
    }

    public void setTest(final String test) {
        this.test = test;
    }

}
