package no2393;

class Solution {
    public long countSubarrays(int[] nums) {
        long res = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                res += (count + 1L) * count >> 1;
                count = 1;
            }
        }
        return res + ((count + 1L) * count >> 1);
    }
}