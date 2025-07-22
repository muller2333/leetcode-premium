package no3581;

class Solution {
    public int countOddLetters(int n) {
        String[] strs = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        int[] counts = new int[26];
        while (n > 0) {
            for (char c : strs[n % 10].toCharArray()) {
                counts[c - 'a']++;
            }
            n /= 10;
        }
        int res = 0;
        for (int i : counts) {
            if (i % 2 == 1) {
                res++;
            }
        }
        return res;
    }
}
