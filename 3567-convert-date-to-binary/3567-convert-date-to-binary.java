import java.util.*;

class Solution {
    static String ans;
 public static void  decToBinary(int n){
    ans="";
    while(n>0){
        if((n&1)==1)
        ans=1+ans;
        else
        ans=0+ans;

        n=n>>1;
    }
    if(ans.isEmpty())
    ans="0";
    
 }
         public static String convertDateToBinary(String date) {
        
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        decToBinary(day);
        String dayBinary = ans;
   
        decToBinary(month);
        String monthBinary = ans;

        decToBinary(year);
        String yearBinary = ans;

        return yearBinary + "-" + monthBinary + "-" + dayBinary;
    
    }
}