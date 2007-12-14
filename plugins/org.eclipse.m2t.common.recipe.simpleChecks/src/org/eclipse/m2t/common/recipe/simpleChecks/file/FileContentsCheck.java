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

package org.eclipse.m2t.common.recipe.simpleChecks.file;

import org.eclipse.m2t.common.recipe.eval.EvaluationContext;

public class FileContentsCheck extends FileExistenceCheck {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2263478102108307800L;
	private String substring;

	public FileContentsCheck( String message, String absoluteFileName, String substr ) {
		super( message, absoluteFileName );
		setSubstring( substr );
	}
	
	private void setSubstring(String substr) {
		this.substring = substr;
		setParameter( "substring", substring );
	}

	public void evaluate(EvaluationContext ctx) {
		super.evaluate(ctx);
		FileContentsHelper.checkContent( this, absoluteFileName, substring );
	}



}
