package com.lld.logging_framework;

import java.util.*;

public class Message {
  private Level logLevel;
  private String message;
  private long timeStamp;
  private String threadName;

  public Message(Level logLevel, String message) {
    this.logLevel = logLevel;
    this.message = message;
    this.timeStamp = System.currentTimeMillis();
    this.threadName = Thread.currentThread().getName();
  }

  public Level getLogLevel() {
    return logLevel;
  }

  public void setLogLevel(Level logLevel) {
    this.logLevel = logLevel;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public long getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(long timeStamp) {
    this.timeStamp = timeStamp;
  }

  public String getThreadName() {
    return threadName;
  }

  public void setThreadName(String threadName) {
    this.threadName = threadName;
  }
}
