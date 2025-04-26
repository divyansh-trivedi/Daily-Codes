class Pair{
    int row,  col;
    int val;
    Pair(int r , int c, int v){
        row =r;
        col=c;
        val=v;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n= mat.length;
        int m= mat[0].length;
        Queue<Pair> q= new LinkedList<>();
        int ans[][] = new int[n][m];
        boolean vis[][] = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                }
            }
        }

        while(!q.isEmpty()){
            Pair rem= q.poll();
            int r = rem.row;
            int c = rem.col;
            int val = rem.val;
            int dx[] ={-1,0,1,0};
            int dy[] ={0,1,0,-1};

            for(int k=0;k<4;k++){
                int nr = r+dx[k];
                int nc = c+dy[k];

                if(nr>=0 &&nc>=0&&nr<n&&nc<m){
                    if(vis[nr][nc] == false && mat[nr][nc] == 1){
                        q.add(new Pair(nr, nc, val+1));
                        ans[nr][nc] = val+1;
                        vis[nr][nc]= true;
                    }
                }
            }
        }
        return ans;
    }
}