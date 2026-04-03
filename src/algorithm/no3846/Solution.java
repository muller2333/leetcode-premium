package no3846;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalDistance(String s) {
        char[][] chars = new char[3][];
        chars[0] = new char[] { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };
        chars[1] = new char[] { 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l' };
        chars[2] = new char[] { 'z', 'x', 'c', 'v', 'b', 'n', 'm' };
        int res = 0;
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            int limit = chars[i].length;
            for (int j = 0; j < limit; j++) {
                map.put(chars[i][j], new int[] { i, j });
            }
        }
        char[] chs = s.toCharArray();
        for (int i = 1; i < chs.length; i++) {
            res += Math.abs(map.get(chs[i])[0] - map.get(chs[i - 1])[0])
                    + Math.abs(map.get(chs[i])[1] - map.get(chs[i - 1])[1]);
        }
        return res + Math.abs(map.get(chs[0])[0] - map.get('a')[0])
                + Math.abs(map.get(chs[0])[1] - map.get('a')[1]);
    }
}