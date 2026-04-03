package no694;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Map<Integer, List<List<int[]>>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 2;
                    int count = 0;
                    List<int[]> list = new ArrayList<>();
                    List<int[]> coords = new ArrayList<>();
                    list.add(new int[] { i, j });
                    int size;
                    while ((size = list.size()) > 0) {
                        count += size;
                        List<int[]> mid = new ArrayList<>();
                        for (int[] arr : list) {
                            coords.add(arr);
                            int row = arr[0];
                            int col = arr[1];
                            if (row < m - 1 && grid[row + 1][col] == 1) {
                                mid.add(new int[] { row + 1, col });
                                grid[row + 1][col] = 2;
                            }
                            if (row > 0 && grid[row - 1][col] == 1) {
                                mid.add(new int[] { row - 1, col });
                                grid[row - 1][col] = 2;
                            }
                            if (col < n - 1 && grid[row][col + 1] == 1) {
                                mid.add(new int[] { row, col + 1 });
                                grid[row][col + 1] = 2;
                            }
                            if (col > 0 && grid[row][col - 1] == 1) {
                                mid.add(new int[] { row, col - 1 });
                                grid[row][col - 1] = 2;
                            }
                        }
                        list = mid;
                    }
                    map.putIfAbsent(count, new ArrayList<>());
                    map.get(count).add(coords);
                }
            }
        }
        int res = 0;
        for (List<List<int[]>> list : map.values()) {
            for (List<int[]> li : list) {
                Collections.sort(li, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            }
            int size = list.size();
            if (size == 1) {
                res++;
            } else {
                boolean[] flags = new boolean[size];
                int limit = list.get(0).size();
                for (int i = 0; i < size; i++) {
                    if (!flags[i]) {
                        res++;
                        List<int[]> left = list.get(i);
                        for (int j = i + 1; j < size; j++) {
                            boolean flag = true;
                            List<int[]> right = list.get(j);
                            for (int k = 1; k < limit; k++) {
                                if (left.get(k)[0] - left.get(k - 1)[0] != right.get(k)[0] - right.get(k - 1)[0]
                                        || left.get(k)[1] - left.get(k - 1)[1] != right.get(k)[1]
                                                - right.get(k - 1)[1]) {
                                    flag = false;
                                    break;
                                }
                            }
                            if (flag) {
                                flags[j] = true;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
