package no3167;

class Solution {
    public String betterCompression(String compressed) {
        char[] chars = compressed.toCharArray();
        int length = chars.length;
        int[] counts = new int[26];
        int i = 0;
        while (i < length) {
            char c = chars[i++];
            if (c <= 'z' && c >= 'a') {
                int count = 0;
                while (i < length && (chars[i] >= '0' && chars[i] <= '9')) {
                    count = count * 10 + (chars[i++] - '0');
                }
                counts[c - 'a'] += count;
            }
        }
        StringBuilder res = new StringBuilder();
        for (i = 0; i < 26; i++) {
            if (counts[i] != 0) {
                res.append((char) (i + 'a'));
                res.append(counts[i]);
            }
        }
        return res.toString();
    }
}
