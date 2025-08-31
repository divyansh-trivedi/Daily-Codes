class Solution {
    static const int mod = 1e9+7; 
    vector<vector<vector<int>>> dp; 
private:
    int solve(vector<vector<int>>& grid , int r, int c, int prev){
        if(r < 0 || c < 0 || r >= grid.size() || c >= grid[0].size())
            return 0;
        if(r == grid.size()-1 && c == grid[0].size()-1)
            return 1;

        int temp = (prev == -1 ? 0 : (prev == 0 ? 1 : 2));
        if(dp[r][c][temp] != -1) 
            return dp[r][c][temp];

        int right = 0, down = 0;
        if(grid[r][c] == 0){
            right += solve(grid, r, c+1, 0);
            down  += solve(grid, r+1, c, 1);
        } else {
            if(prev == 0)
                down += solve(grid, r+1, c, 1);
            else 
                right += solve(grid, r, c+1, 0);
        }
        return dp[r][c][temp] = (right+down)%mod; 
    }
public:
    int uniquePaths(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size();
        dp = vector<vector<vector<int>>>(n, vector<vector<int>>(m, vector<int>(3, -1)));
        return solve(grid, 0, 0, -1);
    }
};
