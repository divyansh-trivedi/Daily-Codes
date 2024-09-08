class Solution {
    boolean flag = true;

    public int solve(int dp[][],int m, int n, int i, int j) {
        // base case
        if (i == m && j == n)
            return 1;
        if (i > m || j > n)
            return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        // explore all path
        int down = solve(dp,m, n, i + 1, j);
        int right = solve(dp,m, n, i, j + 1);
        return dp[i][j]=down + right;

    }

    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for (int[] i : dp)
            Arrays.fill(i, -1);
        return solve(dp,m - 1, n - 1, 0, 0);
    }
}