package no2107;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int shareCandies(int[] candies, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int candy : candies) {
            map.put(candy, map.getOrDefault(candy, 0) + 1);
        }
        int size = map.size();
        if (k == 0) {
            return size;
        } else {
            for (int i = 0; i < k; i++) {
                int candy = candies[i];
                if (map.get(candy) == 1) {
                    map.remove(candy);
                } else {
                    map.put(candy, map.get(candy) - 1);
                }
            }
            int res = map.size();
            for (int i = 1; i <= candies.length - k; i++) {
                int candy = candies[i - 1];
                map.put(candy, map.getOrDefault(candy, 0) + 1);
                candy = candies[i + k - 1];
                if (map.get(candy) == 1) {
                    map.remove(candy);
                } else {
                    map.put(candy, map.get(candy) - 1);
                }
                res = Math.max(res, map.size());
            }
            return res;
        }
    }
}