package no2083;

class Solution {
    public long numberOfSubstrings(String s) {
        int[] counts = new int[26];
        long res = 0;
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        for (int count : counts) {
            res += (count + 1L) * count >> 1;
        }
        return res;
    }
}