package com.lld.pub_hub;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Topic {
  private final String title;
  private final Set<Subscriber> subscribers = new CopyOnWriteArraySet<>();

  public Topic(String title) {
    super();
    this.title = title;
  }

  public void addSubscriber(Subscriber subscriber) {
    subscribers.add(subscriber);
  }

  public void removeSubscriber(Subscriber subscriber) {
    subscribers.remove(subscriber);
  }

  public void broadcast(Message message) {
    for (Subscriber subscriber : subscribers) {
      Dispatcher.dispatch(subscriber, message);
    }
  }

  public String getTitle() {
    return title;
  }

  public Set<Subscriber> getSubscribers() {
    return subscribers;
  }
}
