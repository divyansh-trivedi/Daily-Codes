class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n,1), hash(n);
        sort(nums.begin(), nums.end());
        int maxi = 1, lastIdx = 0;

        for(int idx =0;idx<n;idx++){
            hash[idx] = idx;
            for(int prev =0;prev<idx;prev++){
                if(nums[idx] % nums[prev] == 0 && dp[prev]+1 > dp[idx]){
                    dp[idx] = dp[prev] +1;
                    hash[idx] = prev;
                }
            }
            if(maxi < dp[idx]){
                maxi = dp[idx];
                lastIdx = idx;
            }
        }
        cout << "DP Array: ";
        for(int i = 0; i < n; i++)
            cout << dp[i] << " ";
        cout << endl;
        vector<int> temp;
        temp.push_back(nums[lastIdx]);
        while(lastIdx != hash[lastIdx]){
            lastIdx = hash[lastIdx];
            temp.push_back(nums[lastIdx]);
        }
        reverse(temp.begin(), temp.end());
        return temp;
    }
};