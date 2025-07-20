package no656;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public List<Integer> cheapestJump(int[] coins, int maxJump) {
        int length = coins.length;
        if (coins[length - 1] == -1) {
            return new ArrayList<>();
        }
        if (maxJump >= length - 1) {
            List<Integer> res = new ArrayList<>();
            res.add(1);
            for (int i = 1; i < length - 1; i++) {
                if (coins[i] == 0) {
                    res.add(i + 1);
                }
            }
            if (length != 1) {
                res.add(length);
            }
            return res;
        }
        int[] dp = new int[length];
        dp[0] = coins[0];
        Map<Integer, Queue<List<Integer>>> map = new HashMap<>();
        CustomComparator com = new CustomComparator();
        List<Integer> li = new ArrayList<>();
        li.add(1);
        map.put(coins[0], new PriorityQueue<>(com));
        map.get(coins[0]).add(li);
        for (int i = 1; i < length; i++) {
            if (coins[i] == -1) {
                dp[i] = 100_001;
            } else {
                int min = 100_001;
                for (int j = Math.max(0, i - maxJump); j < i; j++) {
                    if (coins[j] != -1) {
                        min = Math.min(min, dp[j]);
                    }
                }
                if (min == 100_001) {
                    return new ArrayList<>();
                } else {
                    Map<Integer, Queue<List<Integer>>> mid = new HashMap<>();
                    mid.put(min, new PriorityQueue<>(com));
                    int newKey = min + coins[i];
                    map.putIfAbsent(newKey, new PriorityQueue<>(com));
                    for (List<Integer> sorted : map.get(min)) {
                        if (sorted.get(sorted.size() - 1) - 1 + maxJump >= i) {
                            List<Integer> inner = new ArrayList<>();
                            for (int j : sorted) {
                                inner.add(j);
                            }
                            inner.add(i + 1);
                            if (coins[i] != 0) {
                                map.get(newKey).add(inner);
                            } else {
                                mid.get(min).add(inner);
                            }
                        }
                    }
                    if (coins[i] == 0) {
                        for (List<Integer> sorted : mid.get(min)) {
                            map.get(min).add(sorted);
                        }
                    }
                }
                dp[i] = min + coins[i];
            }
        }
        Queue<List<Integer>> pq = map.get(dp[length - 1]);
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            li = pq.poll();
            if (li.get(li.size() - 1) == length) {
                return li;
            }
        }
        return null;
    }
}

class CustomComparator implements Comparator<List<Integer>> {
    @Override
    public int compare(List<Integer> a, List<Integer> b) {
        int size = a.size();
        int sz = b.size();
        int limit = size <= sz ? size : sz;
        for (int i = 0; i < limit; i++) {
            int diff = a.get(i) - b.get(i);
            if (diff != 0) {
                return diff;
            }
        }
        return size - sz;
    }
}