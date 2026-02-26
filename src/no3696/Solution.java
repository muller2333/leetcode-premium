package no3696;

class Solution {
    public int maxDistance(String[] words) {
        int res = 0;
        int length = words.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (!words[i].equals(words[j])) {
                    res = Math.max(res, j - i + 1);
                }
            }
        } 
        return res;
    }
}
