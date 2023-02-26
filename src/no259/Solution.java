package no259;

import java.util.Arrays;

class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                int newTarget = target - nums[i] - nums[j] - 1;
                int search = Arrays.binarySearch(nums, j + 1, length, newTarget);
                if (search < 0) {
                    res += -search - 2 - j;
                } else {
                    int left = search;
                    int right = length - 1;
                    while (left <= right) {
                        int mid = (left + right) >> 1;
                        if (nums[mid] == newTarget) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }
                    res += right - j;
                }
            }
        }
        return res;
    }
}