package no758;

import java.util.Arrays;

class Solution {
    public String boldWords(String[] words, String s) {
        int length = s.length();
        boolean[] flags = new boolean[length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int index = 0;
            while ((index = s.indexOf(word, index)) >= 0) {
                int len = word.length();
                Arrays.fill(flags, index, index + len, true);
                index++;
            }
        }
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < length) {
            if (flags[i]) {
                res.append("<b>");
                while (i < length && flags[i]) {
                    res.append(s.charAt(i++));
                }
                res.append("</b>");
            } else {
                res.append(s.charAt(i++));
            }
        }
        return res.toString();
    }
}