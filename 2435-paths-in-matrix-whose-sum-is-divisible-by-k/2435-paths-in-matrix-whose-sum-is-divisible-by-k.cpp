class Solution {
int n, m;
vector<vector<vector<int>>> dp;
const int MOD = 1e9+7; 
private:
    int solve(vector<vector<int>>& grid, int k, int i, int j, int sum){
        if(i == n-1 && j == m-1)
            return (sum + grid[i][j])%k == 0;
        if(i == n || j == m)return 0;
        if(dp[i][j][sum] != -1)return dp[i][j][sum];

        return dp[i][j][sum] = (solve(grid, k, i+1, j, (sum+grid[i][j])%k) 
                            + solve(grid, k, i, j+1,( sum+grid[i][j])%k)) % MOD;
    }
public:
    int numberOfPaths(vector<vector<int>>& grid, int k) {
        n = grid.size() , m =grid[0].size();
        dp.assign(n, vector<vector<int>>(m, vector<int>(k, -1)));
        return solve(grid, k,0,0,0);
    }
};