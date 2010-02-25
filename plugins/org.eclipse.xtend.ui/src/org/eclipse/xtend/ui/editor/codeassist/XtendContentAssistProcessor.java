/*******************************************************************************
 * Copyright (c) 2005, 2009 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.xtend.ui.editor.codeassist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.internal.xpand2.codeassist.NamespaceProposalComputer;
import org.eclipse.internal.xtend.expression.codeassist.ExpressionProposalComputer;
import org.eclipse.internal.xtend.expression.codeassist.ExtensionImportProposalComputer;
import org.eclipse.internal.xtend.expression.codeassist.ProposalFactory;
import org.eclipse.internal.xtend.expression.codeassist.TypeProposalComputer;
import org.eclipse.internal.xtend.xtend.XtendFile;
import org.eclipse.internal.xtend.xtend.ast.Extension;
import org.eclipse.internal.xtend.xtend.codeassist.FastAnalyzer;
import org.eclipse.internal.xtend.xtend.codeassist.Partition;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.shared.ui.Activator;
import org.eclipse.xtend.shared.ui.core.IXtendXpandProject;
import org.eclipse.xtend.shared.ui.core.IXtendXpandResource;
import org.eclipse.xtend.shared.ui.expression.editor.codeassist.AbstractExtXptContentAssistProcessor;
import org.eclipse.xtend.shared.ui.expression.editor.codeassist.ProposalComparator;
import org.eclipse.xtend.ui.core.IXtendResource;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 */
public class XtendContentAssistProcessor extends AbstractExtXptContentAssistProcessor {

	public XtendContentAssistProcessor(final IEditorPart editor) {
		super(editor);
	}

	@Override
	protected ICompletionProposal[] internalComputeCompletionProposals(final ITextViewer viewer,
			final int documentOffset) {
		String part = viewer.getDocument().get().substring(0, documentOffset);
		ExecutionContext ctx = Activator.getExecutionContext(getJavaProject());
		final IXtendXpandResource res = Activator.getExtXptModelManager().findExtXptResource(getFile());
		List<Extension> extensions = new ArrayList<Extension>();
		if (res instanceof IXtendResource) {
			extensions = ((IXtendResource) res).getExtensions();
		}
		final Partition p = FastAnalyzer.computePartition(part);
		final ProposalFactory factory = new XtendProposalFactoryEclipseImpl(documentOffset);
		List<? extends ICompletionProposal> proposals = new ArrayList<ICompletionProposal>();
		if (p == Partition.EXPRESSION) {
			ctx = FastAnalyzer.computeExecutionContext(part, ctx, extensions);
			final int i = part.lastIndexOf(';');
			if (i != -1) {
				part = part.substring(i);
			}
			proposals = (List<? extends ICompletionProposal>) new ExpressionProposalComputer().computeProposals(part,
					ctx, factory);
		} else if (p == Partition.TYPE_DECLARATION) {
			ctx = FastAnalyzer.computeExecutionContext(part, ctx, extensions);
			proposals = (List<? extends ICompletionProposal>) new TypeProposalComputer().computeProposals(part, ctx,
					factory);
		} else if (p == Partition.EXTENSION_IMPORT) {
			IXtendXpandProject project = Activator.getExtXptModelManager().findProject(getFile());
			IXtendXpandResource[] resources = project.getAllRegisteredResources();
			Set<String> extensionNames = new HashSet<String>();
			for (IXtendXpandResource resource : resources) {
				if (resource instanceof XtendFile) {
					extensionNames.add(resource.getFullyQualifiedName());
				}
			}
			proposals = (List<? extends ICompletionProposal>) new ExtensionImportProposalComputer().computeProposals(
					part, ctx, factory, extensionNames);
		} else if (p == Partition.NAMESPACE_IMPORT) {
			ctx = FastAnalyzer.computeExecutionContext(part, ctx, extensions);
			proposals = (List<? extends ICompletionProposal>) new NamespaceProposalComputer().computeProposals(part, ctx, factory);
			
		}
		Collections.sort(proposals, new ProposalComparator());
		return proposals.toArray(new ICompletionProposal[proposals.size()]);
	}

	/**
	 * {@inheritDoc}
	 */
	public IContextInformation[] computeContextInformation(final ITextViewer viewer, final int documentOffset) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public char[] getCompletionProposalAutoActivationCharacters() {
		return new char[] { '.' };
	}

	/**
	 * {@inheritDoc}
	 */
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getErrorMessage() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}

}
