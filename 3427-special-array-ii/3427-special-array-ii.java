class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
       int prefix [] = new int[nums.length];
       Arrays.fill(prefix ,0);
        boolean even = true;
        if(nums[0]%2!=0) even = false;

        prefix[0] =1;
        for(int i=1;i<nums.length;i++){
            if(even == true && nums[i]%2!=0){
            prefix[i] += prefix[i-1]+1;
            even =false;
            }
            else if(even ==false && nums[i]%2==0){
             prefix[i] += prefix[i-1]+1;
            even =true;
            }
            else{
                even = nums[i]%2==0 ? true :false;
                prefix[i] =1;
            }
        }

        boolean ans[] = new boolean[queries.length];

        for(int i=0;i<queries.length;i++){
            int start = queries[i][0];
            int end = queries[i][1];

            int length =end-start+1;
            if(prefix[end]>=length||start==end)
            ans[i]=true;
            else
            ans[i]=false;
        }
        return ans;
    }
}