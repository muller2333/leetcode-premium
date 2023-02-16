package no2436;

class Solution {
    public int minimumSplits(int[] nums) {
        int gcd = nums[0];
        int res = 0;
        int i = 0;
        int length = nums.length;
        while (true) {
            while (i < length && (gcd = gcd(gcd, nums[i])) > 1) {
                i++;
            }
            res++;
            if (i == length) {
                break;
            }
            gcd = nums[i];
        }
        return res;
    }

    public int gcd(int a, int b) {
        int temp;
        while ((temp = b % a) > 0) {
            b = a;
            a = temp;
        }
        return a;
    }

}