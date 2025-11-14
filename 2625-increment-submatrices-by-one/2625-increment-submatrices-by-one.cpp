class Solution {
public:
    vector<vector<int>> rangeAddQueries(int n, vector<vector<int>>& queries) {
        vector<vector<int>> ans(n,vector<int>(n,0));

        for(auto& it :  queries){
            for(int i=it[0];i<=it[2];i++){
                for(int j=it[1];j<=it[3];j++)
                    ans[i][j] += 1;
            }
        }
        return ans;
    }
};


/* 
1 1 0
1 2 1
0 1 1


[[1,1,2,2],[0,0,1,1]]

o(n) > 10^8
o(nlog(n)) >10^4 && <=10^8
o(n^2) <=10^4 */