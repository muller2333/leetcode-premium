package no1087;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    int idx = 0;

    public String[] expand(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        List<String[]> list = new ArrayList<>();
        while (i < length) {
            while (i < length && chars[i] != '{') {
                sb.append(chars[i++]);
            }
            if (sb.length() != 0) {
                list.add(sb.toString().split(","));
                sb = new StringBuilder();
            }
            while (++i < length && chars[i] != '}') {
                sb.append(chars[i]);
            }
            if (sb.length() != 0) {
                list.add(sb.toString().split(","));
                sb = new StringBuilder();
            }
            i++;
        }
        int count = 1;
        for (String[] strs : list) {
            Arrays.sort(strs);
            count *= strs.length;
        }
        String[] res = new String[count];
        backTrace(list, list.size(), 0, new StringBuilder(), res);
        return res;
    }

    public void backTrace(List<String[]> list, final int size, int i, StringBuilder pre, String[] res) {
        if (i == size) {
            res[idx++] = pre.toString();
        } else {
            for (int j = 0; j < list.get(i).length; j++) {
                pre.append(list.get(i)[j]);
                backTrace(list, size, i + 1, pre, res);
                pre.deleteCharAt(i);
            }
        }
    }
}
