import java.util.*;
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int n=words.length;
        int m=allowed.length();
        Set<Character> set= new HashSet<>();

        for(int i=0;i<m;i++)set.add(allowed.charAt(i));
int c=0;
        for(int i=0;i<n;i++){
            String s= words[i];
            for(int j=0;j<s.length();j++){
                char ct=s.charAt(j);
                if(!set.contains(ct)) break;
                if(j==s.length()-1)
                c++;


            }
        }
        return c;
    }
}