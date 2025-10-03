class Solution {
public:
    int trapRainWater(vector<vector<int>>& ht) {
        int n = ht.size() , m =ht[0].size();
        typedef pair<int,pair<int,int>> pp;
        priority_queue<pp,vector<pp> ,greater<pp>> pq;// stores boundary cells
        vector<vector<bool>> vis(n,vector<bool>(m,false));

        for(int row = 0;row<n;row++){//push 0th and (n-1)th row
            for(int col : {0,m-1}){
                pq.push({ht[row][col],{row,col}}); 
                vis[row][col] = true;
            }
        }
        for(int col = 0;col<m;col++){//push 0th and (m-1)th col
            for(int row : {0,n-1}){
                pq.push({ht[row][col],{row,col}}); 
                vis[row][col] = true;
            }
        }
        int water = 0;
        while(!pq.empty()){
         auto rem= pq.top();
            pq.pop();
            int height =rem.first; 
            int r =rem.second.first; 
            int c =rem.second.second;

            int dx[] = {-1,0,1,0};  
            int dy[] = {0,1,0,-1};

            for(int k=0;k<4;k++){
                int newr = r+dx[k];
                int newc = c+dy[k];
                
                if(newr < 0 || newc < 0 || newr >= n || newc >= m)continue;
                if(!vis[newr][newc]){
                    water += max(height - ht[newr][newc], 0);
                    pq.push({max(height,ht[newr][newc]),{newr,newc}});
                    vis[newr][newc] = true;
                }
            }  
        }
        return water;
    }
};