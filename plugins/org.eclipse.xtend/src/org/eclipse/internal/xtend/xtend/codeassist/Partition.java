/*
 * <copyright>
 *
 * Copyright (c) 2005-2006 Sven Efftinge (http://www.efftinge.de) and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge (http://www.efftinge.de) - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.internal.xtend.xtend.codeassist;

public class Partition {
    public final static Partition EXPRESSION = new Partition("Expression");

    public final static Partition TYPE_DECLARATION = new Partition("Type Declaration");

    public final static Partition NAMESPACE_IMPORT = new Partition("Namespace Import");

    public final static Partition EXTENSION_IMPORT = new Partition("AbstractExtension Import");

    public static final Partition DEFAULT = new Partition("Default");

    public static final Partition COMMENT = new Partition("Comment");

    private String name = null;

    protected Partition(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
