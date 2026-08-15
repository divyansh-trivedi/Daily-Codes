class Solution {
public:
    int longestSubsequence(vector<int>& nums) {
         int n = nums.size();
        
        int xr = 0;
        for(int i : nums)xr ^= i;
        if(xr != 0)return n;
        for (int i = 0; i < n; i++) {
            if((xr^nums[i]) != 0)
                return n - 1;
        }
        return  0;
    }
};