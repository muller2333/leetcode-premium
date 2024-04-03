package no555;

import java.util.Arrays;

class Solution {
    public String splitLoopedString(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            String reverse = new StringBuilder(str).reverse().toString();
            if (str.compareTo(reverse) < 0) {
                strs[i] = reverse;
            }
        }
        Arrays.sort(strs, String::compareTo);
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.reverse().toString();
    }
}
