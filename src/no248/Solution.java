package no248;

class Solution {
    int ans = 0;
    final char[][] choices = new char[][] { new char[] { '1', '6', '8', '9' }, new char[] { '0', '1', '6', '8', '9' },
            new char[] { '0', '1', '8' } };

    public int strobogrammaticInRange(String low, String high) {
        int len = low.length();
        int len2 = high.length();
        long left = Long.parseLong(low);
        long right = Long.parseLong(high);
        for (int n = len; n <= len2; n++) {
            findStrobogrammatic(n, left, right);
        }
        return ans;
    }

    public void findStrobogrammatic(int n, long left, long right) {
        if (n == 1) {
            if (0 <= right && 0 >= left) {
                ans++;
            }
            if (1 <= right && 1 >= left) {
                ans++;
            }
            if (8 <= right && 8 >= left) {
                ans++;
            }
            return;
        }
        char[] chars = new char[n];
        backTrack(chars, n, 0, left, right);
    }

    public void backTrack(char[] chars, int n, int i, long left, long right) {
        if (i == (n + 1) >> 1) {
            long num = Long.parseLong(new String(chars));
            if (num <= right && num >= left) {
                ans++;
            }
        } else {
            char[] ch = choices[1];
            if (i == 0) {
                ch = choices[0];
            } else if (i == n >> 1) {
                ch = choices[2];
            }
            for (char c : ch) {
                chars[n - 1 - i] = chars[i] = c;
                if (c == '6') {
                    chars[n - 1 - i] = '9';
                } else if (c == '9') {
                    chars[n - 1 - i] = '6';
                }
                backTrack(chars, n, i + 1, left, right);
            }
        }
    }
}