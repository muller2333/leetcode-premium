package no3520;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int minThreshold(int[] nums, int k) {
        int length = nums.length;
        List<Integer> list = new ArrayList<>();
        int[] indices = new int[length];
        list.add(nums[length - 1]);
        int[] sums = new int[length];
        int diff = 0;
        for (int i = length - 2; i >= 0; i--) {
            int num = nums[i];
            int index = getRightmostIndex(list, num, 0);
            indices[i] = index++;
            sums[i] = sums[i + 1] + index;
            diff = Math.max(diff, num - list.get(0));
            list.add(index, num);
        }
        if (sums[0] < k) {
            return -1;
        }
        int left = 1;
        int right = diff;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            list = new ArrayList<>();
            list.add(nums[length - 1]);
            int count = 0;
            for (int i = length - 2; i >= 0 && sums[0] - sums[i + 1] + count >= k; i--) {
                int num = nums[i];
                if (num <= list.get(0)) {
                    list.add(0, num);
                } else {
                    count += indices[i] - getRightmostIndex(list, num, mid) + 1;
                    if (count >= k) {
                        break;
                    }
                    list.add(indices[i] + 1, num);
                }
            }
            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int getRightmostIndex(List<Integer> list, int num, int threshold) {
        int target = num - threshold;
        int index = Collections.binarySearch(list, target);
        if (index >= 0) {
            int left = 0;
            while (left <= index) {
                int mid = (left + index) >> 1;
                if (list.get(mid) == target) {
                    index = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            index++;
        } else {
            index = -index - 1;
        }
        return index - (threshold == 0 ? 1 : 0);
    }
}