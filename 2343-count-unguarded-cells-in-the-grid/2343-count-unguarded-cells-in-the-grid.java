class Solution {
     public void solve(int m, int n , int ar[][]){
        //UP
        for(int i=m-1;i>=0;i--){
            if(ar[i][n] ==2 || ar[i][n]==3)break;
            ar[i][n]=1;
        }
        //DOWN
        for(int i=m+1;i<ar.length;i++){
            if(ar[i][n] ==2 || ar[i][n]==3)break;
            ar[i][n]=1;
        }
        //LEFT
        for(int i=n-1;i>=0;i--){
             if(ar[m][i] ==2 || ar[m][i]==3)break;
            ar[m][i]=1;
        }
         //RIGHT
        for(int i=n+1;i<ar[0].length;i++){
             if(ar[m][i] ==2 || ar[m][i]==3)break;
            ar[m][i]=1;
        }

     }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int ar[][]= new int[m][n];

        for(int i[]:ar)
        Arrays.fill(i,0);

        for(int i[]:guards) ar[i[0]][i[1]]=2;
        
        for(int i[]:walls) ar[i[0]][i[1]]=3;
        
        for(int i[]:guards)
        solve(i[0],i[1],ar);

        int c=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(ar[i][j]==0)c++;
            }
        }
        return c;

    }
}