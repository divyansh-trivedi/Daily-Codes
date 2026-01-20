class Solution {
    int n, m;
    int dp[501][501];
private:
    int solve(vector<int>& nums1, vector<int>& nums2, int i, int j){
        if(i == n || j == m)
        return -1e8;

        if(dp[i][j] != -1)return dp[i][j];
        int take = nums1[i]*nums2[j];
        int take_i_j = nums1[i]*nums2[j] + solve(nums1, nums2, i+1, j+1);
        int take_i = solve(nums1, nums2, i, j+1);
        int take_j = solve(nums1, nums2, i+1, j);
        
        return dp[i][j] = max({take, take_i_j, take_i, take_j});
    }
public:
    int maxDotProduct(vector<int>& nums1, vector<int>& nums2) {
        n = nums1.size();
        m = nums2.size();
        
        memset(dp, -1 , sizeof(dp));

        return solve(nums1, nums2, 0, 0);
    }
};