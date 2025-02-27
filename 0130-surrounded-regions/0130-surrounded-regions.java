class Solution {
     private static int dr[] = {-1,0,1,0};
    private static int dc[] = {0,1,0,-1};
    public static void dfs(char board[][], boolean vis[][] , int i, int j, int n ,int m){
        
        vis[i][j] =true;
        for(int k=0;k<4;k++){
            int nr = i + dr[k];
            int nc = j + dc[k];
            
            if(nr>=0&&nr<n && nc>=0 && nc<m && !vis[nr][nc]){
                if(board[nr][nc] == 'O')
                    dfs(board,vis,nr,nc,n,m);
            }
        }
    }
    public static void solve(char[][] board){
        int n = board.length;
        int m = board[0].length;

        boolean vis[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            if(board[i][0] == 'O' && !vis[i][0])
                dfs(board,vis,i,0,n,m);
            
            if(board[i][m-1] == 'O' && !vis[i][m-1])
                dfs(board,vis,i,m-1,n,m);
            
        }
        for(int i =0 ;i<m;i++){
            if(board[0][i] == 'O' && !vis[0][i])
                dfs(board,vis,0,i,n,m);
            if(board[n-1][i] == 'O' && !vis[n-1][i])
                dfs(board,vis,n-1,i,n,m);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'O' && !vis[i][j] )
                board[i][j] = 'X';
            }
        }
    }

}