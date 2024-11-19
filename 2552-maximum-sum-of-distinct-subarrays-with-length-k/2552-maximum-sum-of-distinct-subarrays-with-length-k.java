class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer ,Integer> map = new HashMap<>();
        long sum=0,max=0;
        int j=0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            
            if(i-j+1==k){
                if(map.size()==k)max=Math.max(max,sum);
            sum-=nums[j];
            map.put(nums[j],map.get(nums[j])-1);
            if(map.get(nums[j])==0)map.remove(nums[j]);

            j++;

        }
    }
    return max;
    }
}