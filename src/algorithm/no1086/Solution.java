package no1086;

import java.util.*;

class Solution {
    public int[][] highFive(int[][] items) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] item : items) {
            int id = item[0];
            if (!map.containsKey(id)) {
                map.put(id, new ArrayList<>());
                list.add(id);
            }
            map.get(id).add(item[1]);
        }
        Collections.sort(list);
        int size = list.size();
        int[][] res = new int[size][];
        for (int i = 0; i < size; i++) {
            int id = list.get(i);
            List<Integer> scores = map.get(id);
            Collections.sort(scores);
            int sum = 0;
            for (int j = scores.size() - 1; j >= scores.size() - 5; j--) {
                sum += scores.get(j);
            }
            res[i] = new int[]{id, sum / 5};
        }
        return res;
    }
}
