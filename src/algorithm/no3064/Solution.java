package no3064;

class Problem {
    private int n;

    int commonSetBits(int num) {
        return Integer.bitCount(num & n);
    }
}

class Solution extends Problem {
    public int findNumber() {
        int res = 0;
        for (int i = 29; i >= 0; i--) {
            res = res * 2 + commonSetBits(1 << i);
        }
        return res;
    }
}
