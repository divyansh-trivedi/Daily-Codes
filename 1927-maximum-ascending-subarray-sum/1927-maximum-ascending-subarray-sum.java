class Solution {
    public int maxAscendingSum(int[] nums) {
        int check=0;
        int res=0;
        int fres=0;
        for(int i=0;i<nums.length;i++){
            if(check<nums[i]){
                res+=nums[i];
                check=nums[i];
                fres=Math.max(fres,res);
            }else{
                check=nums[i];
                res=0;
                res+=nums[i];
            }
        }
        return fres;
    }
}