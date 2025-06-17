package com.lld.pub_hub;

public class PrintSubscriber implements Subscriber{
	private final String name;

  public PrintSubscriber(String name) {
    super();
    this.name = name;
  }
	
  @Override
  public void consume(Message message) {
	  System.out.println("Printing message - "+message.getMessage());
  }
  
}
