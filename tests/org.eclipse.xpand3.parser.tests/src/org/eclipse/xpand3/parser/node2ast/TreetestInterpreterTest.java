package org.eclipse.xpand3.parser.node2ast;

import java.io.UnsupportedEncodingException;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.tmf.common.node.Node;
import org.eclipse.tmf.common.treetest.AbstractEcoreTreeTestInterpreter;
import org.eclipse.xpand3.parser.Xpand3NodeLexer;
import org.eclipse.xpand3.parser.Xpand3NodeParser;

public class TreetestInterpreterTest extends AbstractEcoreTreeTestInterpreter {

	public void testStatement() throws Throwable {
		test("org/eclipse/xpand3/parser/node2ast/statement.ttst");
	}

	protected EObject parseAndTransform(String testExpressionBody)
			throws RecognitionException, UnsupportedEncodingException {
		System.out.println("Expression:" + testExpressionBody);
		ANTLRStringStream stream = new ANTLRStringStream(testExpressionBody);
		Xpand3NodeLexer lexer = new Xpand3NodeLexer(stream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		Xpand3NodeParser xpand3NodeParser = new Xpand3NodeParser(tokenStream);

		Node rootNode = xpand3NodeParser.r_file();
		if (rootNode == null) {
			System.out.println("Nothing parsed.");
			return null;
		}
		Node2AstTransformer node2AstTransformer = new Node2AstTransformer();
		return node2AstTransformer.doSwitch(rootNode);
	}

}
