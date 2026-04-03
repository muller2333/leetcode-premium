package no3450;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int maxStudentsOnBench(int[][] students) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] arr : students) {
            map.putIfAbsent(arr[1], new HashSet<>());
            map.get(arr[1]).add(arr[0]);
        }
        int res = 0;
        for (int key : map.keySet()) {
            res = Math.max(res, map.get(key).size());
        }
        return res;
    }
}
