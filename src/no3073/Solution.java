package no3073;

import java.util.TreeSet;

class Solution {
    public int maximumTripletValue(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        int length = nums.length;
        int[] left = new int[length];
        for (int i = 0; i < length; i++) {
            Integer key = set.floor(nums[i]);
            if (key == null) {
                left[i] = -1;
            } else if (key == nums[i]) {
                key = set.floor(nums[i] - 1);
                if (key == null) {
                    left[i] = -1;
                } else {
                    left[i] = key;
                }
            } else {
                left[i] = key;
            }
            set.add(nums[i]);
        }

        int max = nums[length - 1];
        int res = Integer.MIN_VALUE;
        for (int i = length - 2; i >= 1; i--) {
            if (max > nums[i] && left[i] != -1) {
                res = Math.max(res, max - nums[i] + left[i]);
            }
            max = Math.max(nums[i], max);
        }
        return res;
    }
}