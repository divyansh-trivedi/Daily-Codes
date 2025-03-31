class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int dp[][] = new int[n][amount+1];

        for(int i[]: dp)Arrays.fill(i,(int)1e9);

        for(int tar=0;tar<=amount;tar++)
           dp[0][tar] = (tar % coins[0] == 0)? tar / coins[0] : (int)1e9;

        for(int i=1;i<n;i++){
            for(int tar =0;tar<=amount;tar++){
                int np = dp[i-1][tar];

                int p = (int)1e9;

                if(coins[i] <= tar)
                p =  1 + dp[i][tar - coins[i]];

                dp[i][tar] = Math.min(p , np);
            }
        }
        return dp[n-1][amount] >= (int)1e9 ? -1 : dp[n-1][amount];  
    }
}