package no531;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length;
        int n = picture[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int count = 0;
            int index = 0;
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B' && ((index = j) >= 0) && ++count == 2) {
                    break;
                }
            }
            if (count == 1) {
                map.put(index, map.getOrDefault(index, 0) + 1);
            }
        }
        int res = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                int count = 0;
                for (int i = 0; i < m; i++) {
                    if (picture[i][key] == 'B' && ++count == 2) {
                        break;
                    }
                }
                if (count == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}