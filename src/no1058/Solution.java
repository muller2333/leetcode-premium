package no1058;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String minimizeError(String[] prices, int target) {
        double res = 0;
        List<Double> greater = new ArrayList<>();
        List<Double> smaller = new ArrayList<>();
        int count = 0;
        double sum = 0;
        double min = 0;
        double max = 0;
        for (String s : prices) {
            double n = Double.parseDouble(s);
            double floor = Math.floor(n);
            min += floor;
            if (floor == n) {
                sum += n;
                max += n;
            } else {
                double diff = floor + 0.5 - n;
                max += floor + 1;
                if (diff == 0) {
                    count++;
                    sum += floor;
                    res += 0.5d;
                } else if (diff > 0) {
                    smaller.add(floor * 2d + 1d - n * 2d);
                    res += n - floor;
                    sum += floor;
                } else {
                    greater.add(n * 2d - floor * 2d - 1d);
                    res += floor + 1d - n;
                    sum += floor + 1d;
                }
            }
        }
        if (min > target || max < target) {
            return "-1";
        }
        List<Double> list;
        int diff;
        if (sum < target) {
            diff = (int) (target - sum);
            list = smaller;
        } else {
            diff = (int) (sum - target);
            list = greater;
        }
        if (count < diff) {
            diff -= count;
            Collections.sort(list);
            for (int i = 0; i < diff; i++) {
                res += list.get(i);
            }
        }
        return String.format("%.3f", res + 0.0001);
    }
}
