class Solution {
    public int minSubarray(int[] nums, int p) {
     long ts=0;
     for(int i:nums)ts+=i;

     int rem=(int)(ts%p);
     if(rem==0)return 0;

     HashMap<Integer,Integer> prefixMod= new HashMap<>();
     prefixMod.put(0,-1);
     long prefixSum=0;
     int min=nums.length;
     for(int i=0;i<nums.length;i++){
        prefixSum+=nums[i];
        int curr=(int)(prefixSum%p);
        int target=(curr-rem+p)%p;

        if(prefixMod.containsKey(target))
        min=Math.min(min,i-prefixMod.get(target));


        prefixMod.put(curr,i);


     }

     return min==nums.length?-1:min;

    }
}