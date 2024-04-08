package no356;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Solution {
    public boolean isReflected(int[][] points) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Set<Integer>> map2 = new HashMap<>();
        for (int[] point : points) {
            if (!map.containsKey(point[1])) {
                map.put(point[1], new ArrayList<>());
                map2.put(point[1], new HashSet<>());
            }
            if (!map2.get(point[1]).contains(point[0])) {
                map2.get(point[1]).add(point[0]);
                map.get(point[1]).add(point[0]);
            }
        }
        Iterator<Integer> ite = map.keySet().iterator();
        List<Integer> list = map.get(ite.next());
        Collections.sort(list);
        int size = list.size();
        double mid;
        int left;
        int right = size / 2 + 1;
        if (size % 2 == 1) {
            mid = list.get((size + 0) / 2);
            left = size / 2 - 1;
        } else {
            mid = (0d + list.get(size / 2) + list.get(size / 2 - 1)) / 2;
            left = size / 2 - 2;
        }
        while (left >= 0 && right < size) {
            if (list.get(left--) + list.get(right++) != mid * 2) {
                return false;
            }
        }
        while (ite.hasNext()) {
            list = map.get(ite.next());
            Collections.sort(list);
            size = list.size();
            left = 0;
            right = size - 1;
            while (left <= right) {
                if (list.get(left++) + list.get(right--) != mid * 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
