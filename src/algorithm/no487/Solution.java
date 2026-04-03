package no487;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int length = nums.length;
        int res = 0;
        int pre = -1;
        int i = 0;
        while (i < length) {
            if (nums[i] == 0) {
                int temp = i;
                while (++i < length && nums[i] == 1) {
                }
                res = Math.max(res, i - pre - 1);
                pre = temp;
            } else {
                i++;
            }
        }
        return Math.max(res, length - pre - 1);
    }
}
