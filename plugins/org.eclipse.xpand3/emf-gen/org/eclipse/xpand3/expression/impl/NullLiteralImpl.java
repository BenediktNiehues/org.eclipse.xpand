/**
 * <copyright>
 * </copyright>
 *
 * $Id: NullLiteralImpl.java,v 1.1 2008/02/27 13:21:08 sefftinge Exp $
 */
package org.eclipse.xpand3.expression.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.xpand3.expression.ExpressionPackage;
import org.eclipse.xpand3.expression.NullLiteral;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Null Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class NullLiteralImpl extends LiteralImpl implements NullLiteral {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NullLiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.NULL_LITERAL;
	}

} //NullLiteralImpl
