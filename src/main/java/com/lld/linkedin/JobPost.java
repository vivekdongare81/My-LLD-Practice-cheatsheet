package com.lld.linkedin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.lld.linkedin.observer.NotificationObserver;
import com.lld.linkedin.observer.NotificationSubject;

public class JobPost implements NotificationSubject {
	private final String jobId;
	private final String title;
	private final String companyName;
	private final String description;
	private final String location;
	private final Date postDate;
	private final Map<String, User> applicants;
	private List<NotificationObserver> observers = new ArrayList<>(); // Added observers list

	public JobPost(String title, String companyName, String description, String location) {
		super();
		this.jobId = UUID.randomUUID().toString();
		this.title = title;
		this.companyName = companyName;
		this.description = description;
		this.location = location;
		this.postDate = new Date();
		this.applicants = new ConcurrentHashMap<>();
	}

	public void apply(User user) {
		if (applicants.containsKey(user.getUserId())) {
			throw new IllegalArgumentException("User has already applied to the job");
		}
		applicants.put(user.getUserId(), user);
	}

	public String getJobId() {
		return jobId;
	}

	public String getTitle() {
		return title;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getDescription() {
		return description;
	}

	public String getLocation() {
		return location;
	}

	public Date getPostDate() {
		return postDate;
	}

	public List<User> getApplicants() {// modify default method
		return applicants.values().stream().toList();
	}

	@Override
	public void addObserver(NotificationObserver observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(NotificationObserver observer) {
		observers.add(observer);
	}

	@Override
	public void notifyObeservers(String message) {
		for (NotificationObserver observer : observers) {
			observer.update(message);
		}
	}
}
