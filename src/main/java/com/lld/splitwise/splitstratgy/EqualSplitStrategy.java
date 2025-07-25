package com.lld.splitwise.splitstratgy;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lld.splitwise.Split;
import com.lld.splitwise.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EqualSplitStrategy implements SplitStrategy {
    @Override
    public List<Split> calculateSplits(Map<User, Double> splitData, double totalAmount) {
        int numberOfUsers = splitData.size();
        double equalAmount = totalAmount / numberOfUsers;

        List<Split> splits = new ArrayList<>();
        for (User user : splitData.keySet()) {
            splits.add(new Split(user, equalAmount));
        }

        return splits;
    }
}
