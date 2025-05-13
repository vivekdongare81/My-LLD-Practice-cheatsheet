package com.lld.parking_lot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import com.lld.parking_lot.fee.*;
import com.lld.parking_lot.vehicle.Vehicle;

// Double Lock SINGLETON
public class ParkingLot {
  private static ParkingLot parkingLot;
  private List<ParkingLevel> parkingLevels;
  private Map<String, Ticket> activeTickets;
  private FeeStrategyContext feeStratContext;

  private ParkingLot() {
    this.parkingLevels = new ArrayList<>();
    this.activeTickets = new HashMap<>();
  }

  public static ParkingLot getInstance() {
    if (parkingLot == null) {
      synchronized (ParkingLot.class) {
        if (parkingLot == null) {
          parkingLot = new ParkingLot();
        }
      }
    }
    return parkingLot;
  }

  public void addParkingLevel(ParkingLevel level) {
    this.parkingLevels.add(level);
  }

  public void setFeeStrategy(FeeStrategy feeStrategy) {
    this.feeStratContext = new FeeStrategyContext(feeStrategy);
  }

  public List<ParkingLevel> getParkingLevels() {
    return this.parkingLevels;
  }

  public synchronized Ticket park(Vehicle vehicle) throws Exception {
    for (ParkingLevel level : parkingLevels) {
      // can use Optional Java8
      ParkingSpot spot = level.getFirstAvailableSpot(vehicle.getVehicleType());
      if (spot != null && spot.park(vehicle)) {

        String ticketID = UUID.randomUUID().toString();

        Ticket ticket = new Ticket(ticketID, spot, vehicle);
        activeTickets.put(ticketID, ticket);
        return ticket;
      }
    }
    throw new Exception("Spot not available for " + vehicle.getVehicleType());
  }

  public synchronized double unPark(String ticketID) throws Exception {
    Ticket ticket = activeTickets.remove(ticketID);
    if (ticket == null) {
      throw new Exception("Invalid Ticket");
    }
    ParkingSpot spot = ticket.getSpot();
    spot.unpark();
    ticket.setExitTime();
    return feeStratContext.executeStrategy(ticket);
  }

}
