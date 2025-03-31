class Solution {
    public int solve(int nums[], int target, int idx, int sum){
        if(idx>=nums.length){
            if(sum==target)
            return 1;
            else 
            return 0;
        }

        int plus = solve(nums, target, idx+1, sum+nums[idx]);
        int minus = solve(nums, target, idx+1, sum+nums[idx]*-1);

        return plus + minus;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, target,0,0);

    }
}