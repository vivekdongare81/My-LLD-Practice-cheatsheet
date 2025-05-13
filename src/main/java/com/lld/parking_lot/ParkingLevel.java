package com.lld.parking_lot;

import java.util.ArrayList;
import java.util.List;

import com.lld.parking_lot.vehicle.VehicleType;

public class ParkingLevel {
  private final int levelID;
  private List<ParkingSpot> spots;

  public ParkingLevel(int levelID) {
    this.levelID = levelID;
    this.spots = new ArrayList<>();
  }

  public void addSlot(ParkingSpot spot) {
    this.spots.add(spot);
  }

  public List<Integer> getAvailableSpotNumbers(VehicleType vehicleType) {
    List<Integer> vehicleSpots = new ArrayList<>();
    for (ParkingSpot s : spots) {
      if (s.getVehicleType() == vehicleType && s.isAvailable()) {
        vehicleSpots.add(s.getSpotID());
      }
    }
    return vehicleSpots;
  }

  public synchronized ParkingSpot getFirstAvailableSpot(VehicleType vehicleType) { // can use - Optional Java 8
    for (ParkingSpot s : spots) {
      if (s.getVehicleType() == vehicleType && s.isAvailable()) {
        return s;
      }
    }
    return null;
  }

  // ------------------

  public int getLevelID() {
    return this.levelID;
  }

  public List<ParkingSpot> getParkingSpots() {
    return this.spots;
  }
}
