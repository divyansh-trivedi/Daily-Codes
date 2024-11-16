class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        int ar[]= new int[n-k+1];
        for(int i=0;i<=n-k;i++){
            int c=0;
            int ele=nums[i + k - 1];;
            for(int j=0;j<k-1;j++){
                if(nums[i+j]+1!=nums[i+j+1]){
           c++;
           ele=-1;
           break;
                }
              
            }
            ar[i]=ele;

        }
        return ar;
    }
}