package com.lld.task_management_system;

import java.util.ArrayList;
import java.util.List;

public class User {
  private final String id;
  private final String userName;
  private final String email;
  private final List<Task> assignedTasks;

  public User(String id, String userName, String email) {
    this.id = id;
    this.userName = userName;
    this.email = email;
    this.assignedTasks = new ArrayList<>();
  }

  public void assignTask(Task task) {
	  assignedTasks.add(task);
  }
  
  /** @return the id */
  public String getId() {
    return id;
  }

  /** @return the userName */
  public String getUserName() {
    return userName;
  }

  /** @return the email */
  public String getEmail() {
    return email;
  }

  /** @return the assignedTasks */
  public List<Task> getAssignedTasks() {
    return assignedTasks;
  }
}
