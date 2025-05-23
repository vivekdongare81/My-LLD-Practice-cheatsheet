package com.lld.logging_framework;

public class DefaultLogFormatter implements LogFormatter {

  @Override
  public String format(Message msg) {
    return String.format(
        "[%s] [%s] [%s] %s",
        msg.getTimeStamp(), msg.getThreadName(), msg.getLogLevel(), msg.getMessage());
  }
}
