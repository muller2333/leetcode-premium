package no3817;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> goodIndices(String s) {
        List<Integer> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            res.add(0);
        }
        int length = chars.length;
        for (int i = 1; i < length; i++) {
            int temp = i;
            int j = i;
            while (temp > 0) {
                if (temp % 10 != chars[j--] - '0') {
                    break;
                }
                temp /= 10;
            }
            if (temp == 0) {
                res.add(i);
            }
        }
        return res;
    }
}