class Solution {
    int r, c;

    public int cherryPickup(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        int dp[][][] = new int[r][c][c];

        for (int j1 = 0; j1 < c; j1++) {
            for (int j2 = 0; j2 < c; j2++) {
                dp[r - 1][j1][j2] = (j1 == j2) ? grid[r - 1][j1] : grid[r - 1][j1] + grid[r - 1][j2];
            }
        }

        for (int i = r - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < c; j1++) {
                for (int j2 = 0; j2 < c; j2++) {
                    int max = -(int) 1e7;

                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int newJ1 = j1 + di;
                            int newJ2 = j2 + dj;

                            if (newJ1 >= 0 && newJ1 < c && newJ2 >= 0 && newJ2 < c) {
                                int value = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
                                value += dp[i + 1][newJ1][newJ2];
                                max = Math.max(max, value);
                            }
                        }
                    }

                    dp[i][j1][j2] = max;
                }
            }
        }

        return dp[0][0][c - 1];
    }
}
