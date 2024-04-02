package no2863;

import java.util.TreeMap;

class Solution {
    public int maxSubarrayLength(int[] nums) {
        int length = nums.length;
        int res = 0;
        int max = -1_000_000_001;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < length; i++) {
            Integer key = map.ceilingKey(nums[i]);
            if (key != null) {
                if (key != nums[i]) {
                    res = Math.max(res, i - map.get(key) + 1);
                } else {
                    key = map.ceilingKey(nums[i] + 1);
                    if (key != null) {
                        res = Math.max(res, i - map.get(key) + 1);
                    }
                }
            }
            if (nums[i] > max) {
                map.put(nums[i], i);
                max = nums[i];
            }
        }

        return res;
    }
}