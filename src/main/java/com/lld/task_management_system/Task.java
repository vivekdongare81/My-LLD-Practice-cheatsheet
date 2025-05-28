package com.lld.task_management_system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task {
  private final String id;
  private String title;
  private String description;
  private User assignee;
  private TaskStatus status;
  private TaskPriority priority;
  private Date createdDate;
  private Date dueDate;
  private final List<Comment> comments;
  private final List<Task> subtasks;

  public Task(
      String id,
      String title,
      String description,
      Date dueDate,
      TaskPriority priority,
      User assignee) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.dueDate = dueDate;
    this.priority = priority;
    this.status = TaskStatus.TODO;
    this.assignee = assignee;
    this.comments = new ArrayList<>();
    this.subtasks = new ArrayList<>();
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public User getAssignee() {
    return assignee;
  }

  public void setAssignee(User assignee) {
    this.assignee = assignee;
  }

  public TaskStatus getStatus() {
    return status;
  }

  public void setStatus(TaskStatus status) {
    this.status = status;
  }

  public TaskPriority getPriority() {
    return priority;
  }

  public void setPriority(TaskPriority priority) {
    this.priority = priority;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public Date getDueDate() {
    return dueDate;
  }

  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }

  public String getId() {
    return id;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public List<Task> getSubtasks() {
    return subtasks;
  }
}
