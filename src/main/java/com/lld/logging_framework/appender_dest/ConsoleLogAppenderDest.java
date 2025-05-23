package com.lld.logging_framework.appender_dest;

import com.lld.logging_framework.LogFormatter;
import com.lld.logging_framework.Message;

public class ConsoleLogAppenderDest implements LogAppenderDest {

  private LogFormatter formatter;

  public ConsoleLogAppenderDest(LogFormatter formatter) {
    this.formatter = formatter;
  }

  @Override
  public void printLog(Message message) {
    System.out.println(formatter.format(message));
  }
}
