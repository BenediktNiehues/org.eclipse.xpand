/*
Copyright (c) 2008 Arno Haase.
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html

Contributors:
    Arno Haase - initial API and implementation
 */
package org.eclipse.xtend.backend.util;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 * @author Arno Haase (http://www.haase-consulting.com)
 */
public abstract class Cache<K,V> {
    private final Map<K, V> _cache = new HashMap<K, V>();
    
    public V get (K key) {
        if (_cache.containsKey(key))
            return _cache.get (key);
        
        final V result = create (key);
        _cache.put (key, result);
        return result;
    }

    protected abstract V create (K key);
    
    public Map<K, V> getMap () {
        return _cache;
    }
}
