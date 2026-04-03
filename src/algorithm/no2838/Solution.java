package no2838;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public long[] maximumCoins(int[] heroes, int[] monsters, int[] coins) {
        Map<Integer, Long> map = new HashMap<>();
        int length = monsters.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(monsters[i])) {
                map.put(monsters[i], map.get(monsters[i]) + coins[i]);
            } else {
                list.add(monsters[i]);
                map.put(monsters[i], coins[i] + 0L);
            }
        }
        Collections.sort(list);
        int size = list.size();
        long[] sums = new long[size + 1];
        long sum = 0;
        for (int i = 0; i < size; i++) {
            sum += map.get(list.get(i));
            sums[i + 1] = sum;
        }
        length = heroes.length;
        long[] res = new long[length];
        for (int i = 0; i < length; i++) {
            int index = Collections.binarySearch(list, heroes[i]);
            if (index < 0) {
                index = -index - 2;
            }
            res[i] = sums[index + 1];
        }
        return res;
    }
}
