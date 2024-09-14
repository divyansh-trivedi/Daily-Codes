class Solution {
    public int longestSubarray(int[] nums) {
     int len=1;
     int max=(int)-1e9;
     for(int i:nums)
     max=Math.max(max,i);

     int temp=0;
     for(int i:nums){
        if(i==max)temp++;
        else{
            len=Math.max(len,temp);
            temp=0;
        }
     }   
     len =Math.max(len,temp);
     return len;
    }
}