class Solution {
private:
    static bool comp(string& a, string& b){
        return a.size() < b.size();
    }
private:
    bool isValid(string& a, string& b){
        if(b.size() != a.size()-1)return false;
        int i=0,j=0;

        while(i<a.size()){
            if(j<b.size() && a[i] == b[j]){
                i++;j++;
            }else i++;
        }
        return j == b.size();
    }
public:
    int longestStrChain(vector<string>& words) {
        int n = words.size();
        vector<int> dp(n,1);
        sort(words.begin(),words.end(),comp);
        int maxi = 1;
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(isValid(words[i],words[prev]) && dp[prev]+1 > dp[i])
                    dp[i] = dp[prev]+1;
            }
            maxi = max(dp[i],maxi);
        }
        return maxi;
     }
};