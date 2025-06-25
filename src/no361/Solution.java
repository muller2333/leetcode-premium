package no361;

class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] counts = new int[m][n];
        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {
                    cnt = 0;
                } else if (grid[i][j] == 'E') {
                    cnt++;
                } else {
                    counts[i][j] = cnt;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 'W') {
                    cnt = 0;
                } else if (grid[i][j] == 'E') {
                    cnt++;
                } else {
                    counts[i][j] += cnt;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < m; j++) {
                if (grid[j][i] == 'W') {
                    cnt = 0;
                } else if (grid[j][i] == 'E') {
                    cnt++;
                } else {
                    counts[j][i] += cnt;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (grid[j][i] == 'W') {
                    cnt = 0;
                } else if (grid[j][i] == 'E') {
                    cnt++;
                } else {
                    counts[j][i] += cnt;
                }
            }
        }
        for (int[] arr : counts) {
            for (int i : arr) {
                res = Math.max(res, i);
            }
        }
        return res;
    }
}