package com.lld.splitwise.splitstratgy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lld.splitwise.Split;
import com.lld.splitwise.User;

public class PercentageSplitStrategy implements SplitStrategy {
    @Override
    public List<Split> calculateSplits(Map<User, Double> splitData, double totalAmount) {
        double sum = splitData.values().stream().mapToDouble(Double::doubleValue).sum();

        if (Math.abs(sum - 100.0) > 1e-6) {
            throw new IllegalArgumentException("Total percentage must be 100.");
        }

        List<Split> splits = new ArrayList<>();
        for (Map.Entry<User, Double> entry : splitData.entrySet()) {
            double percentage = entry.getValue();
            double amount = (totalAmount * percentage) / 100.0;
            splits.add(new Split(entry.getKey(), amount));
        }

        return splits;
    }
}