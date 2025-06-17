package com.lld.pub_hub;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Broker {
    private final Map<String, Topic> topics = new ConcurrentHashMap<>();

    public void createTopic(String name) {
        topics.putIfAbsent(name, new Topic(name));
    }
    
    public void subscribe(String topic, Subscriber subscriber) {
    	Topic savedTopic = topics.get(topic);
    	if(savedTopic == null) {
    		throw new IllegalArgumentException("Topic not found - "+ topic);
    	}
    	savedTopic.addSubscriber(subscriber);
    }
    
    public void unsubscribe(String topic, Subscriber subscriber) {
    	Topic savedTopic = topics.get(topic);
    	if(savedTopic == null) {
    		throw new IllegalArgumentException("Topic not found - "+ topic);
    	}
    	savedTopic.removeSubscriber(subscriber);
    }
    
	public void publish(String topic, Message message) {
    	Topic savedTopic = topics.get(topic);
    	if(savedTopic == null) {
    		throw new IllegalArgumentException("Topic not found - "+ topic);
    	}
    	savedTopic.broadcast(message);
	}
	
}
