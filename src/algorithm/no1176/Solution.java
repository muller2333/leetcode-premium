package no1176;

class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int res = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += calories[i];
        }
        if (sum > upper) {
            res++;
        } else if (sum < lower) {
            res--;
        }
        int length = calories.length;
        for (int i = 1; i <= length - k; i++) {
            sum += calories[i + k - 1] - calories[i - 1];
            if (sum > upper) {
                res++;
            } else if (sum < lower) {
                res--;
            }
        }
        return res;
    }
}