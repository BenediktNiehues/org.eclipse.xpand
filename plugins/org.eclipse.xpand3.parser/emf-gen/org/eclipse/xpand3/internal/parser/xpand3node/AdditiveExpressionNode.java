/**
 * <copyright>
 * </copyright>
 *
 * $Id: AdditiveExpressionNode.java,v 1.4 2008/03/13 08:40:01 jkohnlein Exp $
 */
package org.eclipse.xpand3.internal.parser.xpand3node;

import org.eclipse.emf.common.util.EList;

import org.eclipse.tmf.common.node.CompositeNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Additive Expression Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xpand3.internal.parser.xpand3node.AdditiveExpressionNode#getNexts <em>Nexts</em>}</li>
 *   <li>{@link org.eclipse.xpand3.internal.parser.xpand3node.AdditiveExpressionNode#getFirst <em>First</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xpand3.internal.parser.xpand3node.Xpand3nodePackage#getAdditiveExpressionNode()
 * @model
 * @generated
 */
public interface AdditiveExpressionNode extends CompositeNode {
	/**
	 * Returns the value of the '<em><b>Nexts</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.tmf.common.node.CompositeNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nexts</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nexts</em>' reference list.
	 * @see org.eclipse.xpand3.internal.parser.xpand3node.Xpand3nodePackage#getAdditiveExpressionNode_Nexts()
	 * @model
	 * @generated
	 */
	EList<CompositeNode> getNexts();

	/**
	 * Returns the value of the '<em><b>First</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First</em>' reference.
	 * @see #setFirst(CompositeNode)
	 * @see org.eclipse.xpand3.internal.parser.xpand3node.Xpand3nodePackage#getAdditiveExpressionNode_First()
	 * @model
	 * @generated
	 */
	CompositeNode getFirst();

	/**
	 * Sets the value of the '{@link org.eclipse.xpand3.internal.parser.xpand3node.AdditiveExpressionNode#getFirst <em>First</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First</em>' reference.
	 * @see #getFirst()
	 * @generated
	 */
	void setFirst(CompositeNode value);

} // AdditiveExpressionNode
