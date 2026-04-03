package no1065;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> list = new ArrayList<>();
        for (String word : words) {
            int index = 0;
            int len = word.length();
            while ((index = text.indexOf(word, index)) >= 0) {
                list.add(new int[] { index, index + len - 1 });
                index++;
            }
        }
        int[][] res = list.toArray(new int[list.size()][]);
        Arrays.sort(res, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        return res;
    }

}