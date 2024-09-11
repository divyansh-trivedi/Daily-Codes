import java.util.*;
class Solution {
 
    // public int solve(int dp[][],int[][] grid, int i, int j){
    //    int m=grid.length;
    //    int n=grid[0].length;

    // if(i>=m || j>=n) return Integer.MAX_VALUE;
    // if(i==m-1&& j==n-1)
    // return grid[i][j];
    // if(dp[i][j]!=-1)return dp[i][j];


    // int down=solve(dp,grid, i+1,j);
    // int right=solve(dp,grid,i,j+1);

    // return dp[i][j]=grid[i][j]+Math.min(down,right);

    // }

    public int minPathSum(int[][] ar) {
         int m=ar.length;
         int n=ar[0].length;
        int dp[][]= new int[m][n];
       dp[0][0]=ar[0][0];
       
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(i==0&&j==0)continue;
        
            else{
                int up=ar[i][j],left=ar[i][j];
                if(i>0)up+=dp[i-1][j];
                else up+=1e9;
                if(j>0)left+=dp[i][j-1];
                else
                left+=1e9;
                dp[i][j]=Math.min(up,left);
            }
        }
        
       }
       return dp[m-1][n-1];
    }
}