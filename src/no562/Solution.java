package no562;

class Solution {
    public int longestLine(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            int j = 0;
            while (j < n) {
                while (j < n && mat[i][j] == 0) {
                    j++;
                }
                if (j != n) {
                    if (n - j > res) {
                        int count = 1;
                        while (++j < n && mat[i][j] == 1) {
                            count++;
                        }
                        res = Math.max(res, count);
                    } else {
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (j < m) {
                while (j < m && mat[j][i] == 0) {
                    j++;
                }
                if (j != m) {
                    if (m - j > res) {
                        int count = 1;
                        while (++j < m && mat[j][i] == 1) {
                            count++;
                        }
                        res = Math.max(res, count);
                    } else {
                        break;
                    }
                }
            }
        }
        boolean[][] flags = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!flags[i][j]) {
                    int x = i;
                    int y = j;
                    while (x < m && y < n) {
                        while (x < m && y < n && mat[x][y] == 0) {
                            flags[x][y] = true;
                            x++;
                            y++;
                        }
                        if (x < m && y < n) {
                            int count = 1;
                            flags[x++][y++] = true;
                            while (x < m && y < n && mat[x][y] == 1) {
                                count++;
                                flags[x++][y++] = true;
                            }
                            res = Math.max(res, count);
                        }
                    }
                }
            }
        }
        flags = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!flags[i][j]) {
                    int x = i;
                    int y = j;
                    while (x >= 0 && y < n) {
                        while (x >= 0 && y < n && mat[x][y] == 0) {
                            flags[x][y] = true;
                            x--;
                            y++;
                        }
                        if (x >= 0 && y < n) {
                            int count = 1;
                            flags[x--][y++] = true;
                            while (x >= 0 && y < n && mat[x][y] == 1) {
                                count++;
                                flags[x--][y++] = true;
                            }
                            res = Math.max(res, count);
                        }
                    }
                }
            }
        }
        return res;
    }
}