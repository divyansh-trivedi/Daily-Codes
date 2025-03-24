class Solution {
    public int countDays(int days, int[][] ar) {
         Arrays.sort(ar,(a,b)->a[0]-b[0]);

         int cnt =0;
         int prevEnd =0;

         for(int i[]: ar){
            int start = i[0];
            int end = i[1];
            if(start > prevEnd)
                cnt += start - prevEnd -1;
             prevEnd = Math.max(end, prevEnd);
         }
         cnt +=  Math.max(days - prevEnd , 0);
         return cnt;

    }
}