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


package org.eclipse.xtend.ui.editor;

import org.eclipse.xtend.shared.ui.editor.AbstractXtendXpandEditor;
import org.eclipse.xtend.shared.ui.editor.outlineview.AbstractExtXptContentOutlinePage;
import org.eclipse.xtend.ui.editor.outline.XtendContentOutlinePage;

public class XtendEditor extends AbstractXtendXpandEditor {

    public XtendEditor() {
        setSourceViewerConfiguration(new XtendSourceViewerConfiguration(this));
        setDocumentProvider(new XtendDocumentProvider());
    }

    @Override
    protected AbstractExtXptContentOutlinePage createOutlinePage() {
        return new XtendContentOutlinePage(this);
    }

	@Override
	protected void initializeKeyBindingScopes() {
		setKeyBindingScopes(new String[] { "org.eclipse.xtend.editor.XtendEditorScope" }); //$NON-NLS-1$
	}
}
