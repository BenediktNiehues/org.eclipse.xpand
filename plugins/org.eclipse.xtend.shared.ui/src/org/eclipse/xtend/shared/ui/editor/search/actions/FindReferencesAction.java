/*******************************************************************************
 * Copyright (c) 2005 - 2007 committers of openArchitectureWare and others. All
 * rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: committers of openArchitectureWare - initial API and
 * implementation
 ******************************************************************************/
package org.eclipse.xtend.shared.ui.editor.search.actions;

import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.xtend.shared.ui.core.IXtendXpandProject;
import org.eclipse.xtend.shared.ui.editor.AbstractXtendXpandEditor;
import org.eclipse.xtend.shared.ui.editor.search.query.OawSearchReferencesQuery;
import org.eclipse.xtend.shared.ui.expression.editor.EditorImages;

/**
 * Finds references to the selected element in the workspace. The action is
 * applicable to selections representing an oAW element.
 * 
 * This class may be instantiated; it is not intended to be subclassed.
 */
public class FindReferencesAction extends FindAction {

	/**
	 * Creates a new {@link FindDeclarationsAction}.
	 * 
	 * @param editor
	 *            The oAW editor.
	 */
	public FindReferencesAction(AbstractXtendXpandEditor editor) {
		super(editor);
	}

	/**
	 * Creates a new {@link FindDeclarationsAction}.
	 * 
	 * @param site
	 *            The workbench site that owns this action.
	 */
	public FindReferencesAction(IWorkbenchSite site) {
		super(site);
	}

	@Override
	void init() {
		setText("&Project");
		setToolTipText("Search for References of the Selected Element in the selected Project");
		setImageDescriptor(EditorImages.getImageDescriptor(EditorImages.SEARCH_REFERENCES));
	}

	@Override
	protected ISearchQuery createSearchQuery(String selectedText, IXtendXpandProject project) {
		ISearchQuery query = new OawSearchReferencesQuery(project, selectedText);
		return query;
	}
}
