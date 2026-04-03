package no323;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] arr : edges) {
            map.putIfAbsent(arr[0], new ArrayList<>());
            map.get(arr[0]).add(arr[1]);
            map.putIfAbsent(arr[1], new ArrayList<>());
            map.get(arr[1]).add(arr[0]);
        }
        int[] arr = new int[n];
        int val = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = ++val;
                List<Integer> list = map.getOrDefault(i, new ArrayList<>());
                while (list.size() != 0) {
                    List<Integer> mid = new ArrayList<>();
                    for (int j : list) {
                        if (arr[j] == 0) {
                            arr[j] = val;
                            for (int k : map.getOrDefault(j, new ArrayList<>())) {
                                if (arr[k] == 0) {
                                    mid.add(k);
                                }
                            }
                        }
                    }
                    list = mid;
                }
            }
        }
        return val;
    }
}
