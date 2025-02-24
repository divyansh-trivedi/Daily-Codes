class Solution {
public:
    int minCost(int n, vector<int>& cuts) {
    int c = cuts.size();
    vector<vector<int>> dp(c+2,vector<int>(c+2,0));
    cuts.push_back(n);
    cuts.push_back(0);
    sort(cuts.begin(),cuts.end());
    for(int i=c;i>=1;i--){
        for(int j=1;j<=c;j++){
            if(i>j)continue;
            int mini = 1e9;
            for(int k=i;k<=j;k++){
                int ans= cuts[j+1] - cuts[i-1] + dp[i][k-1] + dp[k+1][j];
                mini = min(mini,ans);
            }
            dp[i][j] = mini;
        }
    } return dp[1][c];
    }
};