package org.eclipse.xpand3.parser;

import java.util.Set;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.eclipse.xpand3.node.CompositeNode;
import org.eclipse.xpand3.node.LeafNode;
import org.eclipse.xpand3.node.LexedToken;
import org.eclipse.xpand3.node.Node;
import org.eclipse.xpand3.node.NodeFactory;

public abstract class AbstractXpand3NodeParser extends Xpand3Parser {

	private CompositeNode current = null;
	private CompositeNode rootNode = null;

	public AbstractXpand3NodeParser(TokenStream input) {
		super(input);
		setTreeAdaptor(new CommonTreeAdaptor() {
			@Override
			public Object create(Token arg0) {
				if (arg0 != null)
					createLexedToken((CommonToken) arg0);
				return super.create(arg0);
			}
		});
	}

	protected abstract Set<String> normalizableRules();

	public void ruleStart(String rulename) {
		CompositeNode newOne = NodeFactory.eINSTANCE.createCompositeNode();
		newOne.setRule(rulename);
		if (current != null) {
			current.getChildren().add(newOne);
		} else {
			rootNode = newOne;
		}
		current = newOne;
	}

	public void ruleEnd() {
		CompositeNode parent = (CompositeNode) current.eContainer();
		if (normalizableRules().contains(current.getRule())
				&& current.getChildren().size() == 1
				&& (current.getChildren().get(0) instanceof CompositeNode)) {
			Node child = current.getChildren().get(0);
			int i = parent.getChildren().indexOf(current);
			parent.getChildren().remove(i);
			parent.getChildren().add(i, child);
		}
		current = parent;
	}

	@Override
	public void reportError(RecognitionException arg0) {
		throw new RuntimeException(getErrorMessage(arg0, getTokenNames()), arg0);
	}

	public void createLexedToken(CommonToken ct) {
		LeafNode n = NodeFactory.eINSTANCE.createLeafNode();
		current.getChildren().add(n);
		LexedToken myToken = NodeFactory.eINSTANCE.createLexedToken();
		n.setToken(myToken);
		myToken.setText(ct.getText());
		myToken.setStart(ct.getStartIndex());
		myToken.setEnd(ct.getStopIndex());
		myToken.setLine(ct.getLine());
	}

	public Node getRootNode() {
		return rootNode;
	}

}