class Solution {
    public int minSteps(int n) {
        if (n==1 )
            return 0;
 int ans=0;
         int fact=2;
         while(n>1){
            while(n%fact==0){
             ans+=fact;
             n/=fact;
            }
            fact++;
         }  
        return ans;
    }
} 