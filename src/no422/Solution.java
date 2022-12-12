package no422;

import java.util.List;

class Solution {
    public boolean validWordSquare(List<String> words) {
        int size = words.size();
        int max = 0;
        for (String word : words) {
            max = Math.max(max, word.length());
        }
        if (size != max) {
            return false;
        }
        max = Math.min(max, size);
        for (int i = 0; i < max; i++) {
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                if (i > word.length() - 1) {
                    break;
                }
                sb.append(word.charAt(i));
            }
            if (!sb.toString().equals(words.get(i))) {
                return false;
            }
        }
        return true;
    }
}