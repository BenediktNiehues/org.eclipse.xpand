/*******************************************************************************
 * <copyright>
 * Copyright (c) 2008 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * committers of openArchitectureWare - initial API and implementation
 * </copyright>
 *******************************************************************************/

package org.eclipse.xpand3.frontend.parser;

import static org.eclipse.xpand3.frontend.parser.SyntaxUtil.LG;
import static org.eclipse.xpand3.frontend.parser.SyntaxUtil.RG;
import junit.framework.TestCase;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.eclipse.tmf.common.node.Node;
import org.eclipse.xpand3.internal.frontend.parser.Xpand3NodeLexer;
import org.eclipse.xpand3.internal.frontend.parser.Xpand3NodeParser;
import org.eclipse.xpand3.internal.frontend.parser.Xpand3NodeLexer;
import org.eclipse.xpand3.internal.frontend.parser.Xpand3NodeParser;

/**
 * @author Jan K�hnlein
 */
public class Xpand3NodeParserTest extends TestCase {

	private Node parse(String s) throws Exception {
		Xpand3NodeParser parser = createParser(s);
		Node rootNode = parser.r_file();
		return rootNode;
	}

	public void testname() throws Exception {
		Node x = parse(LG + "IMPORT foo" + RG
				+ "import foo; myFunction(String this) : doStuff('holla');"
				+ LG + "DEFINE foo FOR Entity" + RG + "bla" + LG + "ENDDEFINE"
				+ RG);
		System.out.println(x.toDebugString());
	}

	public void testFoo() throws Exception {
		Node node = parse("import foo; myFunction(String this) : doStuff('holla');");
		System.out.println(node.toDebugString());
		System.out.println(node.serialize());
	}

	public void testXpandXtendCheckMixedUp1() throws Exception {
		Node node = parse(LG + "IMPORT foo" + RG
				+ "import foo; myFunction(String this) : doStuff('holla');"
				+ LG + "DEFINE foo FOR Entity" + RG + "bla" + LG + "ENDDEFINE"
				+ RG);
		System.out.println(node.toDebugString());
		System.out.println(node.serialize());
	}

	//	
	public void testPerf() throws Exception {
		String s = "foo.bar.honolulu('lola',{true,false,45}).collect(e|2.minor + 34 / (x - 2))";
		for (int i = 0; i < 10; i++) {
			s = s + " -> " + s;
		}
		Xpand3NodeParser parser = createParser(s);
		long n = System.currentTimeMillis();
		parser.r_expression();
		long after = System.currentTimeMillis();
		System.out.println("Time : " + (after - n) / 1000.
				+ " Expressionlength was : " + s.length());
	}

	private Xpand3NodeParser createParser(String s) {
		ANTLRStringStream stream = new ANTLRStringStream(s);
		Xpand3NodeLexer lexer = new Xpand3NodeLexer(stream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		Xpand3NodeParser parser = new Xpand3NodeParser(tokenStream);
		return parser;
	}
}
