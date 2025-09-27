
 class Pair{
    int row;
    int col;
    int value;

    Pair(int r, int c, int v){
        row = r;
        col = c;
        value = v;
    }
 }
    class Solution {
    public int[][] updateMatrix(int[][] grid) {
       int n= grid.length , m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int [][] ans = new int[n][m];
        boolean vis[][] = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                if(grid[i][j] == 0){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = true;
                }
        }
        int dr[] = {-1,0,1,0};
        int dc[] = {0,1,0,-1};
        while (!q.isEmpty()) {
            Pair rem = q.poll();
            int r = rem.row;
            int c = rem.col;
            int v = rem.value;
            ans[r][c] = v;

            for(int k=0;k<4;k++){
                int nr = r + dr[k];
                int nc = c + dc[k];
                
                if(nr>=0&&nr<n && nc>=0 && nc<m && !vis[nr][nc]){
                    if(grid[nr][nc] == 1){
                        q.add(new Pair(nr, nc, v+1)); 
                        vis[nr][nc] = true;
                        ans[nr][nc] = v+1;
                     }
                }
            }
        }
        return ans;
    }
    
 }
 

