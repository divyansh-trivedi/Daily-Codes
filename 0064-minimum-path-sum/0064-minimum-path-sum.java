import java.util.*;
class Solution {
 
    public int solve(int dp[][],int[][] grid, int i, int j){
       int m=grid.length;
       int n=grid[0].length;

    if(i>=m || j>=n) return Integer.MAX_VALUE;
    if(i==m-1&& j==n-1)
    return grid[i][j];
    if(dp[i][j]!=-1)return dp[i][j];


    int down=solve(dp,grid, i+1,j);
    int right=solve(dp,grid,i,j+1);

    return dp[i][j]=grid[i][j]+Math.min(down,right);

    }

    public int minPathSum(int[][] grid) {
        int dp[][]= new int[grid.length][grid[0].length];
        for(int[] i:dp)Arrays.fill(i,-1);
        return solve(dp,grid, 0,0);
    }
}