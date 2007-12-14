/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.xpand.ui.editor;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "org.eclipse.core.utils.messages"; //$NON-NLS-1$

    public static String xpand;

    static {
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

}
