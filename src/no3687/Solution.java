package no3687;

public class Solution {
    public int lateFee(int[] daysLate) {
        int res = 0;
        for (int i : daysLate) {
            if (i == 1) {
                res++;
            } else if (i <= 5) {
                res += 2 * i;
            } else {
                res += 3 * i;
            }
        }
        return res;
    }
}
