class Solution {
    public String makeFancyString(String s) {
        char prev=s.charAt(0);
        int c=1;
        StringBuilder str= new StringBuilder();
        str.append(prev);
        for(int i=1;i<s.length();i++){
            char curr=s.charAt(i);
           if(curr==prev)c++;
           else {
            prev=curr ;
            c=1;
           }

           if(c>=3)
           continue;
           str.append(curr);
        }
        return str.toString();
    }
}