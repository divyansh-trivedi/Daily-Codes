class Solution {
        int getGCD(int x, int y){
            if(x==0) return y;
            return getGCD(y % x,x);
        }

    public String fractionAddition(String expression) {
        int num =0;
        int demo = 1;

        String[] sn = expression.split("/|(?=[-+])");

        for(int i = 0; i<sn.length; i+=2){
            int currNum = Integer.valueOf(sn[i]);
            int currDemo  = Integer.valueOf(sn[i+1]);

            num = num*currDemo + currNum * demo;
            demo = currDemo * demo;
        }
        int gcd  = Math.abs(getGCD(num, demo));

        num /= gcd;
        demo /= gcd;

        return(num+ "/" + demo);
    }
}