class Solution {
    public int maxScore(String s) {
        int maxscore=0;
        for(int i=0;i<s.length()-1;++i){
            int leftscore = s.substring(0,i+1).replace("1","").length();
            int rightscore = s.substring(i+1).replace("0","").length();
            maxscore = Math.max(maxscore , leftscore+rightscore);
        }
        return maxscore;
    }
}