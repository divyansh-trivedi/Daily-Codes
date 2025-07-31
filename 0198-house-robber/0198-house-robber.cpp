class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n+1,0);
        for(int i=1;i<=n;i++){
            int p = nums[i-1] ;
            if(i-2>=0)
            p += dp[i-2];
            int np = dp[i-1];

            dp[i] = max(p,np);
        }
        return dp[n];
    }
};