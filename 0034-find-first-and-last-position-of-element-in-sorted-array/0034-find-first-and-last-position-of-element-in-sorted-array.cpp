class Solution {
private:
    int solve1(vector<int>& nums, int target){
        int low =0 , high = nums.size()-1;
        int first=-1;

        while(low<=high){
            int mid = (high+low)/2;
            if(nums[mid] == target){
                first = mid;
                high =mid-1;
            }else if(nums[mid] > target) 
                high = mid-1;
            else low = mid+1;
        }
        return first;
    }
private:
    int solve2(vector<int>& nums, int target){
        int low =0 , high = nums.size()-1;
        int last=-1;

        while(low<=high){
            int mid = (high+low)/2;
            if(nums[mid] == target){
                last = mid;
                low =mid+1;
            }else if(nums[mid] > target) 
                high = mid-1;
            else low = mid+1;
        }
        return last;
    }
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int first = solve1(nums, target);
        int last = solve2(nums, target);

        if(first == -1)return {-1,-1};
        return {first,last};
    }
};