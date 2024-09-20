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
       if (count_zero > 1) {
                // If there are two or more zeros, every element should be 0
                ar[i] = 0;
            } else if (nums[i] == 0) {
                // If there's exactly one zero, place the product at the zero's position
                ar[i] = prod;
            } else if (count_zero == 0) {
                // If there are no zeros, divide the total product by the current element
                ar[i] = prod / nums[i];
            } else {
                // For all non-zero elements when there is exactly one zero, the result is 0
                ar[i] = 0;
            }
       }

       return ar; 
    }
}