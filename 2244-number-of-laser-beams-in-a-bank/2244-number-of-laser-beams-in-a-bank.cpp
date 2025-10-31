class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
            int n=bank.size();
            int prev_count_one=0;
            int ans=0;
            for(string s:bank){
                int curr_one=count(s.begin(),s.end(),'1');
                if(curr_one==0)continue;
               ans+=(prev_count_one*curr_one);
               prev_count_one=curr_one;
            }
            return ans;
    }
};