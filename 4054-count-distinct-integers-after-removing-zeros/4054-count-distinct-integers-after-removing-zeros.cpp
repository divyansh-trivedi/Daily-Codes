

class Solution {
    string s;
    long long dp[20][2][2];
private:
    long long solve(int i, bool tight , bool started){
        if(i == s.size())return started;

        if(dp[i][tight][started] != -1)return dp[i][tight][started];

        int limit = 9;
        if(tight)limit = s[i]-'0';
        
        long long ans = 0;
        for(int d = 0;d <= limit;d++){
            bool  newTight = false;

            if(limit == d)newTight = tight;

            if(d == 0 && started == 0)ans += solve(i+1,newTight,false);
            else{
                if(d == 0) continue; 
                ans += solve(i+1,newTight,true);
            }
        }
        return dp[i][tight][started] = ans;

    }
public:
    long long countDistinct(long long n) {
        s = to_string(n);
        memset(dp,-1,sizeof(dp));
        return solve(0,1,0);
    }
};

/* 
brute force -:

    n = 10
    1 2 3 4 5 6 7 8 9 1


    o(n^2) -> for(1 to 100) -> 100*3
    o(n^2) -> for(1 to  10^15) -> 10^15 * 16*10


for( 1 to  n)-:
    16

1 to 9 -> 0
10-> 99 ->9
100 - 999 ->

greedy smjh nhi aya
-> digit dp best
     */