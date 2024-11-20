class Solution {
    public int takeCharacters(String s, int k) {
        // first take base cases
        int n=s.length();
        int a,b,c;
        a=b=c=0;
        int res=0;
         for(char ch:s.toCharArray()){
           if(ch=='a')a++;
           if(ch=='b')b++;
           if(ch=='c')c++;
        }
        if(a<k || b<k || c<k)
        return -1;
       int i=0,j=0;
       while(j<n){
        char ch=s.charAt(j);
        if(ch=='a')a--;
           if(ch=='b')b--;
           if(ch=='c')c--;
           while(i<=j && (a<k||b<k||c<k)){
            if(s.charAt(i)=='a')a++;
            if(s.charAt(i)=='b')b++;
            if(s.charAt(i)=='c')c++;
            i++;
           }
           res=Math.max(res, j-i+1);
           j++;
       }
       return n-res;

    }
        
}