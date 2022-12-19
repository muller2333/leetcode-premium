package no1852;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] distinctNumbers(int[] nums, int k) {
        int length = nums.length;
        int[] res = new int[length - k + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        res[0] = map.size();
        for (int i = 1; i <= length - k; i++) {
            int num = nums[i + k - 1];
            map.put(num, map.getOrDefault(num, 0) + 1);
            num = nums[i - 1];
            map.put(num, map.get(num) - 1);
            if (map.get(num) == 0) {
                map.remove(num);
            }
            res[i] = map.size();
        }
        return res;
    }
}