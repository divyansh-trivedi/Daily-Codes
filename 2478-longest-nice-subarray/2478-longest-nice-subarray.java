class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, prev = 0, maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            while ((prev & nums[right]) != 0) {  
                prev ^= nums[left];  
                left++;  
            }
            prev |= nums[right];  
            maxLen = Math.max(maxLen, right - left + 1);  
        }

        return maxLen;
    }
}
