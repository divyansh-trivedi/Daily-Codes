class Solution {
    public int solve(int idx , int dp[]){
        if(idx == 0 || idx == 1)return 1;
        if(dp[idx] != -1)return dp[idx];
        int ans = solve(idx-1 , dp) + solve(idx-2 , dp);
        dp[idx] = ans;
        return dp[idx];
    }
    public int climbStairs(int idx) {
        int dp[] =new int[idx+1];
        Arrays.fill(dp ,-1);
       return solve(idx, dp);
    }
}