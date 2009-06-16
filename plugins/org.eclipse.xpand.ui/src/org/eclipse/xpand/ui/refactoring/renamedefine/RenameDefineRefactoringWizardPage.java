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

import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xpand.ui.Messages;

public class RenameDefineRefactoringWizardPage extends UserInputWizardPage {

	private Text newNameText;

	public RenameDefineRefactoringWizardPage(String name) {
		super(name);
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		container.setLayout(gridLayout);
		//
		setControl(container);

		final Label newNameLabel = new Label(container, SWT.NONE);
		newNameLabel.setText(Messages.RenameDefineRefactoringWizardPage_label);
		newNameText = new Text(container, SWT.BORDER);
		newNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				updateNewNameAndValidate(newNameText.getText());
			}

		});
		final GridData gd_newNameText = new GridData(SWT.FILL, SWT.CENTER,
				true, false);
		newNameText.setLayoutData(gd_newNameText);
		String initialText = renameDefineProcessor().getSelection().getText();
		newNameText.setText(initialText);// set selected text as initial value,
											// validation will be triggered
		newNameText.setFocus();
	}

	private void updateNewNameAndValidate(String newName) {
		// set name
		RenameDefineProcessor renameDefineProcessor = renameDefineProcessor();
		renameDefineProcessor.setNewName(newName);
		// set valid status
		setPageComplete(renameDefineProcessor.validateNewName());
	}

	private RenameDefineProcessor renameDefineProcessor() {
		RenameDefineRefactoring renameDefineRefactoring = (RenameDefineRefactoring) getRefactoring();
		RenameDefineProcessor renameDefineProcessor = (RenameDefineProcessor) renameDefineRefactoring
				.getProcessor();
		return renameDefineProcessor;
	}
}
