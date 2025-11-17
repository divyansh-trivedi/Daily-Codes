class Solution {
string s;
int dp[10][2][10];
private :
    int solve(int i,bool tight,int cnt1){
        if(i == s.size())return cnt1;

        if(dp[i][tight][cnt1] != -1)return dp[i][tight][cnt1];
        int limit = 9;
        if(tight)limit = s[i] - '0';

        int ans= 0;
        for(int d =0;d<=limit;d++){

            bool newTight = ((d == limit) && tight); 
            int newCnt1 = (d == 1) ? cnt1 +1 : cnt1;

            ans += solve(i+1,newTight , newCnt1);
        }
        return dp[i][tight][cnt1] = ans;
    }
public:
    int countDigitOne(int n) {
        s = to_string(n);
        memset(dp,-1,sizeof(dp));
        return solve(0,1,0);
    }
};

/* 13
1
10
11
12
13

_ _ 
0 (0,1)
1 (0,1,2,3)


same dp digit technqiue logic 
tight and cnt1 */

