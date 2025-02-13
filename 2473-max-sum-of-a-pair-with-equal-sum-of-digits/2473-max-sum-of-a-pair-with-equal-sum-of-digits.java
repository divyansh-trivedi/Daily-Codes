class Solution {
    int sumDigits(int n){
        int ans =0;
        while(n>0){
            ans+=n%10;
            n=n/10;
        }
        return ans;
    }
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans=-1;
        for(int i =0;i<nums.length;i++){
            int sum = sumDigits(nums[i]);
            if(map.containsKey(sum)){
                ans = Math.max(ans, nums[i]+map.get(sum));
                map.put(sum,Math.max(map.get(sum), nums[i]));
            }else map.put(sum, nums[i]);
        }
        return ans;

    }
}