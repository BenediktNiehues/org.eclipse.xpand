/*******************************************************************************
 * Copyright (c) 2005-2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.internal.xtend.expression.ast;

import org.eclipse.xtend.expression.ExecutionContext;

public abstract class SyntaxElement implements ISyntaxElement {
	protected int start;

	protected int end;

	protected int line;

	public SyntaxElement() {
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLine() {
		return line;
	}

	public int getEnd() {
		return end;
	}

	public int getStart() {
		return start;
	}

	private String fileName;

	public void setFileName(final String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public String getNameString(ExecutionContext context) {
		return toString();
	}
	
	public final Object accept(final AbstractVisitor visitor) {
        return visitor.visit(this);
    }
}
