package com.lld.parking_lot.fee;

import com.lld.parking_lot.Ticket;

public class FixedBasedFeeStratgey implements FeeStrategy {

  private final Double FIXED_RATE = 10d;

  @Override
  public double operateStrategy(Ticket ticket) {
    double duration = ticket.getExitTimestamp() - ticket.getEntryTimestamp();
    return duration * FIXED_RATE;
  }
}
