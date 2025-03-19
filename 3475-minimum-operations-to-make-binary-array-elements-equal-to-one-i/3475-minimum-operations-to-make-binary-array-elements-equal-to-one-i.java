class Solution {
    public int minOperations(int[] nums) {
       int n=nums.length;
        int count=0;
 
        for(int i=0;i<n-2;i++){
            if(nums[i]==1)
                continue;
            count++;
            
            for(int j=i;j<i+3;j++){
                if(nums[j]==0)
                    nums[j]=1;
                else
                    nums[j]=0;
                
            }
        }
        
       int flag=0;
        for(int i:nums){
            if(i==0)
                flag ++;
        }
        if(flag==0)
            return count;
        return -1;
    }
}