class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
     int[]dp1=new int[nums.length];
        int[]dp2=new int[nums.length];
        int []pp=new int[nums.length];
        int s=0;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                pp[i]=nums[i];
            }
            else pp[i]=pp[i-1]+nums[i];
              s+=nums[i];
            if(i<k){
             dp1[i]=s;
             
            }
            else{
                s-=nums[i-k];
                dp1[i]=Math.max(dp1[i-1],s);

            }
        }
        s=0;
           for(int i=nums.length-1;i>=0;i--){
              s+=nums[i];
            if(nums.length-i<=k){
             dp2[i]=s;
            
            }
            else{
                s-=nums[i+k];
                
                    dp2[i]=Math.max(dp2[i+1],s);
                  
                
                
            }
        }
        int ms=-1;
         int msi=-1;
         int l=-1;
         int r=-1;
        for(int i=k;i<=nums.length-2*k;i++){
            if(ms<dp1[i-1]+pp[i+k-1]-pp[i-1]+dp2[i+k]){
                ms=dp1[i-1]+pp[i+k-1]-pp[i-1]+dp2[i+k];
                l=dp1[i-1];
                r=dp2[i+k];
                msi=i;
            }

        }
        int[] ans=new int[3];
        ans[1]=msi;
        for(int i=k-1;i<msi;i++){
            if(pp[i]-(i-k<0?0:pp[i-k])==l){
                ans[0]=i-k+1;
                break;
            }
            
        }
        for(int i=msi+2*k-1;i<dp1.length;i++){
            if(pp[i]-pp[i-k]==r){
                ans[2]=i-k+1;
             break;
            }
            
        }
return ans;
    }
}