class Solution {
public:
    vector<bool> prefixesDivBy5(vector<int>& nums) {
        vector<bool> ans;
        int sum = 0;
        int n = nums.size();
        for(int i=0; i<n; i++){
            sum = (sum*2 + nums[i])%5
            ;
            ans.push_back((sum % 5 == 0) ? true : false);
        }
        return ans;
    }
};