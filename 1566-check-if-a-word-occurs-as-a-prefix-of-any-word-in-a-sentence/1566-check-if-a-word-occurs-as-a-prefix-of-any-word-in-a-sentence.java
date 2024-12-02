class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String arr[] = sentence.split(" ");
int i=0;
        for(String s : arr){
            i++;
            if(s.contains(searchWord)){
                int len =searchWord.length();
                String k =s.substring(0,len);
                if(k.equals(searchWord))return i;
            }
        }
        return -1;
    }
}