package no3792;

class Solution {
    public int sumOfBlocks(int n) {
        long res = 1;
        int pre = 1;
        final int MOD = 1_000_000_007;
        for (int i = 2; i <= n; i++) {
            int start = pre + i - 1;
            pre = start;
            long prod = start;
            for (int j = start + 1; j < start + i; j++) {
                prod = (prod * j) % MOD;
            }
            res = (res + prod) % MOD;
        }
        return (int) (res % MOD);
    }
}
