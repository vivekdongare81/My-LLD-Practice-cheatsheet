package com.lld.linkedin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LinkedIn {
	private static LinkedIn instance;
	private final Map<String, User> users;
	private final Map<String, JobPost> jobs;

	private LinkedIn() {
		super();
		this.users = new ConcurrentHashMap<>();
		this.jobs = new ConcurrentHashMap<>();
	}

	public synchronized static LinkedIn getInstance() {
		if (instance == null) {
			instance = new LinkedIn();
		}
		return instance;
	}

	public User registerUser(String name, String email, String password) {
		User newUser = new User(name, email, password);
		users.put(newUser.getUserId(), newUser);
		return newUser;
	}

	public User loginUser(String email, String password) {// dummy authentication
		for (User user : users.values()) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	public void sendConnectionRequest(User sender, User receiver) {
		Connection connection = new Connection(sender, new Date());
		receiver.getConnections().add(connection);
		sendNotification(receiver, NotificationType.CONNECTION_ACCEPT,
				"New Connection request from " + sender.getUserName());
	}

	public void sendNotification(User receiver, NotificationType type, String content) {
		Notification notification = new Notification(receiver, type, content);
		receiver.getNotifications().add(notification);
	}

//  public void acceptConnectionRequest(User receiver, User sender) {
//	    boolean requestExists = receiver.getConnections().stream()
//	        .anyMatch(c -> c.getUser().equals(sender));
//
//	    if (requestExists) {
//	        // Add reverse connection
//	        boolean alreadyConnected = sender.getConnections().stream()
//	            .anyMatch(c -> c.getUser().equals(receiver));
//
//	        if (!alreadyConnected) {
//	        	sender.getConnections().add(new Connection(receiver, new Date()));
//	        }
//	    }
//	}

	public void acceptConnectionRequest(User user, User connectionUser) {
		for (Connection connection : user.getConnections()) {
			if (connection.getUser().equals(connectionUser)) {
				user.getConnections().add(new Connection(connectionUser, new Date()));
				break;
			}
		}
	}

	public List<User> searchUsers(String keyWord) {
		List<User> results = new ArrayList<User>();
		for (User user : users.values()) {
			if (user.getUserName().contains(keyWord)) {
				results.add(user);
			}
		}
		return results;
	}

	public JobPost postJobPost(String title, String company, String description, String location) {
		JobPost jobPost = new JobPost(title, company, description, location);
		jobs.put(jobPost.getJobId(), jobPost);
		return jobPost;
	}

	public List<JobPost> searchJobPosting(String keyword) {
		List<JobPost> results = new ArrayList<>();
		for (JobPost jobPosting : jobs.values()) {
			if (jobPosting.getTitle().contains(keyword) || jobPosting.getDescription().contains(keyword)) {
				results.add(jobPosting);
			}
		}
		return results;
	}

	public void sendMessage(User sender, User receiver, String content) {
		Message message = new Message(content, sender, receiver);
		receiver.getInbox().add(message);
		sender.getSentMessages().add(message);
		sendNotification(receiver, NotificationType.MESSAGE, "New message from " + sender.getUserName());
	}

	public List<Notification> getNotifications(String userId) {
		User user = users.get(userId);
		return user.getNotifications();
	}

	public Map<String, User> getUsers() {
		return users;
	}

	public Map<String, JobPost> getJobs() {
		return jobs;
	}

}
