package com.lld.parking_lot;

import com.lld.parking_lot.vehicle.Vehicle;
import java.util.*;

public class Ticket {
  private final String ticketID;
  private final ParkingSpot spot;
  private final Vehicle vehicle;
  private final long entryTimestamp;
  private long exitTimestamp;

  public Ticket(String ticketID, ParkingSpot spot, Vehicle vehicle) {
    this.spot = spot;
    this.ticketID = ticketID;
    this.vehicle = vehicle;
    this.entryTimestamp = new Date().getTime();
  }

  public void setExitTime() {
    this.exitTimestamp = new Date().getTime();
  }
  // --------------

  public long getExitTimestamp() {
    return exitTimestamp;
  }

  public String getTicketID() {
    return ticketID;
  }

  public ParkingSpot getSpot() {
    return spot;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public long getEntryTimestamp() {
    return entryTimestamp;
  }
}
