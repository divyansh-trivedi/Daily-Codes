class Solution {
    public boolean canArrange(int[] ar, int k) {
       int fre[]= new int[k];

       for(int i=0;i<ar.length;i++){
        int rem=((ar[i]%k)+k)%k;
        
        fre[rem]++;
       }

       if(fre[0]%2!=0)return false;

       for(int i=1;i<=k/2;i++){
        if(fre[i]!=fre[k-i])
        return false;

       }
return true;

    }
}
