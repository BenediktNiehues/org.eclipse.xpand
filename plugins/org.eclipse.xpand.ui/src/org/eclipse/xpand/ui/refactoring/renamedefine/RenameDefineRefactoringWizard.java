/*******************************************************************************
 * Copyright (c) 2005 - 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.xpand.ui.refactoring.renamedefine;

import org.eclipse.ltk.ui.refactoring.RefactoringWizard;

/**
 * ExtractDefineRefactoringWizard TODO insert class purpose here!
 * 
 * @author Peter Friese
 */
public class RenameDefineRefactoringWizard extends RefactoringWizard {

	public RenameDefineRefactoringWizard(RenameDefineRefactoring refactoring) {
		super(refactoring, RefactoringWizard.DIALOG_BASED_USER_INTERFACE | RefactoringWizard.PREVIEW_EXPAND_FIRST_NODE);
		setDefaultPageTitle("Rename Define");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void addUserInputPages() {
		addPage(new RenameDefineRefactoringWizardPage("Rename Define Refactoring"));
	}

}
