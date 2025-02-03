class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int decMax = 0;
        int incMax = 0;

        int incCount = 0, decCount = 0;

       for(int j = 0; j < nums.length -1; j++){
            if(nums[j] < nums[j + 1]){
                incCount++;
                decCount = 0;
            }
            else if(nums[j] > nums[j + 1]){
                decCount++;    
                incCount = 0;
            }
            else{
                incCount = 0;
                decCount = 0;
            }

            if(incCount > incMax)
                    incMax = incCount;

            if(decCount > decMax)
                    decMax = decCount;
       }

        return Integer.max(incMax + 1,decMax + 1);
    }
}