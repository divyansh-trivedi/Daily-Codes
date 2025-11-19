class Solution {
private:
    void buildSegmentTree(int i, int segmentTree[], vector<int>& arr, int l, int r){
        if(l == r){
            segmentTree[i] = l;
            return;
        }
        int mid = l + (r-l)/2;
        buildSegmentTree(2*i+1, segmentTree, arr, l, mid);
        buildSegmentTree(2*i+2, segmentTree, arr, mid+1, r);

        int leftIdx = segmentTree[2*i+1];
        int rightIdx = segmentTree[2*i+2];

        segmentTree[i] = (arr[leftIdx] > arr[rightIdx] ? leftIdx : rightIdx);
    }
private:
    int RMIQ(int i, int segmentTree[], vector<int>& arr, int l, int r, int start, int end){
        if(l > end || r < start)return -1;
        if(l >= start && r <= end)return segmentTree[i];

        int mid = l + (r-l)/2;
        int leftIdx = RMIQ(2*i+1, segmentTree, arr, l, mid, start, end);
        int rightIdx = RMIQ(2*i+2, segmentTree, arr, mid+1, r, start, end);

        if(leftIdx == -1)return rightIdx;
        if(rightIdx == -1)return leftIdx;
        
        return (arr[leftIdx] > arr[rightIdx]) ? leftIdx : rightIdx;
    }
public:
    vector<int> leftmostBuildingQueries(vector<int>& arr, vector<vector<int>>& queries) {
        int n = arr.size();
    
        int *segmentTree = new int[4*n];

        buildSegmentTree(0, segmentTree, arr, 0, n-1);

        vector<int> result;
        for(auto &it : queries){
            int alice = min(it[0],it[1]);
            int bob = max(it[0],it[1]);

            if(alice == bob || arr[bob] > arr[alice]){
                result.push_back(bob);
                continue;
            }

            int l = bob+1;
            int r = n-1;
            int result_idx = INT_MAX;
            while(l <= r){
                int mid = l + (r-l)/2;
                int idx = RMIQ(0, segmentTree, arr, 0, n-1, l, mid);

                if(arr[idx] > max(arr[alice], arr[bob])){
                    result_idx = min(result_idx, idx); 
                    r = mid-1;
                }else l = mid+1;
            }
            result.push_back((result_idx == INT_MAX)?-1:result_idx);
        }
        return result;
    }
};
