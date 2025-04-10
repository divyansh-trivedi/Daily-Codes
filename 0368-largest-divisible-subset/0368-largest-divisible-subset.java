class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int hash[] = new int[n];

        int max =1 , lastIndex = 0;
        for(int i=1;i<n;i++){
            hash[i] = i;
            for(int j=0;j<i;j++){
                if(nums[i] %nums[j] == 0 && dp[j]+1 > dp[i]){
                    dp[i] = dp[j]+1;
                    hash[i] = j;
                }
            }
            if(dp[i] > max){
                max = dp[i];
                lastIndex = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        
        list.add(nums[lastIndex]);

        while(lastIndex != hash[lastIndex]){
            lastIndex = hash[lastIndex];
            list.add(nums[lastIndex]);
        }
        Collections.reverse(list);
        return list;
    }
}