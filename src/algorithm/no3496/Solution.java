package no3496;

class Solution {
    public int maxScore(int[] nums) {
        int length = nums.length;
        int res = 0;
        int min = 200_000;
        if (length % 2 == 0) {
            res = nums[length - 1];
            for (int i = 0; i < length - 1; i++) {
                res += nums[i];
                min = Math.min(min, nums[i] + nums[i + 1]);
            }
        } else {
            for (int i : nums) {
                res += i;
                min = Math.min(min, i);
            }
        }
        return res - min;
    }
}