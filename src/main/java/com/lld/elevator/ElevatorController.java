package com.lld.elevator;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
	private final List<Elevator> elevators;
	
	public ElevatorController(int numElevators, int capacity) {
		elevators = new ArrayList<Elevator>();
		for (int i = 0; i < numElevators; i++) {
            Elevator elevator = new Elevator(i + 1, capacity);
            elevators.add(elevator);
            new Thread(elevator::run).start();
        }
	}
	
	public void requestElevator(int sourceFloor, int destFloor) {
        Elevator optimalElevator = findOptimalElevator(sourceFloor, destFloor);
        optimalElevator.addRequest(new Request(sourceFloor, destFloor));
	}
	
	private Elevator findOptimalElevator(int sourceFloor, int destFloor) {
        Elevator optimalElevator = null;
        int minDistance = Integer.MAX_VALUE;
        //first preference to direction.
        Direction userDirection = (sourceFloor - destFloor) > 0 ? Direction.DOWN : Direction.UP;
        
        List<Elevator> optimalElevators = elevators.stream().anyMatch(e -> e.getDirection() == userDirection) ?
        		elevators.stream().filter(e -> e.getDirection() == userDirection).toList() : elevators;
        
        for (Elevator elevator : optimalElevators) {
            int distance = Math.abs(sourceFloor - elevator.getCurrentFloor());
            if (distance < minDistance) {
                minDistance = distance;
                optimalElevator = elevator;
            }
        }
        return optimalElevator;
	}
}
