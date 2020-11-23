package com.ctrip.framework.apollo.biz.message;

/**
 * @author Wujun
 */
public interface MessageSender {
  void sendMessage(String message, String channel);
}
