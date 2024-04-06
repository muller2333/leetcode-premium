package no1055;

class Solution {
    public int shortestWay(String source, String target) {
        char[] chars = source.toCharArray();
        char[] chars2 = target.toCharArray();
        int i = 0;
        int j = 0;
        int res = 0;
        while (j < chars2.length) {
            boolean flag = false;
            while (i < chars.length) {
                if (chars[i] == chars2[j]) {
                    i++;
                    j++;
                    flag = true;
                    if (j == chars2.length) {
                        break;
                    }
                } else {
                    i++;
                }
            }
            if (!flag) {
                return -1;
            }
            i = 0;
            res++;
        }
        return res;
    }
}