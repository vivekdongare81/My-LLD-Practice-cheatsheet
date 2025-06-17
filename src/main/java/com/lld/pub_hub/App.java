package com.lld.pub_hub;

public class App {
  public static void main(String[] args) {
	  // Create Broker 
	  Broker broker = new Broker();
	  
      // Create Topics
      broker.createTopic("topic1");
      broker.createTopic("topic2");
      
      // Create publishers
      Publisher pub1 = new Publisher("pub1", broker);
      Publisher pub2 = new Publisher("pub2", broker);
      
      //Create Subscriber
      Subscriber sub1 = new PrintSubscriber("sub1"); 
      Subscriber sub2 = new PrintSubscriber("sub2"); 
      Subscriber sub3 = new LoggingSubscriber("sub1"); 

      broker.subscribe("topic2", sub1);	
      broker.subscribe("topic2", sub2);
      broker.subscribe("topic2", sub3);	
      
      //Publish Messages
      pub1.publish("topic2", "hi this is foir topic2 subscribers");
  }
}
