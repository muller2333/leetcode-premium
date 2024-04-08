package no320;

import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<String> generateAbbreviations(String word) {
        char[] chars = word.toCharArray();
        int length = chars.length;
        List<String> res = new ArrayList<>();
        backTrack(res, new char[length], chars, 0);
        return res;
    }

    public void backTrack(List<String> res, char[] chars, char[] chs, int index) {
        if (index == chars.length) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (char c : chars) {
                if (c == '1') {
                    count++;
                } else {
                    if (count > 0) {
                        sb.append(count);
                    }
                    count = 0;
                    sb.append(c);
                }
            }
            if (count > 0) {
                sb.append(count);
            }
            res.add(sb.toString());
        } else {
            char[] choices = { '1', chs[index] };
            for (char c : choices) {
                chars[index] = c;
                backTrack(res, chars, chs, index + 1);
            }
        }
    }
}