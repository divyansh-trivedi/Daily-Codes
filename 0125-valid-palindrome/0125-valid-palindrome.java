import java.util.*;
class Solution {
    public boolean isPalindrome(String s) {
        String t="";
                        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
                        if(Character.isLetterOrDigit(c))  
                            t=t+c;
                        }
        t=t.toLowerCase();
        int i=0;
        int j=t.length()-1;
        while(i<j){
         if(t.charAt(i)!=t.charAt(j))
             return false;
            i++;
            j--;
        }
        return true;
    }
}