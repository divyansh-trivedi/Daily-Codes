class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int [][]k=new int[m+1][n+1];
        int max=0;
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(nums1[i-1]==nums2[j-1]){
                    k[i][j]=k[i-1][j-1]+1;
                    max=Math.max(max,k[i][j]);
            }else{
                k[i][j]=0;
            }
            }
        }
        return max;
    }
}