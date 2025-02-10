class Solution {
    public String clearDigits(String s) {
        int idx=-1;
        int n=s.length();
int count=0;
        String str="";
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
        if(c>='0'&&c<='9'){str=str.substring(0,str.length()-1);
                           count++;}
            else
                str+=c;
        }
        if(count==0)return s;
        
      return str;
        
       
       
       
    }
}