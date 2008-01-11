package org.eclipse.xtend.backend.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.xtend.backend.util.Pair;


/**
 * 
 * @author Arno Haase (http://www.haase-consulting.com)
 */
public class ExecutionException extends RuntimeException {
    private final List<Pair<SourcePos, Map<String, Object>>> _stackTrace = new ArrayList<Pair<SourcePos,Map<String,Object>>> ();
    
    
    public ExecutionException (Exception exc) {
        super (exc);
    }
    
    
    public ExecutionException (Exception exc, SourcePos sourcePos, Map<String, Object> localVars) {
        super (exc);
        addStackTraceElement (sourcePos, localVars);
    }
    
    public void addStackTraceElement (SourcePos sourcePos, Map<String, Object> localVars) {
        _stackTrace.add (new Pair<SourcePos, Map<String, Object>> (sourcePos, localVars));
    }
    
    @Override
    public String getMessage () {
        final StringBuilder result = new StringBuilder ();
        
        result.append (getCause().getMessage() + "\n");
        for (Pair<SourcePos, Map<String, Object>> ste: _stackTrace)
            result.append ("at " + ste.getFirst() + " " + ste.getSecond() + "\n");
        
        return result.toString();
    }
}
