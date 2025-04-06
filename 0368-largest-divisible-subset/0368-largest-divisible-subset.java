class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        Arrays.sort(arr);
        int max =1 , n = arr.length;
        int lastIndex =0;
        int dp[] =  new int[n];
        Arrays.fill(dp,1);
        int hash[] = new int[n];
        for(int i=0;i<n;i++){
            hash[i] = i;
            for(int prev=0;prev<i;prev++){ 
                if(arr[i]%arr[prev] == 0 && 1+dp[prev] > dp[i]){
                    dp[i] = 1+ dp[prev];
                    hash[i] = prev;
             } 
             if(dp[i]>max){
                max = dp[i];
                lastIndex = i;
             }
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(arr[lastIndex]);
        while(hash[lastIndex]!=lastIndex){
            lastIndex = hash[lastIndex];
            list.add(arr[lastIndex]);
        }
        Collections.reverse(list);
        return list;
    }
}