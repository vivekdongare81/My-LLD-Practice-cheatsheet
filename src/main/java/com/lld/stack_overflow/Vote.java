package com.lld.stack_overflow;

public class Vote {
  private final User voter;
  private final VoteType voteType;

  public Vote(User user, VoteType voteType) {
    this.voter = user;
    this.voteType = null;
  }
  
  ////////////// 
  public User getVoter() { return voter; }
  public VoteType getType() { return voteType; } 
}
