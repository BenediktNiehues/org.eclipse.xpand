/*******************************************************************************
 * Copyright (c) 2005-2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xpand.internal.tests;

import junit.framework.TestCase;

import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.xpand2.Generator;
import org.eclipse.xpand2.GeneratorAdvice;

public class GeneratorAdviceTest extends TestCase {
	private GeneratorTestImpl generator;
	private Issues issues;
	
	private GeneratorAdvice fixture;
	
	/**
	 * Provides access to tested protected methods
	 */
	class GeneratorTestImpl extends Generator {
		public final String _getFileEncoding () {
	    	return getFileEncoding();
	    }
	}
	
	public void setUp () {
		generator = new GeneratorTestImpl();
		issues = new IssuesImpl();
		fixture = new GeneratorAdvice();
	}
	
	private void assertNoErrorIssues () {
		assertTrue(issues.toString(), !issues.hasErrors());
	}
	
	public void testSetFileEncoding () throws Exception {
		assertNull(generator._getFileEncoding());
		fixture.setFileEncoding("ISO-8859-1");
		fixture.weave(generator, issues);
		assertNoErrorIssues();
		assertEquals("ISO-8859-1", generator._getFileEncoding());
	}
	
	public void testConfigError_noAdviceSet () throws Exception {
		fixture.checkConfiguration(issues);
		assertEquals("1 error expected", 1, issues.getErrors().length);
		issues = new IssuesImpl();
		fixture.addAdvice("testAdvice");
		assertNoErrorIssues();
	}
}
