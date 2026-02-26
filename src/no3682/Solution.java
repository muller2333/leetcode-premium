package no3682;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minimumSum(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], i);
            }
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            if (!map2.containsKey(nums2[i])) {
                map2.put(nums2[i], i);
            }
        }
        int res = 200_000;
        for (int key : map.keySet()) {
            res = Math.min(res, map.get(key) + map2.getOrDefault(key, res));
        }
        return res == 200_000 ? -1 : res;
    }
}
