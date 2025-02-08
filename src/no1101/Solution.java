package no1101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            map.putIfAbsent(log[1], new ArrayList<>());
            map.get(log[1]).add(log[2]);
            map.putIfAbsent(log[2], new ArrayList<>());
            map.get(log[2]).add(log[1]);
        }
        set.add(logs[0][1]);
        List<Integer> list = map.get(logs[0][1]);
        while (list.size() > 0) {
            for (int i : list) {
                set.add(i);
            }
            List<Integer> mid = new ArrayList<>();
            for (int i : list) {
                for (int j : map.get(i)) {
                    if (!set.contains(j)) {
                        mid.add(j);
                    }
                }
            }
            list = mid;
        }
        if (set.size() != n) {
            return -1;
        }
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        set.clear();
        int[] values = new int[n];
        int val = 1;
        for (int[] log : logs) {
            if (values[log[1]] == 0) {
                if (values[log[2]] == 0) {
                    values[log[1]] = values[log[2]] = val++;
                    set.add(log[1]);
                    set.add(log[2]);
                } else {
                    values[log[1]] = values[log[2]];
                    set.add(log[1]);
                }
            } else {
                if (values[log[2]] == 0) {
                    values[log[2]] = values[log[1]];
                    set.add(log[2]);
                } else if (values[log[2]] != values[log[1]]) {
                    int target = values[log[2]];
                    for (int i = 0; i < n; i++) {
                        if (values[i] == target) {
                            values[i] = values[log[1]];
                            set.add(i);
                        }
                    }
                }
            }
            if (set.size() == n) {
                int i = 0;
                while (i < n && values[i] == 0) {
                    i++;
                }
                int target = values[i++];
                while (i < n && values[i] == target) {
                    i++;
                }
                if (i == n) {
                    return log[0];
                }
            }
        }
        return -1;
    }
}
