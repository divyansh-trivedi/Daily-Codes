class Solution {
    public int solve(String num, char first, char flag){
        String ans ="";
        
        for(char c:num.toCharArray()){
            if(c == first)
                ans += flag;
            else
                ans += c;
        }
       return Integer.parseInt(ans);
    }
    public int maxDiff(int num) {
       String number  = String.valueOf(num);
       char first = 'a';
       int n= number.length();

       int i=0;
       while(i<n){
        if(number.charAt(i) == '9')
        i++;
        else{
            first = number.charAt(i);
            break;
        }
       }
       int a = num;
       if(first != 'a')
        a = solve(number, first ,'9');

        first ='a';
        i=0;
            while(i<n){
                if(number.charAt(i) != '0' && number.charAt(i) != '1'){
                    first = number.charAt(i);
                    break;
                }
                i++;
            }   
       int b = num;
       if(first != 'a')
       b = solve(number, first , (number.charAt(0) != '1') ? '1' : '0');

       return a-b;
    }
}