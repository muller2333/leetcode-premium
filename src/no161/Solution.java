package no161;

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int len = s.length();
        int len2 = t.length();
        int diff = len - len2;
        if (Math.abs(diff) >= 2) {
            return false;
        } else if (diff == -1) {
            if (len == 0) {
                return true;
            }
            int i = 0;
            while (i < len && s.charAt(i) == t.charAt(i)) {
                i++;
            }
            int j = i + 1;
            while (i < len && s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }
            return i == len;
        } else if (diff == 1) {
            if (len2 == 0) {
                return true;
            }
            int i = 0;
            while (i < len2 && s.charAt(i) == t.charAt(i)) {
                i++;
            }
            int j = i++;
            while (i < len && s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }
            return i == len;
        } else {
            int count = 0;
            for (int i = 0; i < len && count <= 1; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    count++;
                }
            }
            return count == 1;
        }
    }

}