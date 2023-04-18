package no1983;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int widestPairOfIndices(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int diff = 0;
        Map<Integer, Integer> diffMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            diff += nums1[i] - nums2[i];
            diffMap.put(diff, i);
        }
        int res = diffMap.getOrDefault(0, -1) + 1;
        diff = 0;
        for (int i = 0; i < length - 1 - res; i++) {
            diff += nums1[i] - nums2[i];
            int index = diffMap.getOrDefault(diff, 0);
            if (index > i) {
                res = Math.max(res, index - i);
            }
        }
        return res;
    }
}