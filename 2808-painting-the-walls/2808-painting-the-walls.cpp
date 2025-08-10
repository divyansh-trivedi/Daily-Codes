class Solution {
public:
    int n;
    int paintWalls(vector<int>& cost, vector<int>& time) {
         n =  cost.size();
         vector<vector<int>> dp(n+1,vector<int>(n+1,-1));
         return solve(n,0, cost, time, dp);
    }
private:
    int solve(int remain, int idx, vector<int>& cost, vector<int>& time,vector<vector<int>>& dp){
        if(remain<=0)return 0;
        if(idx >= n)return 1e9;
        if(dp[idx][remain] != -1)return dp[idx][remain];

        int p = cost[idx] + solve(remain-1-time[idx], idx+1, cost, time, dp);
       // pick me remaining kya hoga -: 
       // remain -1 qki ek to paid painter ne kr di 
       // minus(-) time[idx] , qki jitna time rhega usme free painter apna kam kr dega 
        int np = solve(remain, idx+1, cost, time, dp);

        return dp[idx][remain] = min(p, np);
    }
};