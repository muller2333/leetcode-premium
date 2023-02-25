package no1060;

class Solution {
    public int missingElement(int[] nums, int k) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            int count = nums[i + 1] - nums[i] - 1;
            if (count > 0) {
                if (count < k) {
                    k -= count;
                } else {
                    return nums[i] + k;
                }
            }
        }
        return nums[length - 1] + k;
    }
}