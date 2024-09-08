class Solution {
    boolean flag = true;

    // public int solve(int dp[][],int m, int n, int i, int j) {
    //     // base case
    //     if (i == m && j == n)
    //         return 1;
    //     if (i > m || j > n)
    //         return 0;
    //     if(dp[i][j]!=-1)return dp[i][j];
    //     // explore all path
    //     int down = solve(dp,m, n, i + 1, j);
    //     int right = solve(dp,m, n, i, j + 1);
    //     return dp[i][j]=down + right;

    // }

    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        dp[0][0]=1;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0)continue;
                int up=0,left=0;
               if(i-1>=0) up=dp[i-1][j];
               if(j-1>=0)  left=dp[i][j-1];
                dp[i][j]=up+left;
             }
        }
    
        return dp[m-1][n-1];
    }
}