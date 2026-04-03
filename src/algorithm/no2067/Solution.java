package no2067;

class Solution {
    public int equalCountSubstrings(String s, int count) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int[][] counts = new int[length + 1][26];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < 26; j++) {
                counts[i + 1][j] = counts[i][j];
            }
            counts[i + 1][chars[i] - 'a']++;
        }
        int res = 0;
        for (int i = count - 1; i < length; i++) {
            int limit = Math.max(0, i - 26 * count + 1);
            for (int j = i - count + 1; j >= limit; j -= count) {
                int[] cnts = new int[26];
                boolean flag = true;
                for (int k = 0; k < 26; k++) {
                    cnts[k] = counts[i + 1][k] - counts[j][k];
                    if (cnts[k] != 0 && cnts[k] != count) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res++;
                }
            }
        }
        return res;
    }
}
