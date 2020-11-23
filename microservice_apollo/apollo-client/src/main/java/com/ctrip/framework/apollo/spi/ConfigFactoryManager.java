package com.ctrip.framework.apollo.spi;

/**
 * @author Wujun
 */
public interface ConfigFactoryManager {
  /**
   * Get the config factory for the namespace.
   *
   * @param namespace the namespace
   * @return the config factory for this namespace
   */
  public ConfigFactory getFactory(String namespace);
}
