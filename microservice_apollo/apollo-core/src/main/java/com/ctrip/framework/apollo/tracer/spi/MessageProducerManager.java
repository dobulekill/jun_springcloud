package com.ctrip.framework.apollo.tracer.spi;

/**
 * @author Wujun
 */
public interface MessageProducerManager {
  /**
   * @return the message producer
   */
  MessageProducer getProducer();
}
