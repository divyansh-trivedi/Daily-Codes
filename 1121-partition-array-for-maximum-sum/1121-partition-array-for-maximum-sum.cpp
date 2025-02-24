class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        int n = arr.size();
        vector<int> dp(n+1,0);

        for(int i=n-1;i>=0;i--){
            int ans =0 , maxi =0,cnt =0;
            for(int j=i;j<min(n,i+k);j++){
                maxi = max(maxi , arr[j]);
                cnt++;
                int sum = cnt*maxi + dp[j+1];
                ans = max(sum, ans);
            }
            dp[i] = ans; 
        }
        return dp[0];

    }
};