class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        for(int i=0;i<n-k+1;i++){
         
            int ele=nums[i+k-1];// subaaray ka last assign kr do
            for(int j=i;j<i+k-1;j++){
                if(nums[j+1]-nums[j]!=1){
                    ele = -1;
                    break;
                }
                }
                res[i]=ele;
            }
        
        return res;
    }
}