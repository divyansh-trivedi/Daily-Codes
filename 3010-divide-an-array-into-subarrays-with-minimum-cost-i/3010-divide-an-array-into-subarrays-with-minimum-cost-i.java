import java.util.*;
class Solution {
    public int minimumCost(int[] nums) {
        int sum=nums[0];
        if(nums.length==3)
           return nums[1]+nums[0]+nums[2];
        else{
            
            Arrays.sort(nums);
            
            if(nums[0]==sum)
              return sum+nums[2]+nums[1];
             if(nums[1]==sum)
               return sum+nums[0]+nums[2];
             if(nums[2]==sum)
                 return sum+nums[0]+nums[1];
           
           
         
                 return sum+nums[0]+nums[1];
            
        }
        
    }
}