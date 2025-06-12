package no2832;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int[] maximumLengthOfRanges(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        int length = nums.length;
        int max = 0;
        for (int i = 0; i < length; i++) {
            map.put(nums[i], i);
            max = Math.max(max, nums[i]);
        }
        List<Integer> list = new ArrayList<>();
        int[] res = new int[length];
        for (int key : map.keySet()) {
            int val = map.get(key);
            if (key == max) {
                res[val] = length;
                list.add(val);
            } else {
                int idx = -Collections.binarySearch(list, val) - 1;
                if (idx == 0) {
                    res[val] = list.get(idx);
                } else if (idx == list.size()) {
                    res[val] = length - list.get(list.size() - 1) - 1;
                } else {
                    res[val] = list.get(idx) - list.get(idx - 1) - 1;
                }
                list.add(idx, val);
            }
        }
        return res;
    }
}