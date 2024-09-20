class Solution {
    public int[] productExceptSelf(int[] nums) {
       int prod=1;
       int count_zero=0;
       for(int i:nums){
        if(i!=0)prod*=i;
        else count_zero++;
        }

       int ar[]= new int[nums.length];
       for(int i=0;i<nums.length;i++){
        if(count_zero>1)
        ar[i]=0;
        else if(nums[i]==0)
        ar[i]=prod;
        else if(count_zero==0)
        ar[i]=prod/nums[i];
        else
        ar[i]=0;
       }

       return ar; 
    }
}