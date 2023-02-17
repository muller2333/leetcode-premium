package no2323;

import java.util.Arrays;

class Solution {
    public int minimumTime(int[] jobs, int[] workers) {
        Arrays.sort(jobs);
        Arrays.sort(workers);
        int res = 1;
        for (int i = 0; i < jobs.length; i++) {
            int a = jobs[i];
            int b = workers[i];
            if (a > b) {
                res = Math.max((a / b) + (a % b == 0 ? 0 : 1), res);
            }
        }
        return res;
    }
}