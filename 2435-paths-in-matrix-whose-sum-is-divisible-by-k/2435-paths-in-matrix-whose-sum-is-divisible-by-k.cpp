class Solution {
public:
    int numberOfPaths(vector<vector<int>>& grid, int k) {
        int  n = grid.size() ;
        int  m = grid[0].size();
        int dp[n] [m][k];
        memset(dp,0,sizeof(dp));

        dp[0][0][grid[0][0]%k] = 1;
        int MOD = 1e9+7;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int r=0; r<k; r++){
                    int cur = dp[i][j][r];
                    if (cur == 0) continue;

                    // move down
                    if (i+1 < n) {
                        int nr = (r+grid[i+1][j]) % k;
                        dp[i + 1][j][nr] = (dp[i+1][j][nr]+cur) % MOD;
                    }

                    // move right
                    if (j+1< m) {
                        int nr = (r + grid[i][j+1]) % k;
                        dp[i][j+1][nr] = (dp[i][j+1][nr]+cur) % MOD;
                    }
                }
            }
        }
        return dp[n-1][m-1][0]%MOD;
    }
};