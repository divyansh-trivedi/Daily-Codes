class Solution {
public:
    int countCoveredBuildings(int n, vector<vector<int>>& buildings) {
        vector<int> minx(n+1, n+1);
        vector<int> miny(n+1, n+1);
        vector<int> maxx(n+1, 0);
        vector<int> maxy(n+1, 0);

        for(auto& it : buildings){
            int x = it[0];
            int y = it[1];
            minx[y] = min(minx[y], x);
            miny[x] = min(miny[x], y);
            maxx[y] = max(maxx[y], x);
            maxy[x] = max(maxy[x], y);
        }
        int cnt = 0;
        for(auto& it : buildings){
            int x = it[0];
            int y = it[1];
            if(minx[y] < x && x < maxx[y] && miny[x] < y && y < maxy[x])
                cnt++;
        }
        return cnt;
    }
};

/* 
solved but too much issues like long long instead of this another error is also comning so bad codeultimately-:

class Solution {
private:
    bool isPossible(unordered_map<int, vector<long long>>& col, unordered_map<int, vector<long long>>& row, int r, int c){
        if(col.find(c) == col.end() || row.find(r) == row.end()) return false;

        vector<long long> srow = row[r];
        vector<long long> scol = col[c];

        int left1 = 0, right1 = 0;
        int up = 0, down = 0;

        for (long long v : srow) {
            int nr = v / 100000;
            int nc = v % 100000;
            if (nc < c) left1++;
            else if (nc > c) right1++;
        }

        for (long long v : scol) {
            int nr = v / 100000;
            int nc = v % 100000;
            if (nr < r) up++;
            else if (nr > r) down++;
        }

        return left1 > 0 && right1 > 0 && up > 0 && down > 0;
    }

public:
    int countCoveredBuildings(int n, vector<vector<int>>& ar) {

        unordered_map<int, vector<long long>> col;
        unordered_map<int, vector<long long>> row;

        int m = ar.size();
        for(int i = 0; i < m; i++){
            int r = ar[i][0];
            int c = ar[i][1];
            long long x = 1LL * r * 100000 + c; 
            col[c].push_back(x);
            row[r].push_back(x);
        }

        int cnt = 0;
        for(auto& it : ar){
            if(isPossible(col, row, it[0], it[1])) cnt++;
        }
        return cnt;
    }
};

 */