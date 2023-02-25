package no1167;

import java.util.Arrays;

class Solution {
    public int connectSticks(int[] sticks) {
        int length = sticks.length;
        if (length == 1) {
            return 0;
        }
        int i = 0;
        Arrays.sort(sticks, i, length);
        int res = 0;
        while (i < length - 2) {
            int target = sticks[i] + sticks[i + 1];
            if (target <= sticks[i + 2]) {
                sticks[++i] = target;
            } else {
                int search = Arrays.binarySearch(sticks, i + 2, length, target);
                if (search < 0) {
                    search = -search - 1;
                }
                System.arraycopy(sticks, i + 2, sticks, i + 1, search - i++ - 2);
                sticks[search - 1] = target;
            }
            res += target;
        }
        return res + sticks[length - 1] + sticks[length - 2];
    }

}