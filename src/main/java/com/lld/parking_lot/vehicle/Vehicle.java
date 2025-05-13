package com.lld.parking_lot.vehicle;

public abstract class Vehicle {
  private final String licenceID;
  private final VehicleType vehicleType;

  public Vehicle(String licenceID, VehicleType vehicleType) {
    this.licenceID = licenceID;
    this.vehicleType = vehicleType;
  }

  public String getLicenceID() {
    return this.licenceID;
  }

  public VehicleType getVehicleType() {
    return this.vehicleType;
  }
}
