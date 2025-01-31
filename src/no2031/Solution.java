package no2031;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int subarraysWithMoreZerosThanOnes(int[] nums) {
        int length = nums.length;
        int sum = 0;
        long res = 0;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            int diff = 2 * sum - i - 1;
            int idx = Collections.binarySearch(list, diff);
            if (idx < 0) {
                idx = -idx - 1;
                res += idx;
            } else {
                int left = 0;
                int right = idx;
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (list.get(mid) == diff) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                res += left;
            }
            list.add(idx, diff);
        }
        return (int) (res % 1_000_000_007);
    }
}