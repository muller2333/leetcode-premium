package no3730;

import java.util.Arrays;

class Solution {
    public long maxCaloriesBurnt(int[] heights) {
        Arrays.sort(heights);
        int i = 0;
        int j = heights.length - 1;
        long res = 0;
        int pre = 0;
        while (i <= j) {
            res += (heights[j] - pre + 0L) * (heights[j] - pre);
            pre = heights[j--];
            res += (heights[i] - pre + 0L) * (heights[i] - pre);
            pre = heights[i++];
        }
        return res;
    }
}
