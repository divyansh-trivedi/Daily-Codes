class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
      int i=0, j=0;
      
        if(str1.length()<str2.length()) return false;

      while(i<str1.length()&& j<str2.length()){
        if(str1.charAt(i)==str2.charAt(j))j++;
        else {
            char right =(char)('a' + (str1.charAt(i)-'a'+1)%26);
            if(right == str2.charAt(j))
                j++; 
        }
        i++;
      }
     return  j==str2.length();
    }
}