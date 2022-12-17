package no1085;

class Solution {
    public int sumOfDigits(int[] nums) {
        int min = nums[0];
        for (int i : nums) {
            min = Math.min(min, i);
        }
        int res = 0;
        while (min > 0) {
            res += min % 10;
            min /= 10;
        }
        return res % 2 == 1 ? 0 : 1;
    }
}