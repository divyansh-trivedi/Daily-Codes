class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        long minNeg = Integer.MAX_VALUE;
        int n = matrix.length;
        int cntNeg=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sum+=Math.abs(matrix[i][j]);
                if(matrix[i][j]<0)cntNeg++;
                minNeg=Math.min(minNeg,Math.abs(matrix[i][j]));
            }
        }

        if(cntNeg%2!=0)
        sum-=2*minNeg;

        return sum;

    }
}