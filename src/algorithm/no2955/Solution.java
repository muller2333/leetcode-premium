package no2955;

class Solution {
    public int[] sameEndSubstringCount(String s, int[][] queries) {
        int length = queries.length;
        int len = s.length();
        int[] res = new int[length];
        int[][] counts = new int[len + 1][26];
        counts[0] = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            counts[i + 1] = new int[26];
            for (int j = 0; j < 26; j++) {
                counts[i + 1][j] = counts[i][j];
            }
            counts[i + 1][chars[i] - 'a']++;
        }
        for (int i = 0; i < length; i++) {
            int[] query = queries[i];
            int left = query[0];
            int right = query[1];
            int ans = 0;
            for (int j = 0; j < 26; j++) {
                int cnt = counts[right + 1][j] - counts[left][j];
                ans += (cnt + 1) * cnt / 2;
            }
            res[i] = ans;
        }
        return res;
    }
}
