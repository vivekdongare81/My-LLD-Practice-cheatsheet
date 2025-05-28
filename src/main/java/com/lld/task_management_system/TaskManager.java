package com.lld.task_management_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class TaskManager {
  private static TaskManager instance;
  private final Map<String, User> users;
  private final Map<String, Task> tasks;

  private TaskManager() {
    this.users = new HashMap<>();
    this.tasks = new HashMap<>();
  }

  public static TaskManager getInstance() {
    if (instance == null) {
      synchronized (TaskManager.class) {
        if (instance == null) {
          instance = new TaskManager();
        }
      }
    }
    return instance;
  }

  public User createUser(String userName, String email) {
    User user = new User(UUID.randomUUID().toString(), userName, email);
    users.put(user.getId(), user);
    return user;
  }

  public void createTask(Task task) {
    tasks.put(task.getId(), task);
  }

  public void assignTask(String taskId, User user) {
    getTaskById(taskId).setAssignee(user);
  }

  public void assignSubTask(Task task, Task subTask) {
    task.getSubtasks().add(task);
  }

  public void updateTaskStatus(String taskId, TaskStatus status) {
    getTaskById(taskId).setStatus(status);
  }

  public void updateTaskPriority(String taskId, TaskPriority priority) {
    getTaskById(taskId).setPriority(priority);
  }

  public Task getTaskById(String taskId) {
    if (!tasks.containsKey(taskId)) {
      throw new RuntimeException("Task not found: " + taskId);
    }
    return tasks.get(taskId);
  }

  public void addComment(String taskId, String commentText, User author) {
    Task task = getTaskById(taskId);
    task.getComments().add((new Comment(commentText, author)));
  }

  public List<Task> listTasksByUser(User user) {
    return tasks
        .values()
        .stream()
        .filter(task -> user.equals(task.getAssignee()))
        .collect(Collectors.toList());
  }

  public List<Task> listTasksByStatus(TaskStatus status) {
    return tasks
        .values()
        .stream()
        .filter(task -> task.getStatus() == status)
        .collect(Collectors.toList());
  }

  public void deleteTask(String taskId) {
    tasks.remove(taskId);
  }

  public List<Task> searchTasks(String keyword) {
    List<Task> matchingTasks = new ArrayList<>();
    for (Task task : tasks.values()) {
      if (task.getTitle().contains(keyword) || task.getDescription().contains(keyword)) {
        matchingTasks.add(task);
      }
    }
    return matchingTasks;
  }
}
