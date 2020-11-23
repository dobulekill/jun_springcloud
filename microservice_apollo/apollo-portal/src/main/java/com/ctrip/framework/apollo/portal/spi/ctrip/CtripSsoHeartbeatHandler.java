package com.ctrip.framework.apollo.portal.spi.ctrip;

import com.ctrip.framework.apollo.portal.spi.SsoHeartbeatHandler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Wujun
 */
public class CtripSsoHeartbeatHandler implements SsoHeartbeatHandler {
  @Override
  public void doHeartbeat(HttpServletRequest request, HttpServletResponse response) {
    try {
      response.sendRedirect("ctrip_sso_heartbeat.html");
    } catch (IOException e) {
    }
  }
}
