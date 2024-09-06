class Solution {
//     public int solve(int[] dp,int[] nums, int idx){
//         if(idx==0)return nums[0];
//         if(idx<0)return 0;
//         if(dp[idx]!=-1)return dp[idx];


//         int pick=nums[idx]+solve(dp,nums,idx-2);
//         int nopick=0+solve(dp,nums, idx-1);
// return dp[idx]=Math.max(pick,nopick);
        
//     }
    public int rob(int[] nums) {
        int dp[]= new int[nums.length];
      
        dp[0]=nums[0];
  for(int i=1;i<nums.length;i++){
    int take=nums[i];
    if(i>1)
    take+=dp[i-2];
    int nottake=0+dp[i-1];
    dp[i]=Math.max(take, nottake);
  }return dp[nums.length-1];

    }
}