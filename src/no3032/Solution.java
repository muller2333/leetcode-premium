package no3032;

class Solution {
    public int numberCount(int a, int b) {
        int res = b - a + 1;
        for (int i = a; i <= b; i++) {
            int[] counts = new int[10];
            int tmp = i;
            while (tmp > 0) {
                if (counts[tmp % 10] == 1) {
                    res--;
                    break;
                }
                counts[tmp % 10]++;
                tmp /= 10;
            }
        }
        return res;
    }
}
