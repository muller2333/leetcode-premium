package no186;

class Solution {
    public void reverseWords(char[] s) {
        int length = s.length;
        int i = 0;
        int j = length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        i = 0;
        for (int k = 0; k < length; k++) {
            if (s[k] == ' ') {
                j = k - 1;
                while (i < j) {
                    char temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                    i++;
                    j--;
                }
                i = k + 1;
            }
        }
        j = length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}