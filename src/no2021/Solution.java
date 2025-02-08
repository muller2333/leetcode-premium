package no2021;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int brightestPosition(int[][] lights) {
        int length = lights.length;
        int[] start = new int[length];
        int[] end = new int[length];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            start[i] = lights[i][0] - lights[i][1];
            end[i] = lights[i][0] + lights[i][1];
            set.add(start[i]);
            set.add(end[i]);
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int min = length;
        int res = 2_00_000_000;
        for (int i : set) {
            int target = i + 1;
            int idx = Arrays.binarySearch(start, target);
            if (idx < 0) {
                idx = -idx - 1;
            } else {
                int left = 0;
                int right = idx;
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (start[mid] == target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                idx = left;
            }
            int count = length - idx;
            if (count <= min) {
                target = i - 1;
                idx = Arrays.binarySearch(end, target);
                if (idx < 0) {
                    count -= idx + 1;
                } else {
                    int left = idx;
                    int right = length - 1;
                    while (left <= right) {
                        int mid = (left + right) >> 1;
                        if (end[mid] == target) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }
                    count += right + 1;
                }
                if (count < min) {
                    min = count;
                    res = i;
                } else if (count == min) {
                    res = Math.min(res, i);
                }
            }
        }
        return res;
    }
}