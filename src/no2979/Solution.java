package no2979;

class Solution {
    public int mostExpensiveItem(int primeOne, int primeTwo) {
        int min = Math.min(primeOne, primeTwo);
        int max = Math.max(primeOne, primeTwo);
        int res = 0;
        for (int i = 1; i < primeOne * primeTwo; i++) {
            if (i % min > 0 && i % max > 0) {
                boolean flag = false;
                for (int j = 1; j <= i / max; j++) {
                    if ((i - j * max) % min == 0) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    res = i;
                }
            }
        }
        return res;
    }
}