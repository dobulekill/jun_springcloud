package com.ctrip.framework.apollo.biz.message;

import com.ctrip.framework.apollo.biz.entity.ReleaseMessage;

/**
 * @author Wujun
 */
public interface ReleaseMessageListener {
  void handleMessage(ReleaseMessage message, String channel);
}
