class Solution {
public:
    int countPaths(int n, vector<vector<int>>& roads) {
        const int MOD = 1e9 + 7;
        vector<vector<pair<int, int>>> adj(n);

        for (auto& it : roads) {
            adj[it[0]].push_back({it[1], it[2]});
            adj[it[1]].push_back({it[0], it[2]});
        }

        priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<pair<long long, int>>> pq;
        pq.push({0, 0});

        vector<long long> dist(n, LLONG_MAX);
        vector<int> ways(n, 0);

        dist[0] = 0;
        ways[0] = 1;

        while (!pq.empty()) {
            long long dis = pq.top().first;
            int node = pq.top().second;
            pq.pop();

            if (dis > dist[node]) continue;

            for (auto& it : adj[node]) {
                int adjNode = it.first;
                int edgW = it.second;

                if (dis + edgW < dist[adjNode]) {
                    dist[adjNode] = dis + edgW;
                    ways[adjNode] = ways[node];
                    pq.push({dist[adjNode], adjNode});
                } else if (dis + edgW == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
};
