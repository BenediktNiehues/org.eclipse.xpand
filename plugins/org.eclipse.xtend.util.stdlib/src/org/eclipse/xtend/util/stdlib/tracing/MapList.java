/*******************************************************************************
 * Copyright (c) 2005-2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtend.util.stdlib.tracing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapList {

	private Map map = new HashMap();
	
	public void add( Object key, Object content ) {
		getList(key).add(content);
	}

	private List getList(Object key) {
		List l = (List)map.get(key);
		if ( l == null ) {
			l = new ArrayList();
			map.put(key, l);
		}
		return l;
	}

	public List get(Object key) {
		return getList(key);
	}
	
	public Set getKeys() {
		return map.keySet();
	}
	
}
