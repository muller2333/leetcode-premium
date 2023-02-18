package no2113;

class Solution {
    public int[] elementInNums(int[] nums, int[][] queries) {
        int len = nums.length;
        final int LEN = len << 1;
        int length = queries.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            int time = queries[i][0];
            int idx = time % LEN;
            int curLen = Math.abs(idx - len);
            int index = queries[i][1];
            if (index < curLen) {
                res[i] = nums[(idx < len ? idx : 0) + index];
            } else {
                res[i] = -1;
            }
        }
        return res;
    }
}