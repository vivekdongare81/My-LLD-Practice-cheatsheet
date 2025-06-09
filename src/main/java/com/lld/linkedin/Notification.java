package com.lld.linkedin;

import java.util.Date;
import java.util.UUID;

public class Notification {
  private final String id;
  private final User targetUser;
  private final NotificationType type;
  private final String content;
  private final Date timestamp;

  public Notification(User targetUser, NotificationType type, String content) {
    super();
    this.id = UUID.randomUUID().toString();
    this.targetUser = targetUser;
    this.type = type;
    this.content = content;
    this.timestamp = new Date();
  }

  public String getId() {
    return id;
  }

  public User getTargetUser() {
    return targetUser;
  }

  public NotificationType getType() {
    return type;
  }

  public String getContent() {
    return content;
  }

  public Date getTimestamp() {
    return timestamp;
  }
}
