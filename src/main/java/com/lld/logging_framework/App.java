package com.lld.logging_framework;

import com.lld.logging_framework.appender_dest.ConsoleLogAppenderDest;
import com.lld.logging_framework.appender_dest.LogAppenderDest;

public class App {
  public static void main(String[] args) {

    Logger logger = Logger.getInstance();
    
    logger.info("hello");

    LogAppenderDest dest = new ConsoleLogAppenderDest(new DefaultLogFormatter());
    LoggerConfig config = new LoggerConfig(Level.WARNING, dest);
    logger.setLoggerConfig(config);

    logger.warning("hello warning");
  }
}
