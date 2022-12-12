package no163;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int len = nums.length;
        List<String> res = new ArrayList<>();
        if (len == 0) {
            res.add(lower == upper ? lower + "" : lower + "->" + upper);
        } else {
            int target = nums[0] - 1;
            if (lower < target) {
                res.add(lower + "->" + target);
            } else if (lower == target) {
                res.add(lower + "");
            }
            for (int i = 0; i < len - 1; i++) {
                target = nums[i + 1] - nums[i];
                if (target == 2) {
                    res.add((nums[i] + 1) + "");
                } else if (target > 2) {
                    res.add((nums[i] + 1) + "->" + (nums[i + 1] - 1));
                }
            }
            target = nums[len - 1] + 1;
            if (target < upper) {
                res.add(target + "->" + upper);
            } else if (upper == target) {
                res.add(upper + "");
            }
        }
        return res;
    }
}