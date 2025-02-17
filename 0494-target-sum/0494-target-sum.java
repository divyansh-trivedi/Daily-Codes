class Solution {
    public int solve(int nums[], int k , int i, int sum){
        if(i >= nums.length)return (k == sum)? 1:  0;

        return solve(nums , k, i+1,sum+nums[i]) +  solve(nums , k, i+1,sum-nums[i]);
    }
    public int findTargetSumWays(int[] nums, int target) {
        return  solve(nums  , target , 0 ,0);
    }
}