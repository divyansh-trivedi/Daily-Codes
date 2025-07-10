class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int n = s.length();
        if(n == 0)return 0;

        boolean neg = false;
        long ans = 0;
        int  i = 0;
        if(s.charAt(0) == '-'){
            neg = true;
            i++;
        }
        if(s.charAt(0) == '+'){
            i++;  
        }
        for( ;i<n;i++){
            char ch =  s.charAt(i);
            if(ch >= '0'&& ch <= '9'){ 
                ans = ans * 10 + (ch - '0');
                if(neg == true && (ans*-1) <=Integer.MIN_VALUE)return Integer.MIN_VALUE;
                if(!neg && ans >= Integer.MAX_VALUE )return Integer.MAX_VALUE;
            }
            else  
                break;
        }
        if(neg) ans = -ans;
        return (int)ans;
    }
}