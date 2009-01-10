/*******************************************************************************
 * Copyright (c) 2005-2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.internal.xtend.expression.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sven Efftinge (http://www.efftinge.de)
 * @author Arno Haase
 */
public class Identifier extends SyntaxElement {
	private String value;
	private List<Identifier> follows = new ArrayList<Identifier>();

	public Identifier(final String value) {
		this.value = value;
	}

	public Identifier append(final Identifier t) {
		this.follows.add(t);
		return this;
	}

	private String fullVal = null;

	public String getValue() {
		if (fullVal == null) {
			StringBuffer buff = new StringBuffer(internalGetText());
			for (Identifier id : follows) {
				buff.append(id.getValue());
			}
			fullVal = buff.toString();
		}
		return fullVal;
	}

	private String internalGetText() {
		if (value.startsWith("^"))
			return value.substring(1);
		return value;
	}

	@Override
	public int getEnd() {
		if (!follows.isEmpty())
			return follows.get(follows.size() - 1).getEnd();
		return super.getEnd();
	}

	@Override
	public String toString() {
		return getValue();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Identifier other = (Identifier) obj;
		return getValue().equals(other.getValue());
	}

}
