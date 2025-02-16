class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int dp[][] = new int[n][n];

        int min = (int) 1e9;
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int left = (j - 1 >= 0) ? dp[i - 1][j - 1] + matrix[i][j] : (int) 1e9;
                int right = (j + 1 < n) ? dp[i - 1][j + 1] + matrix[i][j] : (int) 1e9;
                int down = dp[i - 1][j] + matrix[i][j];

                dp[i][j] = Math.min(left, Math.min(right, down));
            }
        }

        int result = (int) 1e9;
        for (int j = 0; j < n; j++) {
            result = Math.min(result, dp[n - 1][j]);
        }
        return result;
    }
}
