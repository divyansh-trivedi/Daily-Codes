class Pair{
    int row,col, time;
    Pair(int r, int c, int t){
        row = r;
        col = c;
        time = t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int vis[][] = new int[n][m];
        int cntFresh =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }
                
                 if(grid[i][j]==1)cntFresh++;
            }
        }

        int time =0;
        int dx[] ={-1,0,1,0};
        int dy[] ={0,1,0,-1};

        int cnt =0;
        while(!q.isEmpty()){
            Pair rem = q.poll();
            int r= rem.row;
            int c =rem.col;
            int t= rem.time;
time = Math.max(time, t);
            for(int k=0;k<4;k++){
                int newr = r+dx[k];
                int newc = c+dy[k];
                
                if(newr<0 || newc<0 || newr>=n ||newc>=m)continue;

                if(grid[newr][newc] ==1&&vis[newr][newc]!=2){
                    q.add(new Pair(newr, newc, t+1));
                    vis[newr][newc] = 2;
                    cnt++;
                }
            }
        }
        if(cnt!=cntFresh)return -1;
        else return time;

    }
}