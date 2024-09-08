class Solution {
    public long findMaximumScore(List<Integer> A) {
        long res=0;
        long max=0;

        for(int i:A){
            res+=max;
            max=Math.max(max,i);
        }
        return res;
    }
}