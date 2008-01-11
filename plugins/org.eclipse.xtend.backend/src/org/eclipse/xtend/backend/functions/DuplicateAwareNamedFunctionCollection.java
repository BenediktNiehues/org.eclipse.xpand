package org.eclipse.xtend.backend.functions;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.xtend.backend.common.NamedFunction;
import org.eclipse.xtend.backend.util.Cache;


/**
 * This class collects functions. It removes an old one if a new one with identical signature is
 *  added, allowing overwriting. The check for "identical signature" is performed only if both
 *  functions have no guard. Functions with guards are never treated as having the same signature
 *  because an equality check would then require comparison of guards, a tricky undertaking which
 *  is left for a future version. 
 *  
 * @author Arno Haase (http://www.haase-consulting.com)
 */
public final class DuplicateAwareNamedFunctionCollection {
    private final Collection<NamedFunction> _allFunctions = new HashSet<NamedFunction>();
    private final Cache<String, Collection<NamedFunction>> _byName = new Cache<String, Collection<NamedFunction>> () {
        @Override
        protected Collection<NamedFunction> create (String key) {
            return new HashSet<NamedFunction>();
        }
    };

    /**
     * registers a function and returns the old function of the same signature if one was replaced, and null otherwise 
     */
    public NamedFunction register (NamedFunction f) {
        NamedFunction result = null;
        
        for (NamedFunction candidate: _byName.get (f.getName())) {
            if (haveSameSignature (f, candidate)) {
                _byName.get (f.getName()).remove (candidate);
                _allFunctions.remove (candidate);
                result = candidate;
                break;
            }
        }
        
        _byName.get (f.getName()).add (f);
        _allFunctions.add (f);
        return result;
    }
    
    
    /**
     * checks if this collection already contains a function with identical signature. 
     */
    public boolean contains (NamedFunction f) {
        for (NamedFunction candidate: _byName.get (f.getName()))
            if (haveSameSignature(f, candidate))
                return true;
        
        return false;
    }

    
    public Collection<NamedFunction> getFunctions () {
        return _allFunctions;
    }
    
    
    /**
     * helper operation to compare two functions.
     */
    public static boolean haveSameSignature (NamedFunction f1, NamedFunction f2) {
        if (f1.getFunction().getGuard() != null || f2.getFunction().getGuard() != null)
            return false;

        if (! f1.getName().equals (f2.getName()))
            return false;
        
        return f1.getFunction().getParameterTypes().equals (f2.getFunction().getParameterTypes());
    }
} 

