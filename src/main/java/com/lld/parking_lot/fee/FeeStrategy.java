package com.lld.parking_lot.fee;

import com.lld.parking_lot.Ticket;

public interface FeeStrategy {
  public double operateStrategy(Ticket ticket);
}
