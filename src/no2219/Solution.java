package no2219;

class Solution {
    public long maximumSumScore(int[] nums) {
        long sum = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        long res = Long.MIN_VALUE;
        long preSum = 0;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            preSum += num;
            long max = Math.max(preSum, sum - preSum + num);
            if (max > res) {
                res = max;
            }
        }
        return res;
    }
}