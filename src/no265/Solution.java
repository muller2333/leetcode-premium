package no265;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int minCostII(int[][] costs) {
        int length = costs.length;
        int len = costs[0].length;
        int[][] dp = new int[length][len];
        dp[0] = costs[0];
        Queue<Integer> q = new PriorityQueue<Integer>();
        for (int i : costs[0]) {
            q.add(i);
        }
        for (int i = 1; i < length; i++) {
            Queue<Integer> mid = new PriorityQueue<Integer>();
            for (int j = 0; j < len; j++) {
                int pre = dp[i - 1][j];
                if (pre - q.peek() == 0) {
                    q.poll();
                    dp[i][j] = q.peek() + costs[i][j];
                    q.add(pre);
                } else {
                    dp[i][j] = q.peek() + costs[i][j];
                }
                mid.add(dp[i][j]);
            }
            q = mid;
        }
        int res = 2000;
        for (int i : dp[length - 1]) {
            res = Math.min(i, res);
        }
        return res;
    }
}
