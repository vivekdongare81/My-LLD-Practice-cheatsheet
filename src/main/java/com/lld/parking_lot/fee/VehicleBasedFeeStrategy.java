package com.lld.parking_lot.fee;

import java.util.Map;

import com.lld.parking_lot.Ticket;
import com.lld.parking_lot.vehicle.VehicleType;

public class VehicleBasedFeeStrategy implements FeeStrategy {

  private final Map<VehicleType, Double> PER_HOUR_RATE =
      Map.of(
          VehicleType.BIKE, 10d,
          VehicleType.CAR, 20d,
          VehicleType.TRUCK, 30d);

  @Override
  public double operateStrategy(Ticket ticket) {
    double duration = ticket.getExitTimestamp() - ticket.getEntryTimestamp();
    double timeSpent = PER_HOUR_RATE.get(ticket.getVehicle().getVehicleType());
    return duration * timeSpent;
  }
}
