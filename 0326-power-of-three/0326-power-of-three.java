class Solution {
    public boolean isPowerOfThree(int n) {
        if(n==1)return true;
        if(n==2 || n==0 )return false;

        if(n%3!=0)return false;

        boolean res = isPowerOfThree(n/3);

        return res;
    }
}