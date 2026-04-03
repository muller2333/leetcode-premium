package no1708;

class Solution {
    public int[] largestSubarray(int[] nums, int k) {
        int max = 0;
        int index = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = nums[index++];
        }
        return res;
    }
}