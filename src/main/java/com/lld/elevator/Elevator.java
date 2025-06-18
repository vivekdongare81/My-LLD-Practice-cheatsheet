package com.lld.elevator;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
  private final int id;              
  private final int capacity;         
  private int currentFloor;           
  private Direction direction;             
  private final List<Request> requests;     // Queue of requests (to be processed)

  public Elevator(int id, int capacity) {
    this.id = id;
    this.capacity = capacity;
    this.currentFloor = 0;               
    this.direction = Direction.UP;        
    this.requests = new ArrayList<>();   // shared data (if any method modifying this must be declared synchronized)
  }

  public synchronized void addRequest(Request request) {
      if (requests.size() < capacity) {     // Check if there's space for new request
          requests.add(request);
          System.out.println("Elevator " + id + " added request: " + request);
          notifyAll();                      // Wake up any waiting thread (elevator thread)
      }
  }

  // Gets the next request from queue (waits if empty)
  public synchronized Request getNextRequest() {
      while (requests.isEmpty()) {
          try {
              wait(); // Wait for a request to be added  - notifyAll (in addRequest)
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
      return requests.remove(0); // Remove the first request - queue
  }
  
  // Main loop that keeps processing requests forever (meant to be run in a thread)
  public synchronized void processRequests() {
      while (true) {
          while (!requests.isEmpty()) {         // If there are requests, keep processing
              Request request = getNextRequest(); // Get next request from queue
              processRequest(request);          // Handle elevator movement
          }
          try {
              wait(); // No requests left, wait until someone calls notifyAll (in addRequest)
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
  }

  // Simulate elevator movement toward the requested destination floor
  private void processRequest(Request request) {
      int startFloor = currentFloor;
      int endFloor = request.getDestinationFloor();

      if (startFloor < endFloor) {
          direction = Direction.UP;
          for (int i = startFloor; i <= endFloor; i++) {
              currentFloor = i;
              System.out.println("Elevator " + id + " reached floor " + currentFloor);
              try {
                  Thread.sleep(1000); // Simulate time taken to move between floors
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      } else if (startFloor > endFloor) {
          direction = Direction.DOWN;
          for (int i = startFloor; i >= endFloor; i--) {
              currentFloor = i;
              System.out.println("Elevator " + id + " reached floor " + currentFloor);
              try {
                  Thread.sleep(1000); // Simulate time taken to move between floors
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      }
      // If start == end, no movement is needed
  }

  // run the elevator thread logic
  public void run() {
	  processRequests(); // Keeps running forever
  }

  public int getCurrentFloor() {
      return currentFloor;
  }

  public Direction getDirection() {
      return direction;
  }

  public void setCurrentFloor(int currentFloor) {
    this.currentFloor = currentFloor;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public int getId() {
    return id;
  }

  public int getCapacity() {
    return capacity;
  }

  public List<Request> getRequests() {
    return requests;
  }
}
