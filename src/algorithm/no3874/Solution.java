package no3874;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public long validSubarrays(int[] nums, int k) {
        int length = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                list.add(i);
            }
        }
        long res = 0;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int idx = list.get(i);
            int left = Math.max(idx - k, i == 0 ? 0 : list.get(i - 1) + 1);
            int right = Math.min(idx + k, i == size - 1 ? length - 1 : list.get(i + 1) - 1);
            res += (idx - left + 1L) * (right - idx + 1);
        }
        return res;
    }
}
