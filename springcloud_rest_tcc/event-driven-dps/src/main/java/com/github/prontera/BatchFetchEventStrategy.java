package com.github.prontera;

import com.github.prontera.domain.EventPublisher;
import com.github.prontera.persistence.EventPublisherMapper;

import java.util.Set;

/**
 * @author Wujun
 */
public interface BatchFetchEventStrategy {
    Set<EventPublisher> execute(EventPublisherMapper mapper);
}
