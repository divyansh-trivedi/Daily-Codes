class Solution {
public:
    int numberOfPaths(vector<vector<int>>& grid, int k) {
        int n = grid.size();
        int m = grid[0].size();
        
        int dp[n][m][k];
        memset(dp, 0, sizeof(dp));
        
        dp[0][0][grid[0][0] % k] = 1;
        
        int mod = 1e9 + 7;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int K = 0; K < k; K++) {
                    int sum = (K + grid[i][j]) % k;
                    if(i) dp[i][j][sum] += dp[i - 1][j][K] % mod;
                    if(j) dp[i][j][sum] += dp[i][j - 1][K] % mod;
                }
            }
        }
        
        return dp[n - 1][m - 1][0] % mod;
    }
};