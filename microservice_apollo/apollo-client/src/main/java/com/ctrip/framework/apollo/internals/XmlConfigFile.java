package com.ctrip.framework.apollo.internals;

import com.ctrip.framework.apollo.core.enums.ConfigFileFormat;

/**
 * @author Wujun
 */
public class XmlConfigFile extends PlainTextConfigFile {
  public XmlConfigFile(String namespace,
                       ConfigRepository configRepository) {
    super(namespace, configRepository);
  }

  @Override
  public ConfigFileFormat getConfigFileFormat() {
    return ConfigFileFormat.XML;
  }
}
