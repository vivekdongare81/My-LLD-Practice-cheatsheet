package com.lld.parking_lot.fee;

import com.lld.parking_lot.Ticket;

public class FeeStrategyContext {
  private FeeStrategy strategy;

  public FeeStrategyContext(FeeStrategy strategy) {
    this.strategy = strategy;
  }

  public double executeStrategy(Ticket ticket) {
    return strategy.operateStrategy(ticket);
  }
  // --------
  public FeeStrategy getCurrStrategy() {
    return this.strategy;
  }
}
