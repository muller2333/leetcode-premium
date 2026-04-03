package no1134;

class Solution {
    public boolean isArmstrong(int n) {
        int exp = (n + "").length();
        int sum = 0;
        int temp = n;
        while (n > 0) {
            int rem = n % 10;
            sum += (int) Math.pow(rem, exp);
            n /= 10;
        }
        return temp == sum;
    }
}