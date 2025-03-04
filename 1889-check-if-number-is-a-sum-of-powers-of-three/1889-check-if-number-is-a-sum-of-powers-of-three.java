class Solution {
    public boolean solve(int n , int ar[] , int idx, int curr){
        if(curr == n)return true;
        if(idx >15)return false;

        boolean pick = solve(n,ar,idx+1,curr+((int)Math.pow(3,ar[idx])));
        boolean npick = solve(n , ar , idx+1, curr);

        return pick || npick;
    }
    public boolean checkPowersOfThree(int n) {
        int ar[]={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};

       return solve(n , ar,0,0);
         
    }
}