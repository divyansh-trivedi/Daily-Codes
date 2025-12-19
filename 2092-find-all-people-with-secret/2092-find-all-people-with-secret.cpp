class Solution {
public:
    vector<int> findAllPeople(int n, vector<vector<int>>& meetings, int firstPerson) {
        vector<bool> know(n, false);
        know[0] = know[firstPerson] = true;

        sort(meetings.begin(), meetings.end(),
             [](auto &a, auto &b) { return a[2] < b[2]; });

        for (int i = 0; i < meetings.size();) {
            unordered_map<int, vector<int>> g;
            unordered_set<int> seen;
            int t = meetings[i][2];

            while (i < meetings.size() && meetings[i][2] == t) {
                g[meetings[i][0]].push_back(meetings[i][1]);
                g[meetings[i][1]].push_back(meetings[i][0]);
                seen.insert(meetings[i][0]);
                seen.insert(meetings[i][1]);
                i++;
            }

            queue<int> q;
            for (int p : seen)
                if (know[p]) q.push(p);

            while (!q.empty()) {
                int u = q.front(); q.pop();
                for (int v : g[u])
                    if (!know[v]) know[v] = true, q.push(v);
            }
        }

        vector<int> ans;
        for (int i = 0; i < n; i++)
            if (know[i]) ans.push_back(i);
        return ans;
    }
};