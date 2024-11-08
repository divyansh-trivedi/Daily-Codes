class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n=nums.length;
        int arr[]=new int[n];
        int b=(1<<maximumBit)-1;
        int a=0;
        for(int i=0;i<n;i++){
            a=a^nums[i];
        }
        for(int i=n-1;i>=0;i--){
            arr[n-1-i]=a^b;
            a=a^nums[i];
        }
        return arr;
        
    }
}