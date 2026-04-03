package no1885;

import java.util.Arrays;

class Solution {
    public long countPairs(int[] nums1, int[] nums2) {
        int length = nums1.length;
        long res = 0;
        for (int i = 0; i < length; i++) {
            nums1[i] = nums1[i] - nums2[i];
        }
        Arrays.sort(nums1);
        for (int i = 0; i < length; i++) {
            int index = Arrays.binarySearch(nums1, i + 1, length, -nums1[i] + 1);
            if (index < 0) {
                index = -index - 1;
                res += length - index;

            } else {
                int left = i + 1;
                int right = index;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (nums1[mid] == -nums1[i] + 1) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                res += length - left;
            }
        }
        return res;
    }
}
