class Solution {
    public int solve(int ar[], int i, int k){
        for(int j=0;j<k-1;j++){
          if(ar[i+j]!=ar[i+j+1]-1)return -1;
        }

        return ar[i+k-1];
    }
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        int ar[]= new int [n-k+1];
        for(int i=0;i<=n-k;i++){
            ar[i]=solve(nums,i,k);
        }
        return ar;
    }
}