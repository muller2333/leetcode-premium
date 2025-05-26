package no3520;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int minThreshold(int[] nums, int k) {
        int length = nums.length;
        int left = 1;
        int right = 1_000_000_000;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            List<Integer> list = new ArrayList<>();
            list.add(nums[length - 1]);
            int count = 0;
            for (int i = length - 2; i >= 0; i--) {
                count += count(list, nums[i], mid);
                if (count >= k) {
                    break;
                }
            }
            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left == 1_000_000_000 ? -1 : left;
    }

    public int count(List<Integer> list, int num, int threshold) {
        int size = list.size();
        int count = 0;
        if (num > list.get(0) && num <= list.get(size - 1) + threshold) {
            int search = Collections.binarySearch(list, num - 1);
            int[] res = { -1, -1 };
            if (search >= 0) {
                int left = search;
                int right = size - 1;
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (list.get(mid) == num - 1) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                res[1] = right;
            } else {
                res[1] = -search - 2;
            }
            search = Collections.binarySearch(list, num - threshold);
            if (search >= 0) {
                int left = 0;
                int right = search;
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (list.get(mid) == num - threshold) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                res[0] = left;
            } else {
                res[0] = -search - 1;
            }
            count = res[1] - res[0] + 1;
        }
        int search = Collections.binarySearch(list, num);
        if (search < 0) {
            search = -search - 1;
        }
        list.add(search, num);
        return count;
    }
}
