/*
Copyright (c) 2008 Arno Haase.
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html

Contributors:
    Arno Haase - initial API and implementation
 */
package org.eclipse.xtend.middleend.old.internal.xtendlib;


/**
 * 
 * @author Arno Haase (http://www.haase-consulting.com)
 */
public interface XtendLibNames {
    String FOREACH_WITHOUT_ITERATOR = "XpandForEach";
    String FOREACH_WITH_ITERATOR = "XpandForEachWithIterator";
    
    String DELETE_LINE_INIT = "XpandInitNewScope";
    String DELETE_LINE_REGISTER = "XpandRegisterDeleteLine";
    String DELETE_LINE_POSTPROCESS = "XpandPostprocess";
    
    String GLOBAL_VAR_VALUE = "XtendGlobalVar";
}
