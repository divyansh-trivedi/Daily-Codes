class Solution {
    public boolean canChange(String start, String target) {
       int cnt1=0;
       for(int i:start.toCharArray()){
        if(i!='_')cnt1++;
       }
       for(int i:target.toCharArray()){
        if(i!='_')cnt1--;
       }
        if(cnt1!=0)return false;
        
        int i=0, j=0;
           
        while(i<start.length()&&j<target.length()){

            while(i<start.length()&& start.charAt(i)=='_')i++;
            while(j<target.length()&& target.charAt(j)=='_')j++;

            if(i==start.length() || j==target.length())
            return start.length()==i&&target.length()==j;

            
            char c1 = start.charAt(i);
            char c2 = target.charAt(j);
            

            if(c1!=c2)return false;
            else if(c1=='L'&&i<j)return false;
            else if(c2=='R'&&i>j)return  false;

            i++;
            j++;

        }
        return true;
    }
}