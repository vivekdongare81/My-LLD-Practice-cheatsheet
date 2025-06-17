package com.lld.pub_hub;

import java.util.Date;
import java.util.UUID;

public class Message {
  private final String id;
  private String content;
  private Date createdTime;

  public Message(String content) {
    super();
    this.id = UUID.randomUUID().toString();
    this.content = content;
    this.createdTime = new Date();
  }

  public String getMessage() {
    return this.content;
  }
}
