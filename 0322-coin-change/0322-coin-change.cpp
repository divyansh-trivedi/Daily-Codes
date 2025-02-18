class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int n = coins.size();
        vector<vector<int>> dp(coins.size() , vector<int>(amount + 1 , -1));
        for(int i = 0;i<=amount; i++)dp[0][i] = (i%coins[0] == 0) ? i/coins[0] : 1e9;

        for(int i =1 ;i<n;i++){
            for(int tar =0;tar <= amount; tar++){
                int  np = dp[i-1][tar];
                int p =1e9;
                if(coins[i]<=tar) p = 1+ dp[i][tar- coins[i]];
                dp[i][tar] = min(p , np);
            }
        }
        return dp[n-1][amount] >= 1e9 ? -1 : dp[n-1][amount];
    }
};