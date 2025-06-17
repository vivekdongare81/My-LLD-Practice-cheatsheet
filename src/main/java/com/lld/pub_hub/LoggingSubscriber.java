package com.lld.pub_hub;

public class LoggingSubscriber implements Subscriber{
	private final String name;

  public LoggingSubscriber(String name) {
    super();
    this.name = name;
  }
	
  @Override
  public void consume(Message message) {
	  System.out.println("Logging message - "+message.getMessage());
  }
  
}