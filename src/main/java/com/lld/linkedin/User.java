package com.lld.linkedin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
  private final String userId;
  private final String userName;
  private final String email;
  private String password;
  private Profile profile;
  private final List<Connection> connections;
  private final List<Message> inbox;
  private final List<Message> sentMessages;
  private final List<Notification> notifications;

  public User(String userName, String email, String password) {
    super();
    this.userId = UUID.randomUUID().toString();
    this.userName = userName;
    this.email = email;
    this.password = password;
    this.connections = new ArrayList<>();
    this.inbox = new ArrayList<>();
    this.sentMessages = new ArrayList<>();
    this.notifications = new ArrayList<>();
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }

  public String getUserId() {
    return userId;
  }

  public String getUserName() {
    return userName;
  }

  public String getEmail() {
    return email;
  }

  public List<Connection> getConnections() {
    return connections;
  }

  public List<Message> getInbox() {
    return inbox;
  }

  public List<Message> getSentMessages() {
    return sentMessages;
  }

  public List<Notification> getNotifications() {
    return notifications;
  }
}
