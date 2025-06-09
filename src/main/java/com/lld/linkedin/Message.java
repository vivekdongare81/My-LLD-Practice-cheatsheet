package com.lld.linkedin;

import java.util.Date;
import java.util.UUID;

public class Message {
  private final String messageId;
  private String content;
  private final User sender;
  private final User receiver;
  private final Date timeStamp;

  public Message(String content, User sender, User receiver) {
    this.messageId = UUID.randomUUID().toString();
    this.content = content;
    this.sender = sender;
    this.receiver = receiver;
    this.timeStamp = new Date();
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getMessageId() {
    return messageId;
  }

  public User getSender() {
    return sender;
  }

  public User getReceiver() {
    return receiver;
  }

  public Date getTimeStamp() {
    return timeStamp;
  }
}
