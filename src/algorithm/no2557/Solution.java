package no2557;

import java.util.Arrays;

class Solution {
    public int maxCount(int[] banned, int n, long maxSum) {
        int res = 0;
        Arrays.sort(banned);
        int num = 1;
        if (banned[0] > 1) {
            while (num < banned[0]) {
                maxSum -= num++;
                if (maxSum >= 0) {
                    res++;
                } else {
                    return res;
                }
            }
        }

        int length = banned.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = banned[i] + 1; j < banned[i + 1]; j++) {
                maxSum -= j;
                if (maxSum >= 0) {
                    res++;
                } else {
                    return res;
                }
            }
        }
        num = banned[length - 1] + 1;
        while (num <= n) {
            maxSum -= num++;
            if (maxSum >= 0) {
                res++;
            } else {
                return res;
            }
        }
        return res;
    }
}