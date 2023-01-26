package no1056;

class Solution {
    public boolean confusingNumber(int n) {
        if (n == 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        String s = Integer.toString(n);
        while (n > 0) {
            int remainder = n % 10;
            if (remainder == 7 || (remainder >= 2 && remainder <= 5)) {
                return false;
            } else if (remainder <= 1 || remainder == 8) {
                sb.append(remainder);
            } else if (remainder == 6) {
                sb.append(9);
            } else {
                sb.append(6);
            }
            n /= 10;
        }
        return !s.equals(sb);
    }

}