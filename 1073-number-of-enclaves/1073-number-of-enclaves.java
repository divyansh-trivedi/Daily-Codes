class Solution {
    private static int dx[]={-1, 0,1,0};
    private static int dy[]={0, 1,0,-1};
    private void dfs(int grid[][],boolean vis[][], int i, int j){
        int n= grid.length;
        int m= grid[0].length;
        vis[i][j] = true;

        for(int k=0;k<4;k++){
            int nr = i+dx[k];
            int nc = j+dy[k];

            if(nr>=0&&nc>=0&&nr<n&&nc<m){
                if(!vis[nr][nc] && grid[nr][nc]==1){
                    dfs(grid,vis,nr, nc);
                }
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n= grid.length , m= grid[0].length;
        boolean vis[][] = new boolean[n][m];

        for(int i=0;i<n;i++){
            if(grid[i][0] == 1)
            dfs(grid, vis, i ,0);
            if(grid[i][m-1] == 1)
            dfs(grid, vis, i , m-1);
        }
        for(int i=0;i<m;i++){
            if(grid[0][i] == 1)
            dfs(grid, vis, 0 ,i);
            if(grid[n-1][i] == 1)
            dfs(grid, vis, n-1 , i);
        }

        int cnt=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1&& !vis[i][j])cnt++;
            }
        }
        return cnt;
     }
}