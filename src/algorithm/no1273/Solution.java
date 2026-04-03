package no1273;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    int res = 0;

    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        res = nodes;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i < nodes; i++) {
            int p = parent[i];
            map.putIfAbsent(p, new ArrayList<>());
            map.get(p).add(i);
        }
        Map<Integer, int[]> sumAndCount = new HashMap<>();
        traverse(0, value, map, sumAndCount);
        traverse(0, map, sumAndCount);
        return res;
    }

    public void traverse(int root, Map<Integer, List<Integer>> map, Map<Integer, int[]> sumAndCount) {
        int[] arr = sumAndCount.get(root);
        if (arr[0] == 0) {
            res -= arr[1];
        } else {
            for (int i : map.getOrDefault(root, new ArrayList<>())) {
                traverse(i, map, sumAndCount);
            }
        }
    }

    public int[] traverse(int root, int[] value, Map<Integer, List<Integer>> map, Map<Integer, int[]> sumAndCount) {
        List<Integer> list = map.get(root);
        int[] res = new int[] { value[root], 1 };
        if (list == null) {
            sumAndCount.put(root, res);
        } else {
            for (int i : list) {
                int[] arr = traverse(i, value, map, sumAndCount);
                res[0] += arr[0];
                res[1] += arr[1];
            }
            sumAndCount.put(root, res);
        }
        return res;
    }
}