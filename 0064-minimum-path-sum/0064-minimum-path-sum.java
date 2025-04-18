class Solution {
private int solve(int[][] grid,int[][] dp,int i,int j){
    if(i<0 || j<0){
        return Integer.MAX_VALUE;
    }
    if(i==0 && j==0){
        return grid[i][j];
    }
    
    if(dp[i][j]!=-1){
        return dp[i][j];
    }
    int up =  solve(grid,dp,i-1,j);
    int left = solve(grid,dp,i,j-1);
    int sum1 = (up == Integer.MAX_VALUE)?Integer.MAX_VALUE : up + grid[i][j];
    int sum2 = (left == Integer.MAX_VALUE)?Integer.MAX_VALUE : left + grid[i][j];
    return dp[i][j] = Math.min(sum1,sum2);
}
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(grid,dp,m-1,n-1);
    }
}