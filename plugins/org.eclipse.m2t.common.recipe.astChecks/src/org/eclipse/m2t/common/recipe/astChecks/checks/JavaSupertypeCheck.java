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
package org.eclipse.m2t.common.recipe.astChecks.checks;

import org.eclipse.m2t.common.recipe.core.EvalTrigger;
import org.eclipse.m2t.common.recipe.util.EclipseCheck;

public class JavaSupertypeCheck extends EclipseCheck {
	
	private static final long serialVersionUID = 2L;
	
	public JavaSupertypeCheck(String message, String projectName, String className, String superInterfaceName ) {
		super( "resource exists", message, EvalTrigger.ON_CHANGE );
		setProjectName( projectName );
		setClassName( className );
		setSupertypeName( superInterfaceName );
	}

	private void setProjectName(String projectName) {
		setParameter( "projectName", projectName );
	}

	private void setClassName(String className) {
		setParameter( "className", className );
	}

	private void setSupertypeName(String superClassName) {
		setParameter( "supertypeName", superClassName );
	}
}
