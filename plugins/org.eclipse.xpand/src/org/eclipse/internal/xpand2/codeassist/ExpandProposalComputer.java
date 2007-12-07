/*
 * <copyright>
 *
 * Copyright (c) 2005-2007 Sven Efftinge (http://www.efftinge.de) and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge (http://www.efftinge.de) - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.internal.xpand2.codeassist;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.internal.xpand2.model.XpandDefinition;
import org.eclipse.internal.xtend.expression.codeassist.ProposalComputer;
import org.eclipse.internal.xtend.expression.codeassist.ProposalFactory;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtend.expression.ExecutionContext;

public class ExpandProposalComputer implements ProposalComputer {
	private final static Pattern p = FastAnalyzer.EXPAND_PATTERN;

	public List<Object> computeProposals(final String txt, final ExecutionContext ctx, final ProposalFactory factory) {
		final List<Object> result = new ArrayList<Object>();

		Matcher m = p.matcher(txt);
		if (m.find()) {
			String prefix = m.group(1);
			if (ctx instanceof XpandExecutionContext) {
				XpandExecutionContext xpandCtx = (XpandExecutionContext) ctx;
				List<XpandDefinition> allDefinitions = xpandCtx.getAllDefinitions();
				if (allDefinitions != null) {
					for (XpandDefinition xpandDefinition : allDefinitions) {
						String defineName = xpandDefinition.getName();
						result.add(factory.createDefinitionProposal(defineName, defineName, prefix));
					}
				}
			}
		}

		return result;
	}
}
