class Solution {
    public static void swap(int nums[],int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void sortColors(int[] nums) {
       int n=nums.length;
    //    int k=n/3;
    //    int idx=0;
    //    for(int i=idx;i<k;i++)
    //    nums[i]=0;
    //    idx+=k;
    //     for(int i=idx;i<k+k;i++)
    //    nums[i]=1;
    //    idx+=k;
    //     for(int i=idx;i<k+k+k;i++)
    //    nums[i]=2;

     /*------ Dutch National Flag Algo. ---------*/
      int low=0, mid=0, high=n-1;
      while(mid<=high){
        if(nums[mid]==0){
            swap(nums,mid, low);
            mid++;
            low++;
        }
        else if(nums[mid]==1)mid++;
        else{
            swap(nums,mid, high);
            high--;
            
        }
      }
    }
}