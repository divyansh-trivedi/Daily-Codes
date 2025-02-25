class Solution {
public:
    int dr[4] = {1,0,-1,0};
    int dc[4] = {0,-1,0,1};

    void dfs(int i, int j, vector<vector<char>>& grid){
        grid[i][j] ='0';
        for(int k=0;k<4;k++){
            int newr = i+dr[k];
            int newc = j+dc[k];

            if(newr<0 || newc<0 || newr>=grid.size() ||newc>=grid[0].size())continue;

            if(grid[newr][newc] == '1')dfs(newr, newc, grid);
        }
    }
    int numIslands(vector<vector<char>>& grid) {
        int n = grid.size();
        int m=grid[0].size();

        int island =0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    island++;
                    dfs(i,j,grid);
                }
            }
        }
        return island;
    }
};