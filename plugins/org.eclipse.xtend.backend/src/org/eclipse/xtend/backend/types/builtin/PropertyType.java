/*
Copyright (c) 2008 Arno Haase.
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html

Contributors:
    Arno Haase - initial API and implementation
 */
package org.eclipse.xtend.backend.types.builtin;

import org.eclipse.xtend.backend.common.BackendType;
import org.eclipse.xtend.backend.common.Property;
import org.eclipse.xtend.backend.types.AbstractType;
import org.eclipse.xtend.backend.util.ReflectionHelper;


/**
 * 
 * @author Arno Haase (http://www.haase-consulting.com)
 */
public final class PropertyType extends AbstractType {
    public static final PropertyType INSTANCE = new PropertyType ();
    
    private PropertyType () {
        super ("Property", "{builtin}Property");
        
        register (new BuiltinProperty (this, "name", ReflectionHelper.getKnownMethod(Property.class, "getName"), null), StringType.INSTANCE);
        register (new BuiltinProperty (this, "owner", ReflectionHelper.getKnownMethod(Property.class, "getOwner"), null), TypeType.INSTANCE);
    }

    @Override
    public boolean isAssignableFrom (BackendType other) {
        return other == this || other == VoidType.INSTANCE;
    }

    @Override
    public boolean equals (Object other) {
        return other == this;
    }
}
