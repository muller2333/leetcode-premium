package no266;

class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counts[c - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26 && count <= 1; i++) {
            if (counts[i] % 2 == 1) {
                count++;
            }
        }
        return count <= 1;
    }
}