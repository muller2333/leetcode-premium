package no1100;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length < k) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
        int res = map.size() == k ? 1 : 0;
        for (int i = 1; i <= length - k; i++) {
            char c = chars[i - 1];
            if (chars[i + k - 1] != c) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
                map.put(chars[i + k - 1], map.getOrDefault(chars[i + k - 1], 0) + 1);
            }
            if (map.size() == k) {
                res++;
            }
        }
        return res;
    }
}