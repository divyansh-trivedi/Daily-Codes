#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minOperations(string s, int k) 
    {   
        int n = s.size();
        int zeros = 0;
        for (char c : s) if (c == '0') zeros++;

        if (zeros == 0) return 0;

        set<int> unv[2];
        for (int i = 0; i <= n; i++) 
        {
            if (i != zeros) 
            {
                unv[i % 2].insert(i);
            }
        }

        queue<pair<int,int>> q;
        q.push({zeros, 0});

        while (!q.empty()) 
        {
            auto [z, dist] = q.front();
            q.pop();

            int xmin = max(0, k - (n - z));
            int xmax = min(k, z);
            if (xmin > xmax) continue;

            int L = z + k - 2 * xmax;
            int U = z + k - 2 * xmin;
            if (L > U) swap(L, U);

            int p = (z + k) % 2;
            auto it = unv[p].lower_bound(L);

            while (it != unv[p].end() && *it <= U) 
            {
                int nz = *it;
                if (nz == 0) 
                {
                    return dist + 1;
                }
                q.push({nz, dist + 1});
                auto eraseIt = it++;
                unv[p].erase(eraseIt);
            }
        }
        return -1;
    }
};