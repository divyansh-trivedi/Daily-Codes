class Solution {
public:
    long long solve(vector<int>& power, int ind, vector<long long>& dp) {
        int n = power.size();
        if (ind >= n) return 0;
        if (dp[ind] != -1) return dp[ind];

        int val = power[ind];
        long long total = 0;
        int i = ind;

        while (i < n && power[i] == val) {
            total += power[i];
            i++;
        }
        
        int nextIndex = upper_bound(power.begin(), power.end(), val + 2) - power.begin();

        // take option
        long long take = total + solve(power, nextIndex, dp);
        // skip option
        long long notTake = solve(power, i, dp);

        return dp[ind] = max(take, notTake);
    }

    long long maximumTotalDamage(vector<int>& power) {
        sort(power.begin(), power.end());
        vector<long long> dp(power.size(), -1);
        return solve(power, 0, dp);
    }
};