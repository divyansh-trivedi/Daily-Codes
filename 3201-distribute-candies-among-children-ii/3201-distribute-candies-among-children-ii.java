class Solution {
    public long distributeCandies(int choco, int l) {
        long ans =0;

        for(long i = Math.max(0, choco-2*l);i<=Math.min(choco,l);i++){
            long yStart= Math.max(0, choco-i-l);
            long yEnd= Math.min(choco-i, l);

            if(yStart <= yEnd){
                long range = yEnd -yStart +1;
                ans += range;
            }
        }
        return ans;
    }
}