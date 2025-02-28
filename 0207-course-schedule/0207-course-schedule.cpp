#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool canFinish(int N, vector<vector<int>>& pre) {
        vector<vector<int>> adj(N); 

        for (auto it : pre)
            adj[it[0]].push_back(it[1]); 

        vector<int> indeg(N, 0);
        for (int i = 0; i < N; i++) {
            for (auto it : adj[i]) {
                indeg[it]++;
            }
        }

        queue<int> q;
        for (int i = 0; i < N; i++) {
            if (indeg[i] == 0)
                q.push(i);
        }

        int cnt = 0;
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            cnt++;

            for (int it : adj[node]) {
                indeg[it]--;
                if (indeg[it] == 0)
                    q.push(it);
            }
        }

        return cnt == N;
    }
};
