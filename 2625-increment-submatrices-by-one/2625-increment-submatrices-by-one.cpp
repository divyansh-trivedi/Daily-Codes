class Solution {
public:
    vector<vector<int>> rangeAddQueries(int n, vector<vector<int>>& queries) {
        vector<vector<int>> ans(n,vector<int>(n,0));

        for(auto& it : queries){
            int r1 = it[0] , c1 = it[1] , r2 = it[2] , c2 = it[3];

            for(int i=r1;i<=r2;i++){
                ans[i][c1] += 1;
                if(c2+1 < n)
                ans[i][c2+1] -= 1;
            } 
        }

        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                ans[i][j] += ans[i][j-1];
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

[1,1->2,2]

o(n) > 10^8
o(nlog(n)) >10^4 && <=10^8
o(n^2) <=10^4 


Array difference technique 1-d -:

queries = [[1,1,2,2],[0,0,1,1]]

1 1 0 0
1 2 1 0
0 1 1 0
0 0 0 0

[1,1,2,2] ->  r1 = 1, c1 =1 , r2 =2, c2=2


for(int i=r1;i<=r2;i++){
    ans[i][c1] += 1;
    if(c2+1 < n)
    ans[i][c2+1] = -1;
}

1 0 -1 0   => 1 1 0 0
1 1 -1 -1     1 2 1 0
0 1 0 -1      0 1 1 0
0 0 0 0       0 0 0 0

[1,1,2,2] ->  r1 = 1, c1 =1 
              r2 =2 , c2=2

[0,0,1,1] ->  r1 = 0, c1 =0 
              r2 =1 , c2=1
*/