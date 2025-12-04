class Solution {
public:
    int countTrapezoids(vector<vector<int>>& points) {
        int n = points.size();
        unordered_map<float,vector<float>> slopeIntercepts;

        unordered_map<int,vector<float>> midPointMap;
        int res = 0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int dx = x2 - x1;
                int dy = y2 - y1;

                float slope, intercept;
                if(x1 == x2){// dx = 0
                    slope = 1e9+7;
                    intercept = x1;
                }else{
                    slope = (float)(y2-y1)/(x2-x1);
                    intercept = (float)(y1*dx - x1*dy)/dx;
                }

                int midPoint = (x1+x2)*10000 + (y1+y2);
                slopeIntercepts[slope].push_back(intercept);
                midPointMap[midPoint].push_back(slope);
            }
        }

        for(auto &it : slopeIntercepts){
            map<float, int> mp;
            for(float intercept : it.second)
            mp[intercept]++;

            int prevHL = 0;
            for(auto &it : mp){
                int cnt = it.second;
                res += cnt*prevHL; //  counting with duplicates i.e. parallelogram sides too
                prevHL += cnt;
            }
        }
        for(auto &it : midPointMap){
            map<float, int> mp;
            for(float intercept : it.second)
            mp[intercept]++;

            int prevHL = 0;
            for(auto &it : mp){
                int cnt = it.second;
                res -= cnt*prevHL; //  counting with duplicates i.e. parallelogram sides too
                prevHL += cnt;
            }
        }
        return res;
    }
};

// to understand watch the yt CSWM
