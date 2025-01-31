package no2655;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] findMaximalUncoveredRanges(int n, int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int prev = -1;
        for (int[] range : ranges) {
            if (range[0] > prev + 1) {
                res.add(new int[] { prev + 1, range[0] - 1 });
                prev = range[1];
            } else {
                prev = Math.max(prev, range[1]);
            }
        }
        if (prev != n - 1) {
            res.add(new int[] { prev + 1, n - 1 });
        }
        return res.toArray(new int[res.size()][2]);
    }
}