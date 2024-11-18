class Solution {
    public int[] decrypt(int[] code, int k) {
        int n=code.length;
        int ar[]= new int[n*2];
        for(int i=0;i<n*2;i++){
            if(i==0)
            ar[i]=code[i];
            else
            ar[i]=code[i%n]+ar[i-1];   
        }
int arr[]= new int[n];
        for(int i=0;i<n;i++){
            if(k==0)arr[i]=0;
            else if(k>0)
            arr[i]=ar[i+k]-ar[i];
            else 
            arr[i] = ar[i+n-1]-ar[i+n+k-1];
        }   
        return arr;
    }
}