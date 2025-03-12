class Solution {
    public int maximumCount(int[] nums) {
        return  Math.max((int)Arrays.stream(nums).filter(it-> it>0).count()
        ,(int)Arrays.stream(nums).filter(it-> it<0).count());
    }
}