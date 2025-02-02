package no3199;

class Solution {
    public int tripletCount(int[] a, int[] b, int[] c) {
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                for (int k = 0; k < c.length; k++) {
                    if (Integer.bitCount(a[i] ^ b[j] ^ c[k]) % 2 == 0) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}