package com.github.prontera;

import lombok.Value;

/**
 * @author Wujun
 */
@Value
public class MessageRoute {
    private String exchange;

    private String routeKey;
}
