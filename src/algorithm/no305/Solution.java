package no305;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int length = positions.length;
        int[][] grid = new int[m][n];
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<int[]>> map = new HashMap<>();
        int count = 0;
        int val = 0;
        int[][] offsets = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int i = 0; i < length; i++) {
            int row = positions[i][0];
            int col = positions[i][1];
            int[] add = new int[] { row, col };
            int target = grid[row][col];
            if (target == 0) {
                Map<Integer, Integer> countMap = new HashMap<>();
                int k = 0;
                int max = 0;
                for (int[] offset : offsets) {
                    int newRow = row + offset[0];
                    int newCol = col + offset[1];
                    if (newCol >= 0 && newCol < n && newRow >= 0 && newRow < m
                            && grid[newRow][newCol] != 0) {
                        int oldVal = grid[newRow][newCol];
                        int size = map.get(oldVal).size();
                        if (size > max) {
                            k = target = oldVal;
                            max = size;
                        }
                        countMap.put(oldVal, size);
                    }
                }
                if (countMap.size() > 0) {
                    for (int key : countMap.keySet()) {
                        if (key == k) {
                            grid[row][col] = k;
                            map.get(k).add(add);
                        } else {
                            for (int[] arr : map.remove(key)) {
                                grid[arr[0]][arr[1]] = target;
                                map.get(target).add(arr);
                            }
                            count--;
                        }
                    }
                } else {
                    grid[row][col] = ++val;
                    map.putIfAbsent(val, new ArrayList<>());
                    map.get(val).add(add);
                    count++;
                }
            }
            res.add(count);
        }
        return res;
    }
}
