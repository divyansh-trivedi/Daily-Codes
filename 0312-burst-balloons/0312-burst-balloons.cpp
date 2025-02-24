class Solution {
public:
    int maxCoins(vector<int>& a) {
    int n = a.size();
	vector<vector<int>> dp(n+2,vector<int>(n+2 , 0));
	a.push_back(1);
	a.insert(a.begin(),1);

    for(int i=n;i>=1;i--){
        for(int j=1;j<=n;j++){
            if(i>j)continue;
            int maxi = -1e9;
            for(int k=i;k<=j;k++){
                int cost = a[i-1] * a[k] * a[j+1] + dp[i][k-1]+dp[k+1][j];
                maxi = max(maxi , cost);
            }
            dp[i][j] = maxi;
        }
    }
	return dp[1][n];
    }
};