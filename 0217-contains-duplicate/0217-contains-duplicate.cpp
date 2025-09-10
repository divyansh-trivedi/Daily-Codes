class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_set<int> st;

        for(int i: nums)st.insert(i);
        
        return !(st.size() == nums.size());
    }
};