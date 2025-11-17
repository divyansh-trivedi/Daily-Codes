class Solution {
string s1 , s2 ;
int mini , maxi ;
const int mod = 1e9+7;
int dp[23][401][2][2];
private:
    int solve(int i, int sum, bool tight1, bool tight2){
        if(sum > maxi)return 0;
        if(i == s1.size())return sum >= mini;

        if(dp[i][sum][tight1][tight2] != -1) return dp[i][sum][tight1][tight2];

        int low_limit = tight1 ? s1[i]-'0' : 0;
        int high_limit = tight2 ? s2[i]-'0' : 9;

        int ans = 0;
        for(int d = low_limit;d<=high_limit;d++){
            bool newTight1 = tight1 && (d == low_limit) ;
            bool newTight2 = tight2 && (d == high_limit);

            ans =  (ans+ solve(i+1,sum+d,newTight1,newTight2))%mod;
        }
        return dp[i][sum][tight1][tight2] = ans;
    }
public:
    int count(string num1, string num2, int min_sum, int max_sum) {
        s1= num1 , s2 = num2, mini = min_sum ,maxi = max_sum;

        while(s1.size() < s2.size()) s1 = "0"+s1;
        memset(dp, -1, sizeof(dp));
        return solve(0,0,true,true);
    }
};