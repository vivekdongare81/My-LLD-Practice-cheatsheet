package com.lld.logging_framework;

import com.lld.logging_framework.appender_dest.ConsoleLogAppenderDest;

public class Logger {
  private static final Logger instance = new Logger(); // singleton

  private LoggerConfig loggerConfig;

  private Logger() {
    // Private constructor to enforce singleton pattern
    loggerConfig =
        new LoggerConfig(Level.INFO, new ConsoleLogAppenderDest(new DefaultLogFormatter()));
  }

  public static Logger getInstance() {
    return instance;
  }

  public void log(Level level, String message) {

    // if (level.ordinal() >= loggerConfig.getLevel().ordinal()) {
    Message logMessage = new Message(level, message);
    loggerConfig.getLogAppenderDest().printLog(logMessage);
    // }
  }

  public void info(String message) {
    log(Level.INFO, message);
  }

  public void error(String message) {
    log(Level.ERROR, message);
  }

  public void warning(String message) {
    log(Level.WARNING, message);
  }

  public void fatal(String message) {
    log(Level.FATAL, message);
  }

  ////////////////
  public LoggerConfig getLoggerConfig() {
    return loggerConfig;
  }

  public void setLoggerConfig(LoggerConfig loggerConfig) {
    this.loggerConfig = loggerConfig;
  }
}
