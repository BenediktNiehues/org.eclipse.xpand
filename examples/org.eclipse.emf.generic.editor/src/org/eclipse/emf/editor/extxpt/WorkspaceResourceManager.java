/**
 * <copyright> 
 *
 * Copyright (c) 2008 itemis AG and others.
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
package org.eclipse.emf.editor.extxpt;

import org.eclipse.xtend.expression.Resource;
import org.eclipse.xtend.expression.ResourceManager;
import org.eclipse.xtend.expression.ResourceParser;
import org.eclipse.xtend.shared.ui.core.IXtendXpandProject;
import org.eclipse.xtend.shared.ui.core.IXtendXpandResource;

/**
 * @author Dennis Huebner
 * 
 */
public class WorkspaceResourceManager implements ResourceManager {

	private IXtendXpandProject project;

	public WorkspaceResourceManager(IXtendXpandProject p) {
		this.project = p;
	}

	public Resource loadResource(String fullyQualifiedName, String extension) {
		IXtendXpandResource extxptResource = project.findExtXptResource(fullyQualifiedName, extension);
		if (extxptResource != null)
			return extxptResource.getExtXptResource();
		return null;
	}

	public void registerParser(String template_extension, ResourceParser parser) {
		// not needed
	}

	public void setFileEncoding(String fileEncoding) {
		// not needed
	}

}
