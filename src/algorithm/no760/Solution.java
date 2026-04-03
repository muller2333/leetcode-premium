package no760;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int length = nums1.length;
        for (int i = 0; i < length; i++) {
            int num = nums2[i];
            if (!map.containsKey(num)) {
                map.put(num, new ArrayList<>());
            }
            map.get(num).add(i);
        }
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            List<Integer> indices = map.get(nums1[i]);
            res[i] = indices.remove(indices.size() - 1);
        }
        return res;
    }
}