package no625;

class Solution {
    public int smallestFactorization(int num) {
        if (num == 1) {
            return 1;
        }
        long res = 0;
        long mul = 1;
        for (int i = 9; i >= 2; i--) {
            while (num % i == 0) {
                num /= i;
                res += i * mul;
                mul *= 10;
            }
        }
        return num == 1 ? (res < Integer.MAX_VALUE ? (int) res : 0) : 0;
    }
}
