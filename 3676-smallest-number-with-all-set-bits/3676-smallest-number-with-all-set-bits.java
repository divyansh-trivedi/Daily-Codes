class Solution {
    public int smallestNumber(int n) {
        String s = Integer.toBinaryString(n);
        String str="";
       
       for(int i=0;i<s.length();i++)
           str+="1";
         

        return Integer.parseInt(str,2);
    }
}