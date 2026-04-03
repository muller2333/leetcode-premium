package no1180;

class Solution {
    public int countLetters(String s) {
        s += " ";
        int res = 0;
        int len = s.length();
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                res += (count + 1) * count >> 1;
                count = 1;
            }
        }
        return res;
    }
}