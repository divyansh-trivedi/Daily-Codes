class Solution {
    public int solve(int nums[], int start, int end){
        int dp[]= new int[nums.length];
        dp[start]=nums[start];
        dp[start+1]=Math.max(nums[start],nums[start+1]);

        for(int i=start+2;i<=end;i++){
            int take=nums[i]+dp[i-2];
            int not=0+dp[i-1];
            dp[i]=Math.max(take, not);
        }
        return dp[end];


            }
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        if(nums.length==2)return Math.max(nums[0],nums[1]);
       
       return Math.max( solve(nums,1, nums.length-1), solve(nums, 0, nums.length-2));
    }
}