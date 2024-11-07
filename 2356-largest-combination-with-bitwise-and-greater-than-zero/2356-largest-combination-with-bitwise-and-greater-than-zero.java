class Solution {
    public int largestCombination(int[] nums) {
        int bits[]=new int[32];
        int j=0;
        for(int i:nums){
            j=0;
            while(i>0){
                bits[j++]+=i&1;
                i=i>>1;
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i:bits) max=Math.max(max,i);
        return max;
    }
}