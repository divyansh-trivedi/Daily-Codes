class Solution {
public:
    int countPartitions(vector<int>& nums) {
        int sum = accumulate(nums.begin(), nums.end(), 0);
        int n = nums.size(), curr = 0, cnt = 0;
        for(int i=0; i<n-1; i++){
            curr += nums[i];
            int rem = sum - curr;
            if(abs(rem - curr)%2 == 0)
            cnt++;
        }
        return cnt;
    }
};