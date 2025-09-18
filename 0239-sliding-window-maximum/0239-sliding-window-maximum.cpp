class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int> ans;
        deque<int> dq;
        int n = nums.size();

        for(int i=0;i<n;i++){
            if(!dq.empty() && dq.front() <= i-k)dq.pop_front(); // ye dekhta hai ki out of index wale element na rhe

            while(!dq.empty() && nums[dq.back()] <= nums[i])dq.pop_back();// ye monotonic deque(or priority queue) banne ka try kr rhe
            dq.push_back(i);//pushing index

            if(i >= k-1)ans.push_back(nums[dq.front()]);// store result AS front me ans hai
        }
        return ans;
    
    }
};