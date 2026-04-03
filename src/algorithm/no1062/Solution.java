package no1062;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestRepeatingSubstring(String s) {
        int length = s.length();
        for (int i = length - 1; i > 0; i--) {
            Set<String> set = new HashSet<>();
            for (int j = 0; j <= length - i; j++) {
                String substring = s.substring(j, i + j);
                if (set.contains(substring)) {
                    return i;
                } else {
                    set.add(substring);
                }
            }
        }
        return 0;
    }
}