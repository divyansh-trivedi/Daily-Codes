class Solution {
public:
    int triangularSum(vector<int>& nums) {
        int n= nums.size();
        vector<vector<int>> dp(n, vector<int>(n,0));

        for(int i=0;i<n;i++)dp[0][i] = nums[i];
        int end = n;
        for(int i=1;i<n;i++){
            for(int j=0;j<n-i;j++){
                int left =  dp[i-1][j] ;
                int right = dp[i-1][j+1] ;
                dp[i][j] = (left+right)%10;

            }
        }

        return dp[n-1][0];
    }
};