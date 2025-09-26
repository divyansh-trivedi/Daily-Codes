class Solution {
    public int solve(int[] nums , int n , int prev, int dp[][]){
        if(n >= nums.length)return 0;
        if(dp[n][prev+1] != -1)return dp[n][prev+1];
        int t=-(int)1e9;
        if(prev == -1 || nums[n] > nums[prev])
            t = 1+ solve(nums, n+1 , n,dp);
            int nt = 0 + solve(nums, n+1, prev,dp);

            return  dp[n][prev+1]=Math.max(nt ,t);
    }
    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length][nums.length+1];
        for(int i[]:dp)
        Arrays.fill(i,-1);
        return solve(nums, 0 , -1,dp);
    }
}