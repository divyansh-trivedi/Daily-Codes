class Solution {
public:

    int solve(vector <int> &arr , int n , int i, int k , vector <int> &dp){
        if(i == n){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int maxEle = INT_MIN;
        int maxi = INT_MIN;
        for(int l=i ; l<i+k  && l<n; l++){
            maxEle = max(maxEle , arr[l]);
            maxi = max(maxi , (l-i+1)*maxEle + solve(arr,n,l+1,k,dp) );
        }
        return dp[i] = maxi;
    }

    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        int n = arr.size();
        vector <int> dp(n+1,-1);
        return solve(arr,n,0,k,dp);
    }
};