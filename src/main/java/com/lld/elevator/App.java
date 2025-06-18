package com.lld.elevator;

public class App {
	public static void main(String[] args) {
		// start 5 elevators
		ElevatorController elevatorController = new ElevatorController(5, 10);
		
		elevatorController.requestElevator(1, 5); // 1 -> 5
		elevatorController.requestElevator(3, 1); // 1 -> 5

	}	
}
