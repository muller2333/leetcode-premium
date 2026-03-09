package no3837;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] delayedCount(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            map.computeIfAbsent(nums[i], key -> new ArrayList<>()).add(i);
        }
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            if (i + k == length - 1) {
                break;
            }
            int target = nums[i];
            List<Integer> list = map.get(target);
            int idx = Collections.binarySearch(list, i + k + 1);
            if (idx < 0) {
                idx = -idx - 1;
            }
            res[i] = list.size() - idx;
        }
        return res;
    }
}
