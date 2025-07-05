package no3205;

class Solution {
    public int maxScore(int[] nums) {
        int length = nums.length;
        int[] scores = new int[length];
        for (int i = 1; i < length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, scores[j] + (i - j) * nums[i]);
            }
            scores[i] = max;
        }
        return scores[length - 1];
    }
}
