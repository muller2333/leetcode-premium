package no293;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> res = new ArrayList<>();
        char[] chars = currentState.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == '+' && chars[i + 1] == '+') {
                chars[i] = '-';
                chars[i + 1] = '-';
                res.add(new String(chars));
                chars[i] = '+';
                chars[i + 1] = '+';
            }
        }
        return res;
    }
}