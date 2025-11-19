class NumArray {
public:
    int *segmentTree;
    int *arr;
    int n;
    NumArray(vector<int>& nums) {
        n = nums.size();
        segmentTree = new int[4*n];
        arr = new int[n];
        for(int i=0;i<n;i++)arr[i] = nums[i];

        buildSegmentTree(0, 0, n-1);
    }
    void buildSegmentTree(int i, int l, int r){
        if(l == r){
            segmentTree[i] = arr[l];
            return;
        }
        int mid = l+(r-l)/2;
        buildSegmentTree(2*i+1, l, mid);
        buildSegmentTree(2*i+2, mid+1, r);

        segmentTree[i] = segmentTree[2*i+1]+segmentTree[2*i+2];
    }
    
    void update(int index, int val) {
        real_update(index, val, 0, 0, n-1);
    }
    void real_update(int idx, int val, int i, int l, int r){
        if(l == r){
            arr[idx] = val;
            segmentTree[i] = val;
            return;
        }
        int mid = l + (r-l)/2;
        if(idx <= mid)
        real_update(idx, val, 2*i+1, l, mid);
        else
        real_update(idx, val, 2*i+2, mid+1, r);

        segmentTree[i] = segmentTree[2*i+1] + segmentTree[2*i+2];
    }
    
    int sumRange(int start, int end) {
        return real_sum(0, start, end, 0, n-1);
    }
    int real_sum(int i, int start, int end, int l, int r){
        if(l > end || r < start)return 0;
        if(l >= start && r <= end)return segmentTree[i];

        int mid = l + (r-l)/2;
        return real_sum(2*i+1, start, end, l, mid) + real_sum(2*i+2, start, end, mid+1, r);
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * obj->update(index,val);
 * int param_2 = obj->sumRange(left,right);
 */