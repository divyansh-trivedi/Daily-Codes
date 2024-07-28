class Solution {
    public boolean checkPrime(int n){
           int sqrt=(int)Math.sqrt(n);
        if(n<=1)return false;
        if(n==3||n==2)return true;
        if(n%2==0||n%3==0)return false;
        for(int i=5;i<=sqrt;i++){
            if(n%i==0)return false;
        }
        return true;
    }
    public int nonSpecialCount(int l, int r) {
        // int sqrt=(int)Math.sqrt(r);

          int l2=(int)Math.ceil(Math.sqrt(l));
          int r2=(int)Math.floor(Math.sqrt(r));
int count=0;//for special
          while(l2<=r2){
            if(checkPrime(l2)){
count++;

            }
l2++;
          }
          return (r+1-l)-count;

    }
}