package no340;

import java.util.*;

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        int len = s.length();
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        int prev = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.size() == k && !map.containsKey(c)) {
                res = Math.max(res, i - prev);
                int index = len;
                for (char ch : map.keySet()) {
                    index = Math.min(index, map.get(ch));
                }
                for (char ch : map.keySet()) {
                    if (map.get(ch) == index) {
                        map.remove(ch);
                        break;
                    }
                }
                prev = index + 1;
            }
            map.put(c, i);
        }
        return Math.max(res, len - prev);
    }
}