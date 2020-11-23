package com.ctrip.framework.apollo.internals;

import com.ctrip.framework.apollo.core.enums.ConfigFileFormat;

/**
 * @author Wujun
 */
public class YmlConfigFile extends PlainTextConfigFile {
  public YmlConfigFile(String namespace, ConfigRepository configRepository) {
    super(namespace, configRepository);
  }

  @Override
  public ConfigFileFormat getConfigFileFormat() {
    return ConfigFileFormat.YML;
  }
}
