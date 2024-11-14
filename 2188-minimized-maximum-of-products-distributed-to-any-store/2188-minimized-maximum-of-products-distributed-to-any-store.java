class Solution {
    boolean isDivisible(int mid , int ar[], int k){
        int c=0;
      for(int i=0;i<ar.length;i++){
        c+=Math.ceil((double)ar[i]/mid); 
      }
      if(c<=k)return true;
      else return false;
    }
    public int minimizedMaximum(int k, int[] arr) {
        int max=-(int)1e9;

        for(int i=0;i<arr.length;i++)max=Math.max(max,arr[i]);

        int low=1;
        int high=max;
        
        int res=0;
        while(low<=high){
            int mid=(low+high)/2;
            boolean check=isDivisible(mid, arr, k);
            if(check==true){
                res=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return res;
        
        
    }
}