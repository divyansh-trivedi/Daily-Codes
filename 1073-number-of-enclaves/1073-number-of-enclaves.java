class Solution {
     private static int  solve(int[][] grid){
        Queue<Pair> q = new LinkedList<>();
        int n= grid.length;
        int m=grid[0].length;
        boolean vis[][] = new boolean[n][m];

        for(int i=0;i<n;i++){
            for (int j = 0; j < m; j++) {
                if((i==0 || i==n-1||j==0||j==m-1) && grid[i][j] == 1){
                    q.add(new Pair(i, j));
                    vis[i][j] = true;
                }
            }
        }
        int dr[] = {-1,0,1,0};
        int dc[] = {0,1,0,-1};

        while(!q.isEmpty()){
            Pair rem = q.poll();
            int row = rem.r;
            int col = rem.c;

            for(int k=0;k<4;k++){
                int nr = row + dr[k];
                int nc = col + dc[k];
                
                if(nr>=0&&nr<n && nc>=0 && nc<m && !vis[nr][nc]){
                    if(grid[nr][nc] == 1){
                       vis[nr][nc] = true;
                       q.add(new Pair(nr, nc));
                     }else continue;

                }
            }        
        }

        int cnt =0;

        for(int i=0;i<n;i++){
            for (int j = 0; j < m; j++) {
                if(!vis[i][j] && grid[i][j] == 1)cnt++;
            }
        }
        return cnt;

    }
    public int numEnclaves(int[][] grid) {
        return solve(grid);
    }
}
class Pair {
    int r;
    int c;
    Pair(int r, int c){
        this.r= r;
        this.c =c;
    }
}