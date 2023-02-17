package no1198;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int smallestCommonElement(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = mat[i][j];
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        int res = 10_001;
        for (int num : map.keySet()) {
            if (map.get(num) == m) {
                res = Math.min(num, res);
            }
        }
        return res == 10_001 ? -1 : res;
    }
}