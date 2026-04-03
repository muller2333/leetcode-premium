package no750;

class Solution {
    public int countCornerRectangles(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int k = i + 1; k < m; k++) {
                        for (int x = j + 1; x < n; x++) {
                            if (grid[k][x] == 1 && grid[i][x] == 1 && grid[k][j] == 1) {
                                res++;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
