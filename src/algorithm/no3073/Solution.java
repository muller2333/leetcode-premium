package no3073;

import java.util.TreeSet;

class Solution {
    public int maximumTripletValue(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        TreeSet<Integer> set = new TreeSet<>();
        set.add(nums[0]);
        for (int i = 1; i < length - 1; i++) {
            Integer key = set.lower(nums[i]);
            if (key != null) {
                left[i] = key;
            }
            set.add(nums[i]);
        }
        int res = 0;
        int max = nums[length - 1];
        for (int i = length - 2; i > 0; i--) {
            if (max > nums[i]) {
                if (left[i] != 0) {
                    res = Math.max(res, left[i] + max - nums[i]);
                }
            }
            max = Math.max(max, nums[i]);
        }
        return res;
    }
}