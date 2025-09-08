class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        if(nums.empty())return 0;
        set<int> st(nums.begin(), nums.end()); 

       int maxLen = 0;
       for (int n : st) {
            if (st.find(n-1) == st.end()) {
                int current = n;
                int currentLen = 1;
                while(st.find(current+1) != st.end()) {
                    current++;
                    currentLen++;
                }
                maxLen =max(maxLen, currentLen);
            }
        }
        return maxLen;
    }
};