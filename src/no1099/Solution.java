package no1099;

class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int max = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int sum = nums[i] + nums[j];
                if (sum < k && sum > max) {
                    max = sum;
                }
            }
        }
        return max == 0 ? -1 : max;
    }
}