class Solution {
int ans = 0;
private:
    long long dfs(int node, int parent, vector<vector<int>>& adj, vector<int>& values, int k){
        long long sum = values[node];
        for(int it : adj[node]){
            if(it != parent)
            sum += dfs(it, node, adj, values, k);
        }
        if(sum % k == 0)ans++;

        return sum;
    }
public:
    int maxKDivisibleComponents(int n, vector<vector<int>>& edges, vector<int>& values, int k) {
        vector<vector<int>> adj(n);
        for(auto &i : edges){
            adj[i[0]].push_back(i[1]);
            adj[i[1]].push_back(i[0]);
        }
        dfs(0, -1, adj, values, k);
        return ans;
    }
};