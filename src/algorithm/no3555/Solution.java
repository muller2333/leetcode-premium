package no3555;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] minSubarraySort(int[] nums, int k) {
        int length = nums.length;
        int[] res = new int[length - k + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list);
        int i = 0;
        while (i < k && list.get(i) == nums[i]) {
            i++;
        }
        if (i == k) {
            res[0] = 0;
        } else {
            int j = k - 1;
            while (j >= 0 && list.get(j) == nums[j]) {
                j--;
            }
            res[0] = j - i + 1;
        }
        for (int m = 1; m <= length - k; m++) {
            list.remove(Collections.binarySearch(list, nums[m - 1]));
            int idx = Collections.binarySearch(list, nums[m + k - 1]);
            if (idx < 0) {
                idx = -idx - 1;
            }
            list.add(idx, nums[m + k - 1]);
            int start = 0;
            while (start < k && list.get(start) == nums[m + start]) {
                start++;
            }
            if (start == k) {
                res[m] = 0;
            } else {
                int end = m + k - 1;
                while (end >= m && list.get(end - m) == nums[end]) {
                    end--;
                }
                res[m] = end - start - m + 1;
            }
        }
        return res;
    }
}
