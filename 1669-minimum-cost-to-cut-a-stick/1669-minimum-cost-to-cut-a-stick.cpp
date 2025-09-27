class Solution {
private:
    int solve(vector<int>& cuts, int l, int r, vector<vector<int>>& dp) {
        if (r - l < 2) return 0; // no cut possible if less than 2 apart
        if (dp[l][r] != -1) return dp[l][r];

        int mini = 1e9;
        for (int idx = l + 1; idx <= r - 1; idx++) {
            int cost = (cuts[r] - cuts[l]) + solve(cuts, l, idx, dp) + solve(cuts, idx, r, dp);
            mini = min(mini, cost);
        }
        return dp[l][r] = mini;
    }

public:
    int minCost(int n, vector<int>& cuts) {
        cuts.push_back(0);
        cuts.push_back(n);
        sort(cuts.begin(), cuts.end());

        int m = cuts.size();
        vector<vector<int>> dp(m, vector<int>(m, -1));

        return solve(cuts, 0, m - 1, dp);
    }
};
