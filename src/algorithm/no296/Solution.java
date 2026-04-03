package no296;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        List<Integer> xSum = new ArrayList<>();
        xSum.add(0);
        List<Integer> ySum = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    xList.add(i);
                    yList.add(j);
                    xSum.add(xSum.get(count++) + i);
                }
            }
        }
        Collections.sort(yList);
        ySum.add(0);
        for (int i = 0; i < count; i++) {
            ySum.add(ySum.get(i) + yList.get(i));
        }
        int res = m * n * (m + n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = Collections.binarySearch(xList, i);
                if (index < 0) {
                    index = -index - 1;
                }
                int sum = i * (2 * index - count) - xSum.get(index) * 2 + xSum.get(count);
                index = Collections.binarySearch(yList, j);
                if (index < 0) {
                    index = -index - 1;
                }
                sum += j * (2 * index - count) - ySum.get(index) * 2 + ySum.get(count);
                res = Math.min(res, sum);
            }
        }
        return res;
    }
}
