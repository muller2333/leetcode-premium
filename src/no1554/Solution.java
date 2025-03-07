package no1554;

class Solution {
    public boolean differByOne(String[] dict) {
        int length = dict.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                String left = dict[i];
                String right = dict[j];
                int len = left.length();
                int count = 0;
                for (int k = 0; k < len && count < 2; k++) {
                    if (left.charAt(k) != right.charAt(k)) {
                        count++;
                    }
                }
                if (count == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}