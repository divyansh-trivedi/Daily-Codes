class Solution {
public:
    int countPalindromicSubsequence(string s) {
        int n = s.size();
        vector<int> first(26, -1), last(26, -1);
        for(int i = 0; i < n; i++){
            int c = s[i] - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }
        int cnt = 0;
        for(int c = 0; c < 26; c++){
            if(first[c] != -1 && last[c] != -1 && last[c] - first[c] > 1){
                unordered_set<char> st;
                for(int i = first[c] + 1; i < last[c]; i++){
                    st.insert(s[i]);
                }
                cnt += st.size();
            }
        }
        return cnt;
    }
};

 
/* 


wrong approach ----------------------
 left to right tarverse kro

 [a, a, b, c, a]
 mp [a[0] , a[1], b[2]]
 i = 3 -> start kro
 agar mile to - kro 
 aur sum me add kro

[b, b, c, b, a, b, a]
mp[b[0],c[2]]
i = 3 -> cnt += 3-0-1 = cnt  = 2 => update map [[b[3],c[0]] // b[0] -> b[3]
i = 4 -> X => => update map [[b[5],c[0],a[4]] add 'a'
i = 5 -> cnt = 2+1 = 3; => update map [[b[5],c[0],,a[4]] // b[3] - >b[5]
 i =6 ->  cnt = 3+1 = 4 =>  update map [[b[5],c[0],,a[6]] // b[3] - >b[5]


 right ->
 take first and last vec and store the first and last occurence of this
 ans then traverse use set to store uniques

 */