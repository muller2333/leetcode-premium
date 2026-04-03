package no163;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(lower);
            list.add(upper);
            res.add(list);
        } else {
            if (nums[0] != lower) {
                List<Integer> li = new ArrayList<>();
                li.add(lower);
                li.add(nums[0] - 1);
                res.add(li);
            }
            for (int i = 0; i < len - 1; i++) {
                List<Integer> list = new ArrayList<>();
                int target = nums[i + 1] - nums[i];
                if (target >= 2) {
                    list.add(nums[i] + 1);
                    list.add(nums[i + 1] - 1);
                    res.add(list);
                }
            }
            if (nums[len - 1] != upper) {
                List<Integer> li = new ArrayList<>();
                li.add(nums[len - 1] + 1);
                li.add(upper);
                res.add(li);
            }
        }
        return res;
    }
}