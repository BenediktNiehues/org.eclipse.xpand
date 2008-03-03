/**
 * <copyright> 
 *
 * Copyright (c) 2002-2007 itemis AG and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   itemis AG - Initial API and implementation
 *
 * </copyright>
 *
 */
package org.eclipse.xand3.analyzation.typesystem;

public interface Type extends AbstractNamed, TypeMirror {
	Type[] getSuperTypes();

	Feature[] getFeatures();
	Property[] getProperties();
	Operation[] getOperations();
	
	/**
	 * @return returns either the type this type is a bound instance of or just <code>this</code>, if the originally declared type wasn't generic
	 */
	DeclaredType getDeclaredType();
	
	TypeMirror[] getActualTypeArguments();
	
}
