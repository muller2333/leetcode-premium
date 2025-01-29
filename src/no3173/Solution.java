package no3173;

class Solution {
    public int[] orArray(int[] nums) {
        int length = nums.length;
        int[] res = new int[length - 1];
        for (int i = 0; i < length - 1; i++) {
            res[i] = nums[i] | nums[i + 1];
        }
        return res;
    }
}