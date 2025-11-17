class Solution {
string s;
int dp[10][2][2];
private:
    int solve(int i, bool tight ,set<int>& st,bool isValid){
        if(i == s.size())return isValid;
        if(dp[i][tight][isValid] != -1)return dp[i][tight][isValid];

        int limit = 9;
        if(tight)limit = s[i]-'0';

        int ans = 0;

        if(!isValid) ans += solve(i+1,false,st,false);

        for(int d: st){
            if(d > limit)continue;

            bool newTight = (limit == d )&& tight;
            ans += solve(i+1,newTight,st,true);
        }
        return  dp[i][tight][isValid] =ans;
    }
public:
    int atMostNGivenDigitSet(vector<string>& digits, int n) {
         s = to_string(n);

        set<int> st;
        for(string i:digits)st.insert(stoi(i));

        memset(dp,-1,sizeof(dp));
        return solve(0,1,st,0);
    }
};