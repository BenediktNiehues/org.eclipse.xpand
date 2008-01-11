package org.eclipse.xtend.backend.common;

import java.util.Collection;
import java.util.List;


/**
 * A FunctionDefContext is roughly the backend representation of a compilation unit - it stands for all
 *  functions that are visible from a given point in the code, and every function knows the FunctionDefContext
 *  that is valid within its body.
 *  
 * @author Arno Haase (http://www.haase-consulting.com)
 */
public interface FunctionDefContext {
    Object invoke (ExecutionContext ctx, String functionName, List<? extends Object> params);
    
    /**
     * for reflection. This method returns separately registered functions, not those "built into" the
     *  type.
     */
    Collection<NamedFunction> getByFirstParameterType (BackendType firstParameterType); 
    
    /**
     * for reflection. This method returns all functions, both those built-into the types and those
     *  registered separately.
     */
    Function getMatch (ExecutionContext ctx, String name, List<BackendType> params);
    
    /**
     * for dynamic matching, e.g. to determine if a function should be called on a collection itself or
     *  on all of its members. This method matches against all functions, both those built into the
     *  types and those registered separately.
     */
    boolean hasMatch (ExecutionContext ctx, String functionName, List<? extends Object> params);
}
