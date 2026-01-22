class Solution {
public:
    int minimumPairRemoval(vector<int>& nums) {
        int ans = 0;
        while(!is_sorted(nums.begin(), nums.end())) {
            int mn = 1e9, mnid = -1;
            for(int i=0; i<nums.size()-1; i++) {
                if(mn > nums[i] + nums[i+1]) {
                    mn = nums[i] + nums[i+1];
                    mnid = i;
                }
            }
            vector<int> a;
            for(int i=0; i<nums.size(); i++) {
                if(i == mnid) a.push_back(mn);
                else if(i == mnid + 1) {}
                else a.push_back(nums[i]);
            }
            nums = a;
            ans++;
        }
        return ans;
    }
};