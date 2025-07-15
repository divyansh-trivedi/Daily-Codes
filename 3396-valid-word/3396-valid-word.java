class Solution {
    public boolean isValid(String word) {
        boolean flag= true;
        if(word.length()<3)
            return false;
        int vowel=0, consonant=0;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(c=='@'||c=='#' || c=='$')
               return false;
            
            if(c=='a' || c=='e'|| c=='i'|| c=='o'|| c=='u' ||  c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
          vowel++;
                
            }
            else if(c>='0' && c<='9')
                continue;
            else 
                consonant++;
            
        }
        if(vowel==0 || consonant ==0){
            return false;
        }
        
       return true;
        
    }
}