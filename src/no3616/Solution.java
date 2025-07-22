package no3616;

class Solution {
    public int totalReplacements(int[] ranks) {
        int res = 0;
        int pre = ranks[0];
        for (int i : ranks) {
            if (i < pre) {
                pre = i;
                res++;
            }
        }
        return res++;
    }
}