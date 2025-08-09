class Solution {
public:
    vector<int> occurrencesOfElement(vector<int>& nums, vector<int>& queries, int x) {
        vector<int> pos;
        for (int i = 0; i < nums.size(); ++i)
            if (nums[i] == x)
                pos.push_back(i);

        vector<int> ans;
        for (int q : queries)
            ans.push_back(q <= pos.size() ? pos[q - 1] : -1);

        return ans;
    }
};