/**
 * <copyright>
 * </copyright>
 *
 * $Id: Model.java,v 1.2 2008/03/13 11:37:06 sefftinge Exp $
 */
package org.eclipse.xpand3.staticTypesystem;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xpand3.staticTypesystem.Model#getDeclarations <em>Declarations</em>}</li>
 *   <li>{@link org.eclipse.xpand3.staticTypesystem.Model#getFunctionDeclarations <em>Function Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xpand3.staticTypesystem.StaticTypesystemPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject {
	/**
	 * Returns the value of the '<em><b>Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xpand3.staticTypesystem.DeclaredType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declarations</em>' containment reference list.
	 * @see org.eclipse.xpand3.staticTypesystem.StaticTypesystemPackage#getModel_Declarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<DeclaredType> getDeclarations();

	/**
	 * Returns the value of the '<em><b>Function Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xpand3.staticTypesystem.DeclaredFunction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Declarations</em>' containment reference list.
	 * @see org.eclipse.xpand3.staticTypesystem.StaticTypesystemPackage#getModel_FunctionDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<DeclaredFunction> getFunctionDeclarations();

} // Model
