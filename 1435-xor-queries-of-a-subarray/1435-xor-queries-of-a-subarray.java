class Solution {
    public int[] xorQueries(int[] arr, int[][] q) {
        int[] ans = new int[q.length];
        int[] prefix= new int[arr.length];

        prefix[0]=arr[0];
        for(int i=1;i<arr.length;i++)
        prefix[i]=prefix[i-1]^arr[i];

        for(int i=0;i<q.length;i++){
            int left=q[i][0];
             int right=q[i][1];

             if(left==0)ans[i]=prefix[right];
             else ans[i]=prefix[right]^prefix[left-1];
        }
        return ans;
    }
}