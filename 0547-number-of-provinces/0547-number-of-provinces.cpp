class Solution {
private:
    void dfs(int node ,vector<vector<int>> &isConnected,vector<bool> &visited){
        visited[node] = true;
        int idx =0;
        for(int i : isConnected[node]){
            if(i ==1 && !visited[idx])
            dfs(idx, isConnected, visited);
             idx++;
        }
        
    }
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        int cnt =0;
        int n = isConnected.size();
        vector<bool> visited(n , false);
        for(int i=0;i<n;i++){
            if(!visited[i]){
                cnt++;
                dfs(i,isConnected , visited);
            }
        }
       return cnt;
    }
};