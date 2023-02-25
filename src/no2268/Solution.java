package no2268;

import java.util.Arrays;

class Solution {
    public int minimumKeypresses(String s) {
        int[] counts = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        Arrays.sort(counts);
        int res = 0;
        int limit = 9;
        int count = 1;
        for (int i = 25; i >= 0 && counts[i] > 0; i--) {
            if (limit-- > 0) {
                res += counts[i] * count;
            } else {
                res += counts[i] * ++count;
                limit = 8;
            }
        }
        return res;
    }
}