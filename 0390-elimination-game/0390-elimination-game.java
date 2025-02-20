class Solution {
    public int lastRemaining(int n) {
        if(n==1)return 1;

        int ans = 2* ((n/2+1) - lastRemaining(n/2));
        return ans ;
    }
}