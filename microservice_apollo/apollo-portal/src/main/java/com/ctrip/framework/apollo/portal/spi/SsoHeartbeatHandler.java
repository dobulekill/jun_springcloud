package com.ctrip.framework.apollo.portal.spi;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Wujun
 */
public interface SsoHeartbeatHandler {
  void doHeartbeat(HttpServletRequest request, HttpServletResponse response);
}
