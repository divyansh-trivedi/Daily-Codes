class Solution {
    public int minCost(String colors, int[] neededTime) {
        int cnt = 0;
        int prev = neededTime[0]; 
        for(int i=1;i<colors.length();i++){
            if(colors.charAt(i)==colors.charAt(i - 1)){
                cnt += Math.min(prev,neededTime[i]); 
                prev = Math.max(prev,neededTime[i]); 
            }else
                prev = neededTime[i];
        }
        return cnt;
    }
}
