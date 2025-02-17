class Solution {
    public int solve(int n, int k, int arr[]){
        int dp[][] = new int[n+1][k+1];

        for(int i =0;i<=n;i++)dp[i][0] =1;

        for(int i =1;i<=n;i++){
            for(int j=0;j<=k;j++){
                int np = dp[i-1][j];
                int p =0;
                if(j >= arr[i-1])
                p = dp[i-1][j-arr[i-1]];

                dp[i][j] = p | np;
            }
        }
        return dp[n][k];
    }
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if(sum%2 !=0)return false;
        return solve(nums.length, sum/2 ,nums)==1;
    }
}