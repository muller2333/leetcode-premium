package no2892;

class Solution {
    public int minArrayLength(int[] nums, int k) {
        int length = nums.length;
        int res = length;
        int i = 0;
        while (i < length - 1) {
            long prod = 1L * nums[i] * nums[i + 1];
            if (prod == 0) {
                return 1;
            }
            if (prod <= k) {
                res--;
                i += 2;
                while (i < length && (prod *= nums[i]) <= k) {
                    res--;
                    i++;
                }
            } else {
                i++;
            }
        }
        return res;
    }
}
