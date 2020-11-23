package com.ctrip.framework.apollo.core.schedule;

/**
 * Schedule policy
 * @author Wujun
 */
public interface SchedulePolicy {
  long fail();

  void success();
}
