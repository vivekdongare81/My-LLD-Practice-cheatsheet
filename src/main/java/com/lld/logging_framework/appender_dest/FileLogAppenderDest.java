package com.lld.logging_framework.appender_dest;

import java.io.FileWriter;
import java.io.IOException;

import com.lld.logging_framework.LogFormatter;
import com.lld.logging_framework.Message;

public class FileLogAppenderDest implements LogAppenderDest {

  private FileWriter writer;
  private final LogFormatter formatter;

  public FileLogAppenderDest(String filePath, LogFormatter formatter) {
    this.formatter = formatter;
    try {
      this.writer = new FileWriter(filePath, true);
    } catch (Exception e) {
      System.out.println("Failed to create writer for file logs, exception: " + e.getMessage());
    }
  }

  @Override
  public void printLog(Message message) {
    try {
      writer.write(formatter.format(message));
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }
}
