class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n,1) , hash(n,1);
        sort(nums.begin(),nums.end());
        int maxi = 1;
        int idx =-1;
        for(int i=0;i<n;i++){
            hash[i] = i;
            for(int prev=0;prev<i;prev++){
                if(nums[i]%nums[prev] == 0 && dp[prev]+1 > dp[i] ){
                    dp[i] = dp[prev]+1;
                    hash[i]= prev;
                }
            }
            if(idx == -1 || dp[i]>maxi){
                maxi = dp[i];
                idx = i;
            } 
        }
        vector<int> temp;
        temp.push_back(nums[idx]);
        while(hash[idx] != idx){
            idx =  hash[idx];
            temp.push_back(nums[idx]);
        }
        reverse(temp.begin(),temp.end());
        return temp;
    }
};