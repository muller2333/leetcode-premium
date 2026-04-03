package no1746;

class Solution {
    public int maxSumAfterOperation(int[] nums) {
        int length = nums.length;
        int[] sums = new int[length + 1];
        int min = 0;
        int[] mins = new int[length + 1];
        for (int i = 0; i < length; i++) {
            sums[i + 1] = sums[i] + nums[i];
            min = Math.min(min, sums[i + 1]);
            mins[i + 1] = min;
        }
        int max = -1_000_000_000;
        int res = -1_000_000_000;
        for (int i = length - 1; i >= 0; i--) {
            max = Math.max(max, sums[i + 1]);
            res = Math.max(res, max - mins[i] + nums[i] * nums[i] - nums[i]);
        }
        return res;
    }
}
