package no3353;

class Solution {
    public int minOperations(int[] nums) {
        int i = nums.length - 1;
        while (--i >= 0 && nums[i] == nums[i + 1]) {
        }
        int res = 0;
        while (i >= 0) {
            while (--i >= 0 && nums[i] == nums[i + 1]) {
            }
            res++;
        }
        return res;
    }
}