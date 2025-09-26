class Solution {
public:
    int cherryPickup(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size();
        vector<vector<vector<int>>> dp(n,vector<vector<int>> (m,vector<int>(m,0)));

        for(int j1=0;j1<m;j1++)
            for(int j2=0;j2<m;j2++)
                dp[n-1][j1][j2] = (j1 == j2)?grid[n-1][j1] : grid[n-1][j1]+ grid[n-1][j2];

        for(int i=n-2;i>=0;i--){
            for(int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    int maxi = -1e9;
                    for(int dj1 = -1;dj1<2;dj1++){
                        for(int dj2 = -1;dj2<2;dj2++){
                            int newj1 = j1+dj1;
                            int newj2 = j2+dj2;
                            if(newj1>-1 && newj1<m && newj2>-1 && newj2<m){
                                int points = dp[i+1][newj1][newj2];
                                points += (j1 == j2)?grid[i][j1] : grid[i][j1] +grid[i][j2];
                                maxi = max(maxi , points);
                            }
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][m-1];
    }
};