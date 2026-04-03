package no3631;

import java.util.Arrays;

class Solution {
    public int[][] sortThreats(int[][] threats) {
        Arrays.sort(threats,
                (a, b) -> {
                    long diff = (b[1] - a[1]) * 2L + b[2] - a[2];
                    if (diff == 0) {
                        return a[0] - b[0];
                    } else {
                        return diff > 0 ? 1 : -1;
                    }
                });
        return threats;
    }
}
