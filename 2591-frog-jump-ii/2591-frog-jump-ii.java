class Solution {
    public int maxJump(int[] ar) {
         int n=ar.length;
         if(n==2)return ar[1];
         int max=0;
         for(int i=0;i<n-2;i++)
            max=Math.max(max, ar[i+2]-ar[i]);
         
        return max;
    }
}