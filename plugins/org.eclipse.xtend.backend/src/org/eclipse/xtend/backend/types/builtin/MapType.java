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

import java.util.Collection;
import java.util.HashMap;

import org.eclipse.xtend.backend.types.AbstractType;
import org.eclipse.xtend.backend.util.ReflectionHelper;


/**
 * 
 * @author Arno Haase (http://www.haase-consulting.com)
 */
public final class MapType extends AbstractType {
    private MapType () {
        super ("Map", "{builtin}Map"); 
        
        register (new BuiltinProperty (CollectionType.INSTANCE, "size", ReflectionHelper.getKnownMethod(Collection.class, "size"), null), LongType.INSTANCE);
        register (new BuiltinProperty (CollectionType.INSTANCE, "isEmpty", ReflectionHelper.getKnownMethod(Collection.class, "isEmpty"), null), BooleanType.INSTANCE);
    }
    
    public static final MapType INSTANCE = new MapType ();
    
    @Override
    public Object create() {
        return new HashMap <Object,Object> ();
    }

    @Override
    public boolean equals (Object other) {
        return other == this;
    }
}
