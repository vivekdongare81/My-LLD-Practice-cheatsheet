package com.lld.linkedin.observer;

public interface NotificationSubject {
	void addObserver(NotificationObserver observer);
	void removeObserver(NotificationObserver observer);
	void notifyObeservers(String message);
}
