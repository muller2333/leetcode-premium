package no2237;

import java.util.Arrays;

class Solution {
    public int meetRequirement(int n, int[][] lights, int[] requirement) {
        int length = lights.length;
        int[] start = new int[length];
        int[] end = new int[length];
        for (int i = 0; i < length; i++) {
            start[i] = Math.max(0, lights[i][0] - lights[i][1]);
            end[i] = Math.min(n - 1, lights[i][0] + lights[i][1]);
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int idx = Arrays.binarySearch(start, i + 1);
            if (idx < 0) {
                idx = -idx - 1;
            } else {
                int left = 0;
                int right = idx;
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (start[mid] == i + 1) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                idx = left;
            }
            int count = length - idx;
            idx = Arrays.binarySearch(end, i - 1);
            if (idx < 0) {
                idx = -idx - 1;
                count += idx;
            } else {
                int left = idx;
                int right = length - 1;
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (end[mid] == i - 1) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                count += right + 1;
            }
            if (length - count >= requirement[i]) {
                res++;
            }
        }
        return res;
    }
}
