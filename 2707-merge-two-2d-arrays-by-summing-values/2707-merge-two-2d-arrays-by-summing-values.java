class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        int res[]=new int[1001];
        int uniq=0;
        for(int i=0;i<nums1.length;i++){
            if(res[nums1[i][0]]==0)uniq++;
            res[nums1[i][0]]+=nums1[i][1];
        }

        for(int i=0;i<nums2.length;i++){
            if(res[nums2[i][0]]==0)uniq++;
            res[nums2[i][0]]+=nums2[i][1];     
        }

        int[][] result=new int[uniq][2];
        int j=0;
        for(int i=0;i<=1000;i++){
            if(res[i]!=0){
                result[j][0]=i;
                result[j++][1]=res[i];

            }
        }
        return result;
    }
}