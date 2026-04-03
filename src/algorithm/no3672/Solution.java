package no3672;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

class Solution {
    public long modeWeight(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }
        TreeMap<Integer, TreeSet<Integer>> tm = new TreeMap<>();
        for (int key : map.keySet()) {
            tm.computeIfAbsent(map.get(key), kk -> new TreeSet<>()).add(key);
        }
        int maxFreq = tm.floorKey(k);
        TreeSet<Integer> set = tm.get(maxFreq);
        long res = 1L * maxFreq * set.ceiling(0);
        for (int i = k; i < nums.length; i++) {
            if (nums[i - k] != nums[i]) {
                int count = map.get(nums[i - k]);
                tm.get(count).remove(nums[i - k]);
                if (tm.get(count).size() == 0) {
                    tm.remove(count);
                }
                tm.computeIfAbsent(count - 1, kk -> new TreeSet<>()).add(nums[i - k]);
                if (count == 1) {
                    map.remove(nums[i - k]);
                } else {
                    map.put(nums[i - k], count - 1);
                }
                count = map.getOrDefault(nums[i], 0);
                if (count == 0) {
                    tm.computeIfAbsent(1, kk -> new TreeSet<>()).add(nums[i]);
                } else {
                    tm.get(count).remove(nums[i]);
                    if (tm.get(count).size() == 0) {
                        tm.remove(count);
                    }
                    tm.computeIfAbsent(count + 1, kk -> new TreeSet<>()).add(nums[i]);
                }
                map.merge(nums[i], 1, Integer::sum);
            }
            maxFreq = tm.floorKey(k);
            set = tm.get(maxFreq);
            res += 1L * maxFreq * set.ceiling(0);
        }
        return res;
    }
}
