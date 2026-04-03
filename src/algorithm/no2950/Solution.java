package no2950;

class Solution {
    public int countDivisibleSubstrings(String word) {
        char[] chars = word.toCharArray();
        int length = chars.length;
        int[] arr = new int[] { 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9 };
        int res = 0;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum += arr[chars[j] - 'a'];
                if (sum % (j - i + 1) == 0) {
                    res++;
                }
            }
        }
        return res;
    }
}