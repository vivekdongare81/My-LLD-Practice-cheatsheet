package com.lld.logging_framework.appender_dest;

import com.lld.logging_framework.Message;

public interface LogAppenderDest {
  void printLog(Message message);
}
