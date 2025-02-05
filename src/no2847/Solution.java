package no2847;

class Solution {
    public String smallestNumber(long n) {
        if (n < 10) {
            return n + "";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 9; i >= 2; i--) {
            while (n % i == 0) {
                res.append(i);
                n /= i;
            }
        }
        if (n != 1) {
            return "-1";
        }
        return res.reverse().toString();
    }
}