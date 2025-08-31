class Solution {
public:
    int MOD = 1e9 + 7;
    bool valid(vector<vector<int>>& grid, int i, int j) {
        if (i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size()) {
            return 0;
        }
        return 1;
    }
    long long solve(vector<vector<int>>& grid, int i, int j, char dir,
                    vector<vector<long long>>& dp) {
        if (!valid(grid, i, j))
            return 0;
        if (dp[i][j] != -1)
            return (dp[i][j]);
        if (i == grid.size() - 1 && j == grid[0].size() - 1)
            return 1;

        if (dir == 'L' && grid[i][j] == 1)
            return solve(grid, i + 1, j, 'U', dp);
        if (dir == 'U' && grid[i][j] == 1)
            return solve(grid, i, j + 1, 'L', dp);
        return dp[i][j] = ((solve(grid, i + 1, j, 'U', dp)) % MOD +
                           (solve(grid, i, j + 1, 'L', dp)) % MOD) %
                          MOD;
    }

    int uniquePaths(vector<vector<int>>& grid) {
        char dir = ' ';
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<long long>> dp(m, vector<long long>(n, -1));
        return (int)(solve(grid, 0, 0, dir, dp)) % MOD;
    }
};