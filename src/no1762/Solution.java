package no1762;

import java.util.Arrays;

class Solution {
    public int[] findBuildings(int[] heights) {
        int max = -1;
        int length = heights.length;
        int left = length;
        for (int i = length - 1; i >= 0; i--) {
            int height = heights[i];
            if (height > max) {
                heights[--left] = i;
                max = height;
            }
        }
        return Arrays.copyOfRange(heights, left, length);
    }
}