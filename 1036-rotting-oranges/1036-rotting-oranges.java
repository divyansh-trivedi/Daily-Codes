class Solution {
    class Pair{
        int row ;
        int col; int time;
        Pair(int r, int c , int t){
            row = r; col=c ; time =t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int vis[][] = new int[n][m];
        
        int cntFresh =0 ;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    vis[i][j] =2;
                }else 
                    vis[i][j]=0;

                if(grid[i][j]==1)
                    cntFresh++;
            }
        }

        int time =0;
        int dr[] = {-1,0,1,0};
        int dc[] = {0,1,0,-1};

            int cnt =0;
        while(!q.isEmpty()){
            Pair rem = q.poll();
            int r = rem.row;
            int c = rem.col;
            int t = rem.time;

            time = Math.max(t, time);

            for(int k=0;k<4;k++){
                int newRow = dr[k] + r;
                int newCol = dc[k] + c;

                if(newRow < 0|| newRow >= n || newCol <0 || newCol >= m)continue;
                if(grid[newRow][newCol] == 1 && vis[newRow][newCol] != 2){
                    q.add(new Pair(newRow, newCol , t +1));
                    vis[newRow][newCol] = 2;
                    cnt++;
                }
            }
        }

        if(cntFresh != cnt)return -1;
        return time;
    }
}