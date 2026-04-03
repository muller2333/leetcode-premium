package no159;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = s.length();
        if (len <= 2) {
            return len;
        }
        int res = 0;
        int prev = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.size() == 2 && !map.containsKey(c)) {
                res = Math.max(res, i - prev);
                for (char ch : map.keySet()) {
                    if (s.charAt(i - 1) != ch) {
                        prev = map.get(ch) + 1;
                        map.remove(ch);
                        break;
                    }
                }
            }
            map.put(c, i);
        }
        return Math.max(res, len - prev);
    }
}