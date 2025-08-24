class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int len = 0;
        boolean flag = false;
        while(right < nums.length){
            if(nums[right] == 0 && !flag){
                flag = true;
                right++;
            }
            else if(nums[right] == 0 && flag){
                len = Math.max(len,right - left -1);
                while(nums[left] != 0){
                    left++;
                }
                left++;
                flag = false;
            }else{
                right++;
            }
        }
        len = Math.max(len,right - left -1);
        return len;
    }
}