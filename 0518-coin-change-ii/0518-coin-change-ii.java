class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];

        for(int T=0;T<=amount;T++){
            if(T%coins[0] == 0)
            dp[0][T] = 1;
            }

        for(int i =0;i<n;i++)dp[i][0] = 1;

        for(int i=1;i<n;i++){
            for(int j=1;j<=amount;j++){
                int nt = dp[i-1][j];

                int t =0 ;
                if(coins[i] <= j)
                t = dp[i][j - coins[i]];

                dp[i][j] = t + nt;
            }
        }
      return dp[n-1][amount];
     }
}