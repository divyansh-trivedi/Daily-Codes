class Solution {
    public int uniquePathsWithObstacles(int[][] nums) {
        int n = nums.length , m = nums[0].length;
        int dp[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                if(nums[i][j] == 1)dp[i][j] = 0;
                else if(i == 0&& j == 0)dp[i][j] = 1;
                else{
                    int right =0, down =0;
                    if(i>0)right = dp[i-1][j];
                    if(j>0)down = dp[i][j-1];
                    dp[i][j] = right +down;
                }
            }
        }
        return dp[n-1][m-1];
    }
}