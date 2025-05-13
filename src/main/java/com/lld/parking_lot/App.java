package com.lld.parking_lot;

import com.lld.parking_lot.fee.VehicleBasedFeeStrategy;
import com.lld.parking_lot.vehicle.*;

public class App {
  public static void main(String[] args) {

    // ------- CREATE PARKING LOT
    ParkingLot parkingLot = ParkingLot.getInstance();
    parkingLot.setFeeStrategy(new VehicleBasedFeeStrategy());
    
    ParkingLevel level1 = new ParkingLevel(1);
    level1.addSlot(new ParkingSpot(1, VehicleType.BIKE));
    level1.addSlot(new ParkingSpot(2, VehicleType.BIKE));
    level1.addSlot(new ParkingSpot(3, VehicleType.CAR));

    ParkingLevel level2 = new ParkingLevel(2);
    level2.addSlot(new ParkingSpot(1, VehicleType.BIKE));
    level2.addSlot(new ParkingSpot(2, VehicleType.BIKE));

    parkingLot.addParkingLevel(level1);
    parkingLot.addParkingLevel(level2);

    System.out.println("Empty Slots are:");
    for (ParkingLevel level : parkingLot.getParkingLevels()) {
      System.out.println(level.getAvailableSpotNumbers(VehicleType.BIKE));
      System.out.println(level.getAvailableSpotNumbers(VehicleType.CAR));
      System.out.println(level.getAvailableSpotNumbers(VehicleType.TRUCK));
      System.out.println("-----");
    }

    Vehicle bike1 = new Bike("BikeLicence1");
    Vehicle car1 = new Car("CarLicence1");
    Vehicle car2 = new Car("CarLicence2");

    try {
      // ------- PARK & CREATE TICKET

      Ticket t1 = parkingLot.park(bike1);
      System.out.println("parked "+t1.getVehicle().getVehicleType() +" "+"ticket - "+t1.getTicketID());
      Ticket t2 = parkingLot.park(car1);
      System.out.println("parked "+t2.getVehicle().getVehicleType()+" "+"ticket - "+t2.getTicketID());
      
      // ------- UnPARK & Get FEES
      Thread.sleep(10000);//wait to calc fees for 10 sec
      
      double fees1 = parkingLot.unPark(t1.getTicketID());
      System.out.println("unparked with fees "+fees1);
      
      double fees2 = parkingLot.unPark(t2.getTicketID());
      System.out.println("unparked with fees "+fees2);
      
    } catch (Exception e) {
      System.out.println("Exception: " + e.getMessage());
    }
  }
}
