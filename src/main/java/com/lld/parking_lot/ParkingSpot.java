package com.lld.parking_lot;

import com.lld.parking_lot.vehicle.Vehicle;
import com.lld.parking_lot.vehicle.VehicleType;

public class ParkingSpot {
  private final int spotID;
  private Vehicle vehicle;
  private VehicleType vehicleType;
  private boolean isEmpty;

  public ParkingSpot(int spotID, VehicleType vehicleType) {
    this.spotID = spotID;
    this.vehicleType = vehicleType;
    this.isEmpty = true;
  }

  public boolean isAvailable() {
    return isEmpty;
  }

  public boolean park(Vehicle vehicle) {
    if (!isEmpty || vehicle.getVehicleType() != vehicleType) {
      return false;
    }
    this.vehicle = vehicle;
    this.isEmpty = false;
    return true;
  }

  public void unpark() {
    this.vehicle = null;
    this.isEmpty = true;
  }

  public int getSpotID() {
    return this.spotID;
  }
  // ------------------
  public Vehicle getVehicle() {
    return this.vehicle;
  }

  public VehicleType getVehicleType() {
    return this.vehicleType;
  }
}
