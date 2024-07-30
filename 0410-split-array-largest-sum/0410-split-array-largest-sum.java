class Solution {
    int count(int ar[], int max){
        int count=1;
        int sum=ar[0];

        for(int i=1;i<ar.length;i++){
            sum+=ar[i];
            if(sum>max){
                sum=ar[i];
                count++;
            }

        }
        return count;
    }
    public int splitArray(int[] nums, int k) {
        if(k>nums.length)return -1;
        int max=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            max=Math.max(max,nums[i]);
        }
        int low=max;
        int high=sum;

        while(low<=high){
            int mid=(low+high)/2;
            int x=count(nums, mid);

            if(x>k)
            low=mid+1;
            else
            high=mid-1;

        }
        return low;
    }
}