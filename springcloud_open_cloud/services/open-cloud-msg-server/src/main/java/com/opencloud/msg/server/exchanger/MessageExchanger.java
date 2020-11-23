package com.opencloud.msg.server.exchanger;


import com.opencloud.msg.client.model.BaseMessage;

/**
 * @author Wujun
 */

public interface MessageExchanger {

    boolean support(Object message);

    boolean exchange(BaseMessage message);
}
