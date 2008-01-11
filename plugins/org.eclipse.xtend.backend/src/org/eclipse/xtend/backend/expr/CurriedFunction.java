package org.eclipse.xtend.backend.expr;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtend.backend.common.BackendType;
import org.eclipse.xtend.backend.common.ExecutionContext;
import org.eclipse.xtend.backend.common.ExpressionBase;
import org.eclipse.xtend.backend.common.Function;


/**
 * 
 * @author Arno Haase (http://www.haase-consulting.com)
 */
final class CurriedFunction implements Function {
    private final Function _inner;
    private final boolean[] _isBound;
    private final Object[] _boundValue;
    private final List<BackendType> _paramTypes = new ArrayList<BackendType>();

    public CurriedFunction (Function inner, List<ExpressionBase> boundParams, ExecutionContext ctx) {
        _inner = inner;
        _isBound = new boolean[inner.getParameterTypes().size()];
        _boundValue = new Object[inner.getParameterTypes().size()];

        for (int i = 0; i < boundParams.size(); i++) {
            final ExpressionBase curParam = boundParams.get(i);

            if (curParam == null) {
                _paramTypes.add(inner.getParameterTypes().get(i));
            } else {
                _isBound[i] = true;
                _boundValue[i] = boundParams.get(i).evaluate(ctx);
            }
        }
    }

    public ExpressionBase getGuard () {
        return _inner.getGuard();
    }

    public List<? extends BackendType> getParameterTypes () {
        return _paramTypes;
    }

    public Object invoke (ExecutionContext ctx, Object[] params) {
        final List<Object> realParams = new ArrayList<Object>();

        int j = 0;
        for (int i = 0; i < _isBound.length; i++) {
            if (_isBound[i])
                realParams.add(_boundValue[i]);
            else
                realParams.add(params[j++]);
        }

        return ctx.getFunctionInvoker().invoke(ctx, _inner, realParams);
    }

    public boolean isCached () {
        return false;
    }
}
