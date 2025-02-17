class Solution {
    public int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int dp[][][] = new int[r][c][c];

        for(int j1=0;j1<c ;j1++)
            for(int j2 =0;j2<c;j2++)
                dp[r-1][j1][j2] = (j1 == j2)? grid[r-1][j1] : grid[r-1][j1] + grid[r-1][j2];
        
        for(int i =r-2;i>=0;i--){
            for(int j1 = 0;j1 < c;j1++){
                for(int j2 =0;j2<c;j2++){

                    int max = -(int)1e9;
                    for(int dj1 = -1;dj1 <2 ; dj1++){
                        for(int dj2 = -1;dj2 <2 ; dj2++){
                            int newj1 = j1 + dj1;
                            int newj2 = j2 + dj2;

                            if(newj1 >= 0 && newj1 < c && newj2 >=0 && newj2 <c){
                                int value = (j1 == j2)? grid[i][j1] : grid[i][j1] + grid[i][j2];
                                value += dp[i+1][newj1][newj2];
                                max= Math.max(max, value);
                            }

                        }
                    }

                    dp[i][j1][j2] = max;
                }
            }
        }
         return dp[0][0][c-1] ;  
        
    }
}