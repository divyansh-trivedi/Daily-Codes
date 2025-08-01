class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int n = coins.size();
        vector<vector<int>> dp(n, vector<int>(amount+1,1e9));
        for(int i = 0;i<=amount;i++)
        dp[0][i] = i%coins[0] == 0? i/coins[0] : 1e9;

        for(int idx = 1;idx < n;idx++){
            for(int j=0;j <= amount;j++){
                int nt = dp[idx-1][j];
                int t =1e9;
                if(coins[idx] <= j)
                t = 1+ dp[idx][j-coins[idx]];

                dp[idx][j] = min(t,nt);
            }
        }
        return dp[n-1][amount] >= 1e9?-1:dp[n-1][amount];
    }
};