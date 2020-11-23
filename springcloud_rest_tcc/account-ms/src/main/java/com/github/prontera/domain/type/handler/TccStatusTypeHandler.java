package com.github.prontera.domain.type.handler;

import com.github.prontera.domain.type.TccStatus;

/**
 * @author Wujun
 */
public class TccStatusTypeHandler extends GenericTypeHandler<TccStatus> {
    @Override
    public int getEnumIntegerValue(TccStatus parameter) {
        return parameter.getStatus();
    }
}
