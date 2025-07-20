package no573;

class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int x = tree[0];
        int y = tree[1];
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int[] arr : nuts) {
            int dist = Math.abs(x - arr[0]) +
                    Math.abs(y - arr[1]);
            sum += dist;
            res = Math.min(res,
                    Math.abs(squirrel[0] - arr[0]) + Math.abs(squirrel[1] - arr[1]) - dist);
        }
        return res + 2 * sum;
    }
}