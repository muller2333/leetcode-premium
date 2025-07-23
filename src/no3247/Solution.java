package no3247;

class Solution {
    public int subsequenceCount(int[] nums) {
        int res = 0;
        int oddRes = 0;
        int evenRes = 0;
        final int MOD = 1_000_000_007;
        for (int i : nums) {
            if ((i & 1) == 0) {
                res = (res + oddRes) % MOD;
                oddRes = (oddRes << 1) % MOD;
                evenRes = (evenRes * 2 + 1) % MOD;
            } else {
                res = (res + evenRes + 1) % MOD;
                evenRes = (oddRes + evenRes) % MOD;
                oddRes = (evenRes + 1) % MOD;
            }
        }
        return res;
    }
}