class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int dp[][] = new int[n][n+1];

        int min = (int)1e9;
        for(int j = 0;j<n;j++){
            dp[0][j] = matrix[0][j];
            min = Math.min(min ,matrix[0][j]);
        }

        dp[0][n] = min;

        for(int i = 1 ;i <n;i++){
            min = (int)1e9;
            for(int j = 0;j<n;j++){
                int left , right , down;
                left =right =down =(int)1e9;

                if(j-1 >= 0) left = dp[i-1][j-1] + matrix[i][j];
                if(j+1 < n) right = dp[i-1][j+1] + matrix[i][j];
                down = dp[i-1][j] + matrix[i][j];

                dp[i][j] = Math.min(left , Math.min(right , down));

                min = Math.min(min , dp[i][j]);
            }
            dp[i][n] = min;
        }
        return dp[n-1][n];


    }
}