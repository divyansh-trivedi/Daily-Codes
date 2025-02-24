class Solution {
public:
    bool isPali(string &s, int i, int j){
        while(i<j){
            if(s[i]!=s[j])return 0;
            i++;
            j--;
        }
        return 1;
    }
    int minCut(string s) {
        int n=s.size();
        vector<int> dp(n+1,0);

        for(int i=n-1;i>=0;i--){
            int mini = 1e9;
            for(int j=i;j<n;j++){
                if(isPali(s,i,j)){
                    int count = 1+dp[j+1];
                    mini = min(mini , count);
                }
            }
            dp[i] =  mini;
        }

        return dp[0]-1;
    }
};