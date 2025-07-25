package com.lld.splitwise.splitstratgy;


import java.util.List;
import java.util.Map;

import com.lld.splitwise.Split;
import com.lld.splitwise.User;

public interface SplitStrategy {
    List<Split> calculateSplits(Map<User, Double> splitData, double totalAmount);
}