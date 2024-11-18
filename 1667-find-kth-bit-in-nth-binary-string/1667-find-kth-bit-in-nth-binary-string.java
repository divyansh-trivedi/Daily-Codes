class Solution {
    public static String reverse(String s){
        StringBuilder str= new StringBuilder();
        for(char c:s.toCharArray())str.append(c=='1'?"0":"1");

        return str.reverse().toString();
 }
    public static String solve(int n){
        String ans="";
        if(n==0)
        return "0";
        else{
            String s=solve(n-1);
            ans+=s+"1"+reverse(s);
        }
        return ans;
    }
    public char findKthBit(int n, int k) {
        return solve(n).charAt(k-1);
    }
}