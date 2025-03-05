class Solution {
    public long coloredCells(int a) {
        // if(n==1)return 1;
        long n=a;
        
        return (long)n*n + (long)(n-1)*(n-1);
    }
}