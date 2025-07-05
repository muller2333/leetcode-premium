package no2907;

class Solution {
    public int maxProfit(int[] prices, int[] profits) {
        int res = -1;
        int length = prices.length;
        int[] dp = new int[length];
        for (int i = 1; i < length - 1; i++) {
            int max = -1;
            for (int j = 0; j < i; j++) {
                if (prices[j] < prices[i]) {
                    max = Math.max(max, profits[j]);
                }
            }
            dp[i] = max;
        }
        for (int i = length - 2; i > 0; i--) {
            if (dp[i] != -1) {
                int max = -1;
                for (int j = i + 1; j < length; j++) {
                    if (prices[j] > prices[i]) {
                        max = Math.max(max, profits[j]);
                    }
                }
                if (max != -1) {
                    res = Math.max(res, dp[i] + max + profits[i]);
                }
            }
        }
        return res;
    }
}