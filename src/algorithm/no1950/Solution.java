package no1950;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

class Solution {
    public int[] findMaximums(int[] nums) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        int length = nums.length;
        int mx = 0;
        int mn = 1_000_000_000;
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
            mn = Math.min(mn, nums[i]);
            mx = Math.max(mx, nums[i]);
            q.add(nums[i]);
        }
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, List<Integer>> countMap = new HashMap<>();
        int[] res = new int[length];
        res[0] = mx;
        res[length - 1] = mn;
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            for (int j : list) {
                Integer min = set.ceiling(j);
                int right = min == null ? length : min;
                Integer max = set.floor(j);
                int left = max == null ? 0 : max + 1;
                int count = right - left;
                countMap.putIfAbsent(count, new ArrayList<>());
                countMap.get(count).add(key);
                set.add(j);
            }
        }
        Map<Integer, Integer> delMap = new HashMap<>();
        for (int i = 1; i < length - 1; i++) {
            for (int j : countMap.getOrDefault(i, new ArrayList<>())) {
                delMap.merge(j, 1, Integer::sum);
            }
            Integer cnt;
            while ((cnt = delMap.get(q.peek())) != null) {
                mx = q.poll();
                if (cnt == 1) {
                    delMap.remove(mx);
                } else {
                    delMap.put(mx, cnt - 1);
                }
            }
            res[i] = q.peek();
        }
        return res;
    }
}
