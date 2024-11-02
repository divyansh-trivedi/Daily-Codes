class Solution {
    public boolean isCircularSentence(String sentence) {
        int n=sentence.length();
        
        char last=sentence.charAt(n-1);
        for(String wrd:sentence.split(" ")){
            char first=wrd.charAt(0);            
            if(first!=last){
                return false;
            }
            last=wrd.charAt(wrd.length()-1);
        }
        
        return true;        
    }

}