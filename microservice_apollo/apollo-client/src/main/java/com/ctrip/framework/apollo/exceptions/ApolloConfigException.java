package com.ctrip.framework.apollo.exceptions;

/**
 * @author Wujun
 */
public class ApolloConfigException extends RuntimeException {
  public ApolloConfigException(String message) {
    super(message);
  }

  public ApolloConfigException(String message, Throwable cause) {
    super(message, cause);
  }
}
