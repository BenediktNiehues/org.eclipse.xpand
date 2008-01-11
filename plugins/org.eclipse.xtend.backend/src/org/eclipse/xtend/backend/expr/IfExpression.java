package org.eclipse.xtend.backend.expr;

import org.eclipse.xtend.backend.common.ExecutionContext;
import org.eclipse.xtend.backend.common.ExpressionBase;
import org.eclipse.xtend.backend.common.SourcePos;


/**
 * 
 * @author Arno Haase (http://www.haase-consulting.com)
 */
public final class IfExpression extends ExpressionBase {
    private final ExpressionBase _cond, _if, _else;

    public IfExpression (ExpressionBase cond, ExpressionBase ifResult, ExpressionBase elseResult, SourcePos sourcePos) {
        super (sourcePos);
        
        _cond = cond;
        _if = ifResult;
        _else = elseResult;
    }

    @Override
    public Object evaluateInternal (ExecutionContext ctx) {
        final Object cond = _cond.evaluate(ctx);
        
        if (cond == null) {
            ctx.logNullDeRef (getPos());
            return null;
        }
        
        if (Boolean.TRUE.equals (cond))
            return _if.evaluate(ctx);
        else
            return _else.evaluate(ctx);
    }
}
