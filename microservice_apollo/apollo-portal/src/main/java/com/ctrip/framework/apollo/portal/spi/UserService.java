package com.ctrip.framework.apollo.portal.spi;

import com.ctrip.framework.apollo.portal.entity.bo.UserInfo;

import java.util.List;
import java.util.Set;

/**
 * @author Wujun
 */
public interface UserService {
  List<UserInfo> searchUsers(String keyword, int offset, int limit);

  UserInfo findByUserId(String userId);

  List<UserInfo> findByUserIds(List<String> userIds);

}
