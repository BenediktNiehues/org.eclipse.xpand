/*
 * <copyright>
 *
 * Copyright (c) 2005-2006 Markus Voelter and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Markus Voelter - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.m2t.common.recipe.io;

public class CannotLoadChecksException extends Exception {

	private static final long serialVersionUID = -3320322651465524260L;

	public CannotLoadChecksException() {
		super();
	}
	
	public CannotLoadChecksException( Exception ex ) {
		super( ex );
	}
	
	
}
