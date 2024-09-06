class Solution {
    // public int solve(int[] dp,int[] nums, int idx){
    // if(idx==0)return nums[0];
    // if(idx<0)return 0;
    // if(dp[idx]!=-1)return dp[idx];

    // int pick=nums[idx]+solve(dp,nums,idx-2);
    // int nopick=0+solve(dp,nums, idx-1);
    // return dp[idx]=Math.max(pick,nopick);

    // }
    public int rob(int[] nums) {
        // int dp[] = new int[nums.length];

       int prev=nums[0];int prev2=0;
        for (int i = 1; i < nums.length; i++) {
            int take=nums[i]+prev2;
            int nottake = 0 + prev;
           int curr = Math.max(take, nottake);
           prev2=prev;
           prev=curr;
        }
        return prev;

    }
}