class Solution {
    public int findWays(int[] nums, int target){
        int n = nums.length;
        int dp[][] = new int[n][target+1];

        if(nums[0] == 0)dp[0][0] = 2;
        else dp[0][0] = 1;

        if(nums[0] !=0 && nums[0] <= target)dp[0][nums[0]] = 1;

        for(int i=1;i<n;i++){
            for(int j=0;j<=target;j++){
                int nt = dp[i-1][j];

                int t = 0;
                if(nums[i]<=j)
                t = dp[i-1][j - nums[i]];

                dp[i][j] = nt + t;
            }
        }
        return dp[n-1][target];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int ts = Arrays.stream(nums).sum();
        if(ts - target < 0 || (ts - target)%2 == 1)return 0;
       return findWays(nums, (ts - target)/2);
        
    }
}