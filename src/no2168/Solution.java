package no2168;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int equalDigitFrequency(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        Set<String> strs = new HashSet<>();
        for (int i = 0; i < length; i++) {
            int[] counts = new int[10];
            for (int j = i; j < length; j++) {
                char c = chars[j];
                counts[c - '0']++;
                Set<Integer> set = new HashSet<>();
                boolean flag = true;
                for (int k : counts) {
                    if (k != 0) {
                        set.add(k);
                        if (set.size() == 2) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    strs.add(s.substring(i, j + 1));
                }
            }
        }
        return strs.size();
    }
}
