class Solution {
public:
    int t[1001][1001];
    bool solve(string &s , int i, int j){
        if(i>=j)return 1;

        if(t[i][j] != -1)return t[i][j];

        if(s[i] == s[j])return t[i][j] = solve(s, i+1 ,j-1);

        return t[i][j] = 0;
 
    }
    string longestPalindrome(string s) {
        int n = s.length();
        memset(t, -1 ,sizeof(t));
        int maxLen = 1;
        int sp =0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(solve(s, i, j) == true && j - i + 1 > maxLen){
                    sp = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substr(sp , maxLen);
    }
};