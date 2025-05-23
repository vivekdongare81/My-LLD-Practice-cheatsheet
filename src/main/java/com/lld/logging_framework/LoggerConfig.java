package com.lld.logging_framework;

import com.lld.logging_framework.appender_dest.LogAppenderDest;

public class LoggerConfig {
  private Level level;
  private LogAppenderDest logAppenderDest;

  public LoggerConfig(Level level, LogAppenderDest logAppenderDest) {
    this.level = level;
    this.logAppenderDest = logAppenderDest;
  }

  public Level getLevel() {
    return level;
  }

  public void setLevel(Level level) {
    this.level = level;
  }

  public LogAppenderDest getLogAppenderDest() {
    return logAppenderDest;
  }

  public void setLogAppenderDest(LogAppenderDest logAppenderDest) {
    this.logAppenderDest = logAppenderDest;
  }
}
