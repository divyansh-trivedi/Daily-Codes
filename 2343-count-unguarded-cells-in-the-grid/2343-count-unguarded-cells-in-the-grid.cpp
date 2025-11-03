class Solution {
public:
    void dfs(int i, int j, int m, int n, int& nVisited, vector<vector<int>>& vis, int dirX, int dirY){
        if(i<0 || j<0 || i>=m || j>=n || vis[i][j]==-1 || vis[i][j]==2) return;
        if(vis[i][j]==0) nVisited++;
        vis[i][j]=1;
        dfs(i+dirX, j+dirY, m, n, nVisited, vis, dirX, dirY);
    }
    int countUnguarded(int m, int n, vector<vector<int>>& guards, vector<vector<int>>& walls) {
        vector<vector<int>> vis(m, vector<int>(n, 0));
        int nVisited=0;
        for(auto wall: walls) vis[wall[0]][wall[1]]=-1;
        for(auto guard: guards) vis[guard[0]][guard[1]]=2;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(vis[i][j]==2) {
                    dfs(i+1, j, m, n, nVisited, vis, 1, 0);
                    dfs(i-1, j, m, n, nVisited, vis, -1, 0);
                    dfs(i, j-1, m, n, nVisited, vis, 0, -1);
                    dfs(i, j+1, m, n, nVisited, vis, 0, 1);
                }
            }
        }
        return m*n - nVisited - walls.size() -guards.size();
    }
};