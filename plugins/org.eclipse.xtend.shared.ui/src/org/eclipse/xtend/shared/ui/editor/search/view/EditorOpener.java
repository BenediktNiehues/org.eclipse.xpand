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
package org.eclipse.xtend.shared.ui.editor.search.view;

import org.eclipse.core.resources.IFile;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IReusableEditor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtend.shared.ui.Activator;

/**
 * <code>EditorOpener</code> helps opening a file in the associated editor.
 */
public class EditorOpener {

	private IEditorPart fEditor;

	public IEditorPart open(final IFile file, final boolean activate) throws PartInitException {
		final IWorkbenchPage wbPage = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();
		if (NewSearchUI.reuseEditor())
			return showWithReuse(file, wbPage, activate);
		return showWithoutReuse(file, wbPage, activate);
	}

	private IEditorPart showWithoutReuse(final IFile file, final IWorkbenchPage wbPage, final boolean activate)
			throws PartInitException {
		return IDE.openEditor(wbPage, file, activate);
	}

	private IEditorPart showWithReuse(final IFile file, final IWorkbenchPage wbPage, final boolean activate)
			throws PartInitException {
		final String editorID = getEditorID(file);
		return showInEditor(wbPage, file, editorID, activate);
	}

	private String getEditorID(final IFile file) throws PartInitException {
		final IEditorDescriptor desc = IDE.getEditorDescriptor(file);
		if (desc == null)
			return Activator.getDefault().getWorkbench().getEditorRegistry().findEditor(
					IEditorRegistry.SYSTEM_EXTERNAL_EDITOR_ID).getId();
		return desc.getId();
	}

	private boolean isPinned(final IEditorPart editor) {
		if (editor == null)
			return false;

		final IEditorReference[] editorRefs = editor.getEditorSite().getPage().getEditorReferences();
		int i = 0;
		while (i < editorRefs.length) {
			if (editor.equals(editorRefs[i].getEditor(false)))
				return editorRefs[i].isPinned();
			i++;
		}
		return false;
	}

	private IEditorPart showInEditor(final IWorkbenchPage page, final IFile file, final String editorId,
			final boolean activate) throws PartInitException {
		final IFileEditorInput input = new FileEditorInput(file);
		IEditorPart editor = page.findEditor(input);
		if (editor != null) {
			page.bringToTop(editor);
			if (activate) {
				page.activate(editor);
			}
		}
		else {
			boolean isOpen = false;
			if (fEditor != null) {
				final IEditorReference[] parts = page.getEditorReferences();
				int i = 0;
				while (!isOpen && i < parts.length) {
					isOpen = fEditor == parts[i++].getEditor(false);
				}
			}

			final boolean canBeReused = isOpen && !fEditor.isDirty() && !isPinned(fEditor);
			final boolean showsSameInputType = fEditor != null && fEditor.getSite().getId().equals(editorId);
			if (canBeReused && !showsSameInputType) {
				page.closeEditor(fEditor, false);
				fEditor = null;
			}

			if (canBeReused && showsSameInputType) {
				((IReusableEditor) fEditor).setInput(input);
				page.bringToTop(fEditor);
				editor = fEditor;
				if (activate) {
					page.activate(editor);
				}
			}
			else {
				editor = IDE.openEditor(page, file, activate);
				if (editor instanceof IReusableEditor) {
					fEditor = editor;
				}
				else {
					fEditor = null;
				}
			}
		}
		return editor;
	}

}
