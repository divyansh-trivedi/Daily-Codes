class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int n = matrix.size();
        
        if(n == 1) return matrix[0][0];
        vector<vector<int>> dp(n,vector<int>(n+1));
        for(int i=0;i<n;i++)dp[0][i] = matrix[0][i];

        for(int i=1;i<n;i++){
            int mini = 1e9;
            for(int j=0;j<n;j++){
                int left = (j-1 >= 0)?dp[i-1][j-1]:1e9;
                int right = (j+1 < n)?dp[i-1][j+1]:1e9;
                int up = dp[i-1][j];

                dp[i][j] = matrix[i][j] + min(left, min(right, up));
                mini = min(dp[i][j],mini);
            }
            dp[i][n] = mini;
        }
        return dp[n-1][n];
    }
};