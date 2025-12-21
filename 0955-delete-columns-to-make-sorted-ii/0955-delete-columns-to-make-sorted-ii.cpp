class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        int n = strs.size(), m = strs[0].size();
        vector<bool> sorted(n, false);
        int cnt = 0;
        
        for(int j = 0; j < m; j++) {
            bool deleted = false;
            for (int i = 1; i < n; i++) {
                if (!sorted[i] && strs[i][j] < strs[i-1][j]) {
                    deleted = true;
                    break;
                }
            }
            if(deleted){
                cnt++;
                continue;
            }

            for (int i = 1; i < n; i++) {
                if (strs[i][j] > strs[i-1][j]) {
                    sorted[i] = true;
                }
            }
        }
        return cnt;
    }
};
/* for every string call for recursion -> solve()
what to do in that solve() =>
perform a pick not pickj 
2^100 -> wont work too large 

[
    x c
    x a
    y b
    z a
]
["z y x",
 "w v u",
 "t s r"]
 
 edge case -:
 may be greater string be next to smaller string (in length terms)
 so for that use flag if element exist and after that -1 exist then removal would be that row + next rows
 */