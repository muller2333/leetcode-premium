package no1165;

class Solution {
    public int calculateTime(String keyboard, String word) {
        int prev = 0;
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            int index = keyboard.indexOf(word.charAt(i));
            res += Math.abs(index - prev);
            prev = index;
        }
        return res;
    }
}