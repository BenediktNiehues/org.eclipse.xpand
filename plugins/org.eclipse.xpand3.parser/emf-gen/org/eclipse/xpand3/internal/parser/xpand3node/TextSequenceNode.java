/**
 * <copyright>
 * </copyright>
 *
 * $Id: TextSequenceNode.java,v 1.3 2008/03/12 09:54:12 jkohnlein Exp $
 */
package org.eclipse.xpand3.internal.parser.xpand3node;

import org.eclipse.emf.common.util.EList;
import org.eclipse.tmf.common.node.CompositeNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Sequence Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xpand3.internal.parser.xpand3node.TextSequenceNode#getText <em>Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xpand3.internal.parser.xpand3node.Xpand3nodePackage#getTextSequenceNode()
 * @model
 * @generated
 */
public interface TextSequenceNode extends CompositeNode {

	/**
	 * Returns the value of the '<em><b>Text</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.tmf.common.node.CompositeNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' reference list.
	 * @see org.eclipse.xpand3.internal.parser.xpand3node.Xpand3nodePackage#getTextSequenceNode_Text()
	 * @model
	 * @generated
	 */
	EList<CompositeNode> getText();
} // TextSequenceNode
