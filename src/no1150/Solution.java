package no1150;

import java.util.Arrays;

class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int search = Arrays.binarySearch(nums, target);
        if (search < 0) {
            return false;
        } else {
            int length = nums.length;
            int left = search;
            int right = length - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (nums[mid] == target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            int end = right;
            left = 0;
            right = search;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (nums[mid] == target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return (end - left + 1) << 1 > length;
        }
    }
}