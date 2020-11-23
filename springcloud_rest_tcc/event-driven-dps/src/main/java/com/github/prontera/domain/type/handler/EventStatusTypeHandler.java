package com.github.prontera.domain.type.handler;

import com.github.prontera.domain.type.EventStatus;

/**
 * @author Wujun
 */
public class EventStatusTypeHandler extends GenericTypeHandler<EventStatus> {
    @Override
    public int getEnumIntegerValue(EventStatus parameter) {
        return parameter.getStatus();
    }
}
