class Solution {
public:
    vector<int> occurrencesOfElement(vector<int>& nums, vector<int>& queries, int x) {
        vector<int> idx;

        for(int i=0;i<nums.size();i++){
            if(nums[i] == x)
            idx.push_back(i);
        }

        vector<int> temp;
        for(int i: queries)
            temp.push_back(i>idx.size() ? -1 : idx[i-1]);

        return temp;
    }
};