class Solution {
    public String filterCharacters(String s, int k) {
        char[] chars = s.toCharArray();
        int[] counts = new int[26];
        for (char c : chars) {
            counts[c - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        for (char c : chars) {
            if (counts[c - 'a'] < k) {
                res.append(c);
            }
        }
        return res.toString();
    }
}