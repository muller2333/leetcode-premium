package no1196;

import java.util.Arrays;

class Solution {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int res = 0;
        int sum = 0;
        for (int w : weight) {
            sum += w;
            if (sum > 5000) {
                break;
            } else {
                res++;
            }
        }
        return res;
    }
}