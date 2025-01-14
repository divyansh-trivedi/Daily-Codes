class Solution {
    public boolean canBeValid(String s, String locked) {
        int n= s.length(), open =0 , close =0;

        if(n%2==1)return false;
        for(int i=0;i<n;i++){
            open += locked.charAt(i)=='1' && s.charAt(i)==')' ? -1:1;
            close += locked.charAt(n-i-1)=='1' && s.charAt(n-i-1)=='(' ? -1:1;

            if(close < 0 || open <0)return false;

        }
        return true;
    }
}


