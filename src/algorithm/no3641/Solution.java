package no3641;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestSubarray(int[] nums, int k) {
        int length = nums.length;
        int j = 0;
        int res = 0;
        int i = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (j < length) {
            while (j < length && count <= k) {
                map.merge(nums[j], 1, Integer::sum);
                if (map.get(nums[j]) == 2) {
                    count++;
                }
                j++;
            }
            res = Math.max(res, j - 1 - i);
            while (i < j && count > k) {
                map.merge(nums[i], -1, Integer::sum);
                if (map.get(nums[i]) == 1) {
                    count--;
                }
                i++;
            }
            res = Math.max(res, j - i);
        }
        return res;
    }
}