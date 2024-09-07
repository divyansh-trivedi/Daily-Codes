class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int max=Integer.MIN_VALUE;

       int min=prices[0];
       for(int i=1;i<n;i++){
         int dif=prices[i]-min;
         max=Math.max(max,dif);
         min=Math.min(min,prices[i]);
       }
       if(max<=0)
       return 0;
       return max;
    }
}