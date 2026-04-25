class Solution {
public:
    bool valid (int len, int side, vector<long long>& points, int k) {
        int n = points.size();
        vector<int> next(n);

        for (int i = 0, j = 0; i < n; i++) {
            j = max(j, i+1);

            while (j < n && points[i] + len > points[j]) {
                j++;
            }

            next[i] = j;
        }

        for (int i = 0; i < n; i++) {
            int steps = 1;
            int j = i;

            while (steps < k) {
                j = next[j];

                if (j == n || points[i] + 4LL*side - points[j] < len) {
                    steps = 0;
                    break;
                }

                steps++;
            }

            if (steps == k) {
                return true;
            }
        }

        return false;
    }

    long long compress (int &side, vector<int> &p) {
        int x = p[0];
        int y = p[1];

        if (x == 0) {
            return y;
        } else if (y == side) {
            return side + x;
        } else if (x == side) {
            return 3LL*side - y;
        }

        return 4LL*side - x;
    } 

    int maxDistance(int side, vector<vector<int>>& points, int k) {
        int n = points.size();
        vector<long long> arr;

        for (int i = 0; i < n; i++) {
            arr.push_back(compress(side, points[i]));
        }

        sort(arr.begin(), arr.end());

        int left = 0;
        int right = 4LL*side/k;
        int res = 0;

        while (left <= right) {
            int mid = left + (right-left)/2;

            if (valid(mid, side, arr, k)) {
                res = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        return res;
    }
};