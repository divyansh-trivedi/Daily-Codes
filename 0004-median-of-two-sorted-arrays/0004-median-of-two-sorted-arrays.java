import java.util.*;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

      int c=nums1.length + nums2. length;
      int[] num= new int[c];
      
      for(int i=0;i<nums1.length;i++)
      {
        num[i]=nums1[i];
    
      }
            for(int i=nums1.length, j=0;i<c;i++,j++)
      {
        num[i]=nums2[j];
      }
      Arrays.sort(num);
     
      if(c%2==0)
     return (double)( num[(c/2)]+num[(c/2)-1] )/2;
     else
  return (double )num[(c/2)];

    }
}