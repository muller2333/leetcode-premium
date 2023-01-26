package no1933;

class Solution {
    public boolean isDecomposable(String s) {
        int count = 1;
        int cnt = 0;
        int length = s.length();
        int remainder;
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                remainder = count % 3;
                if (remainder == 1 || (remainder == 2 && cnt++ == 1)) {
                    return false;
                }
                count = 1;
            }
        }
        remainder = count % 3;
        return remainder == 1 ? false : cnt == ++remainder % 3;
    }
}