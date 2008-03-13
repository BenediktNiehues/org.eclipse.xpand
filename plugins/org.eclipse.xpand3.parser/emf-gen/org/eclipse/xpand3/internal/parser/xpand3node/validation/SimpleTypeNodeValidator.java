/**
 * <copyright>
 * </copyright>
 *
 * $Id: SimpleTypeNodeValidator.java,v 1.4 2008/03/13 08:40:00 jkohnlein Exp $
 */
package org.eclipse.xpand3.internal.parser.xpand3node.validation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.tmf.common.node.CompositeNode;

/**
 * A sample validator interface for {@link org.eclipse.xpand3.internal.parser.xpand3node.SimpleTypeNode}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface SimpleTypeNodeValidator {
	boolean validate();

	boolean validateNames(EList<CompositeNode> value);
}
