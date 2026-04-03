package no247;

import java.util.ArrayList;
import java.util.List;

class Solution {
    final char[][] choices = new char[][] { new char[] { '1', '6', '8', '9' }, new char[] { '0', '1', '6', '8', '9' },
            new char[] { '0', '1', '8' } };

    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if (n == 1) {
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }
        char[] chars = new char[n];
        backTrack(chars, n, res, 0);
        return res;
    }

    public void backTrack(char[] chars, int n, List<String> res, int i) {
        if (i == (n + 1) >> 1) {
            res.add(new String(chars));
        } else {
            char[] ch = choices[1];
            if (i == 0) {
                ch = choices[0];
            } else if (i == n >> 1) {
                ch = choices[2];
            }
            for (char c : ch) {
                chars[n - 1 - i] = chars[i] = c;
                if (c == '6') {
                    chars[n - 1 - i] = '9';
                } else if (c == '9') {
                    chars[n - 1 - i] = '6';
                }
                backTrack(chars, n, res, i + 1);
            }
        }
    }
}