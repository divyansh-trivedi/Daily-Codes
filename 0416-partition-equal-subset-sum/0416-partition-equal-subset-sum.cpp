class Solution {
private:
    bool solve(vector<int>& nums, int k){
        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(k+1));
        
        for(int i=0;i<n;i++)dp[i][0] = true;
        // dp[0][nums[0]] = true;

        for(int idx =1;idx<n;idx++){
            for(int tar=1;tar<=k;tar++){
                bool  nt = dp[idx-1][tar];
                bool t = false;
                if(nums[idx]<=tar)
                t = dp[idx-1][tar-nums[idx]];

                dp[idx][tar] = t | nt;
            }
        }
        return dp[n-1][k];
    }
public:
    bool canPartition(vector<int>& nums) {
        int sum=0;
        for(auto i : nums)
        sum += i;

        if(sum%2!=0)return false;
        return solve(nums, sum/2);
    }
};