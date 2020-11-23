package com.ctrip.framework.apollo.exceptions;

/**
 * @author Wujun
 */
public class ApolloConfigStatusCodeException extends RuntimeException{
  private final int m_statusCode;

  public ApolloConfigStatusCodeException(int statusCode, String message) {
    super(String.format("[status code: %d] %s", statusCode, message));
    this.m_statusCode = statusCode;
  }

  public int getStatusCode() {
    return m_statusCode;
  }
}
