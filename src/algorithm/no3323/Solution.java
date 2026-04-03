package no3323;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int minConnectedGroups(int[][] intervals, int k) {
        int length = intervals.length;
        if (length == 1) {
            return 1;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        List<Integer> startList = new ArrayList<>();
        int prev = intervals[0][0];
        int minGap = Integer.MAX_VALUE;
        list.add(intervals[0]);
        startList.add(prev);
        for (int[] interval : intervals) {
            int gap = interval[0] - prev;
            if (gap > 0) {
                list.add(interval);
                startList.add(interval[0]);
                minGap = Math.min(gap, minGap);
                prev = interval[1];
            } else {
                if (interval[1] > prev) {
                    list.get(list.size() - 1)[1] = prev = interval[1];
                }
            }
        }
        int size = list.size();
        if (minGap > k) {
            return size;
        } else if (minGap == k) {
            return size - 1;
        }
        int res = length;
        for (int i = 0; i < size - 1; i++) {
            int right = list.get(i)[1];
            int target = right + k;
            int idx = Collections.binarySearch(startList, target);
            if (idx < 0) {
                idx = -idx - 2;
            }
            res = Math.min(res, i + size - idx);
            if (idx == size - 1) {
                break;
            }
        }
        return res;
    }

}
