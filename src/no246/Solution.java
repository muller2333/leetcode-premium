package no246;

class Solution {
    public boolean isStrobogrammatic(String num) {
        int len = num.length();
        char[] chars = {'0', '1', ' ', ' ', ' ', ' ', '9', ' ', '8', '6'};
        for (int i = 0; i < len; i++) {
            char c = num.charAt(i);
            if (chars[c - '0'] == ' ' || num.charAt(len - 1 - i) != chars[c - '0']) {
                return false;
            }
        }
        return true;
    }
}