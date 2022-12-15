package no2330;

class Solution {
    public boolean makePalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        int count = 0;
        char[] chars = s.toCharArray();
        while (i < j) {
            if (chars[i] != chars[j]) {
                count++;
            }
            i++;
            j--;
        }
        return count <= 2;
    }
}