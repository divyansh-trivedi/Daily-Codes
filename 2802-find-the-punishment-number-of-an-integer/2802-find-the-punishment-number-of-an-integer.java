class Solution {
    public int punishmentNumber(int n) {
        int sum =1;
        for(int i  = 2 ;i <= n;i++){
           int sq = i*i;
           if(isPossible(String.valueOf(sq), 0 , 0 ,i))
           sum += sq;
        }
        return sum;
    }
    private boolean isPossible(String s , int currSum , int idx ,int num ){
        if(idx == s.length())
        return currSum == num;

        if(currSum > num)return false;
        boolean possible = false;

        for(int i = idx; i< s.length();i++){
            String sub = s.substring(idx , i + 1);
        
            int val = (sub=="")?0: Integer.parseInt(sub);

            possible = possible || isPossible(s, currSum+val ,i+1 , num);

            if(possible == true)return possible;
        }
        return possible;
    }
}