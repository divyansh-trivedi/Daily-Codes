class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum  =0 ;
        long s1=0; 
        long s2=0;
        for(int i:nums)sum+=i;

        int cnt =0;
        for(int i=0;i<nums.length-1;i++){
            s1 += nums[i];
            s2 = sum -s1;
            if(s1>=s2)cnt++;
        }
        return cnt;
    }
}