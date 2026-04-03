package no1874;

import java.util.Arrays;

class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len = nums1.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += nums1[len - 1 - i] * nums2[i];
        }
        return res;
    }
}