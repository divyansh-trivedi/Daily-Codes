class Solution {
    public int singleNonDuplicate(int[] nums) {
        int ans=0;
        int low=0, high= nums.length;
        int n=nums.length-1;
        if(n==0)return nums[0];
if(nums[0]!=nums[1])return nums[0];
if(nums[n]!=nums[n-1])return nums[n];
low=low+1;
high=high-1;// see the code for better understanding
       while(low<=high){
        int mid=low+high;
        mid=mid/2;
        if(nums[mid]!=nums[mid+1]&& nums[mid]!=nums[mid-1])
return nums[mid];
else if((mid%2==0&& nums[mid]==nums[mid-1])|| (mid%2==1&&nums[mid]==nums[mid+1]))
high=mid-1;// eliminate the right half
else
low=mid+1;// else the left one

       }
       return -1;
    }
}