package no2898;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public long maxScore(int[] prices) {
        long res = 0;
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < prices.length; i++) {
            int diff = prices[i] - i;
            map.put(diff, map.getOrDefault(diff, 0L) + prices[i]);
        }
        for (long val : map.values()) {
            res = Math.max(res, val);
        }
        return res;
    }
}
