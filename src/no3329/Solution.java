package no3329;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public long numberOfSubstrings(String s, int k) {
        long res = 0;
        Map<Character, ArrayDeque<Integer>> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int length = chars.length;
        int i = 0;
        int max = -1;
        while (i < length) {
            char c = chars[i];
            map.putIfAbsent(c, new ArrayDeque<>());
            map.get(c).add(i++);
            if (map.get(c).size() == k) {
                max = map.get(c).peek();
                res += max + 1;
                break;
            }
        }
        while (i < length) {
            char c = chars[i];
            map.putIfAbsent(c, new ArrayDeque<>());
            map.get(c).add(i++);
            int size = map.get(c).size();
            if (size > k) {
                map.get(c).pop();
                max = Math.max(max, map.get(c).peek());
            } else if (size == k) {
                max = Math.max(max, map.get(c).peek());
            }
            res += max + 1;
        }
        return res;
    }
}
