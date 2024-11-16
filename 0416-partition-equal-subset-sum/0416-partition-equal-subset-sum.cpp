class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int sum = 0;
        for (int num : nums) 
            sum += num;

        if (sum % 2 != 0) 
            return false;

        int halfsum = sum / 2;
        int n = nums.size();

        vector<vector<bool>> dp(n + 1, vector<bool>(halfsum + 1, false));

        // Base cases
        for (int i = 0; i <= n; i++) 
            dp[i][0] = true; // sum = 0 is achievable with any number of items

        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= halfsum; s++) {
                if (nums[i - 1] > s) {
                    // If the current number is greater than the target sum, it cannot be included
                    dp[i][s] = dp[i - 1][s];
                } else {
                    // Either include the number or don't
                    dp[i][s] = dp[i - 1][s] || dp[i - 1][s - nums[i - 1]];
                }
            }
        }

        return dp[n][halfsum];
    }
};
