package no2495;

class Solution {
    public long evenProduct(int[] nums) {
        int len = nums.length;
        long res = 0;
        int index = len;
        for (int i = len - 1; i >= 0; i--) {
            if ((1 & nums[i]) == 0) {
                res += len - i;
                index = i;
            } else {
                res += len - index;
            }
        }
        return res;
    }
}