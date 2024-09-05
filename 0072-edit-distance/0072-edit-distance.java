import java.util.*;
class Solution {
    public int solve(int dp[][],String word1,String word2, int i, int j){
        // BASE CASES
        if(i>=word1.length())return  word2.length()-j;

        if(j>=word2.length()) return word1.length()-i;
        
        if(dp[i][j]!=-1)return dp[i][j];
       

        if(word1.charAt(i)==word2.charAt(j))
        return dp[i][j] =solve (dp,word1, word2, i+1, j+1);
      
        int update=1+solve(dp,word1,word2, i+1, j+1);
        int delete=1+solve(dp,word1, word2, i+1,j);
        int replace= 1+solve(dp,word1, word2,i, j+1);

        return dp[i][j]= Math.min(update, Math.min(delete,replace));
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length();int m=word2.length();
        int dp[][]= new int[n+1][m+1];
for(int row[]:dp)
Arrays.fill(row,-1);

    return solve (dp,word1, word2, 0,0);
    }
}