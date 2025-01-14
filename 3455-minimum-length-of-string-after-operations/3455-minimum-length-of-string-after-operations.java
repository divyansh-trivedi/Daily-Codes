class Solution {
    public int minimumLength(String s) {
       int ar[] = new int[26];
       for(int i=0;i<s.length();i++){
        ar[s.charAt(i)-'a']++;
       }
       int c = 0;
       for(int i=0;i<26;i++){
           if(ar[i]>=3){
            if(ar[i]%2==0) c+= (ar[i]-2);
            else c+= (ar[i]-1);
           }
       }
       return s.length()-c;
    }
}