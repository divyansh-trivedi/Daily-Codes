class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        // int c=matrix[0].length;
        for(int i=0;i<(n+1)/2;i++){
            for(int j=0;j<n/2;j++){
                int t=matrix[i][j];
                matrix[i][j]=matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-1-i][n-j-1];
                matrix[n-1-i][n-j-1]=matrix[j][n-1-i];
                matrix[j][n-1-i]=t;
                
            }
        }
    }
}