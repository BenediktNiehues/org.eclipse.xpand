package org.eclipse.xtend.backend.common;


/**
 * This interface allows an interested party to register as a listener for the
 *  execution of code in the backend. The model is slightly different from the
 *  typical listener usage in that there are no "rich" events. Instead, just the
 *  current ExecutionContext is passed as a parameter.<br>
 *  
 * So there is no data that would allow the identification of the sender or a 
 *  specific receiver. The intended usage model is that the middle end registers
 *  a specific ExecutionListener instance per backend element that takes care of
 *  these mapping issues.  
 * 
 * @author Arno Haase (http://www.haase-consulting.com)
 */
public interface ExecutionListener {
    void preExecute (ExecutionContext ctx);
    void postExecute (Object result, ExecutionContext ctx);
}
