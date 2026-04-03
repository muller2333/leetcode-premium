package no2743;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfSpecialSubstrings(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        long res = 0;
        int i = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (j < length) {
            while (j < length && !map.containsKey(chars[j])) {
                map.put(chars[j], j++);
            }
            if (j != length) {
                int limit = map.get(chars[j]);
                while (i <= limit) {
                    res += map.size();
                    map.remove(chars[i++]);
                }
            } else {
                res += (length - i) * (length - i + 1L) / 2;
            }
        }
        return (int) res;
    }
}