class Solution {
public:
    vector<string> list = {"RYR", "YRY", "GRY", "RYG", "YRG", "GRG", "RGR", "YGR", "GYR", "RGY", "YGY", "GYG"};
    const int mod = 1e9+7;
    vector<vector<int>> dp;
    bool check(string &a, string &b){
        for(int i = 0; i < a.size(); i++)
            if(a[i] == b[i])return false;

        return true;
    }
    int solve(int remRows, int prevIdx){
        if(remRows == 0)return 1;
        if(dp[remRows][prevIdx] != -1)return dp[remRows][prevIdx];
        long long ans = 0;
        for(int i = 0; i < 12; i++){
            if(check(list[i], list[prevIdx]))
            ans = (ans + solve(remRows-1, i)) % mod;
        }
        return dp[remRows][prevIdx] = (int)ans;
    }
    int numOfWays(int n) {
        long long ans = 0;
        dp.assign(n, vector<int>(12, -1));
        for(int i = 0; i < 12; i++){
            ans = (ans + solve(n-1, i)) % mod;
        }
        return (int)ans;
    }
};
