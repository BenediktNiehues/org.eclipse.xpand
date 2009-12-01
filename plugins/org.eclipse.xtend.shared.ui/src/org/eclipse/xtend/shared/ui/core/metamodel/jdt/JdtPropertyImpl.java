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

package org.eclipse.xtend.shared.ui.core.metamodel.jdt;

import org.eclipse.internal.xtend.type.baseimpl.PropertyImpl;
import org.eclipse.xtend.typesystem.Type;

public class JdtPropertyImpl extends PropertyImpl {

    public JdtPropertyImpl(final Type owner, final String name, final Type returnType) {
        super(owner, name, returnType);
    }

    public Object get(final Object target) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void set(final Object target, final Object newValue) {
        throw new UnsupportedOperationException();
    }

}
