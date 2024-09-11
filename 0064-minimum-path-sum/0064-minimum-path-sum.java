import java.util.*;
class Solution {
 
    public int minPathSum(int[][] ar) {
         int m=ar.length;
         int n=ar[0].length;
      int prev[]= new int[n];
     
       for(int i=0;i<m;i++){
        int curr[]= new int[n];
       
        for(int j=0;j<n;j++){
            if(i==0&&j==0)curr[j]=ar[0][0];
        
            else{
                int up=ar[i][j],left=ar[i][j];
                // requires previous row's j coloumn
                if(i>0)up+=prev[j];
                else up+=1e9;
                // requires current row's j-1 coloumn
                if(j>0)left+=curr[j-1];
                else
                left+=1e9;
                curr[j]=Math.min(up,left);
            }
            
        }
        prev=curr;
        
       }
       return prev[n-1];
    }
}