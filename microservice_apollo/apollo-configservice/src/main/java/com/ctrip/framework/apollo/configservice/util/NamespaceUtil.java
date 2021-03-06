package com.ctrip.framework.apollo.configservice.util;

import org.springframework.stereotype.Component;

/**
 * @author Wujun
 */
@Component
public class NamespaceUtil {

  public String filterNamespaceName(String namespaceName) {
    if (namespaceName.toLowerCase().endsWith(".properties")) {
      int dotIndex = namespaceName.lastIndexOf(".");
      return namespaceName.substring(0, dotIndex);
    }

    return namespaceName;
  }
}
