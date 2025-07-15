class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int m = endTime.length;

        ArrayList<Integer> free = new ArrayList<>();
        free.add(startTime[0]);
        for(int i = 1 ;i < n; i++){
            free.add(startTime[i] - endTime[i-1]);
        }
        free.add(eventTime - endTime[endTime.length -1]);
        
        int i =0 , j = 0;
        int maxSum = 0 , currSum =0;

        while(j<free.size()){
            currSum += free.get(j);
            if(i<n && j-i+1 > k+1){
                currSum -= free.get(i);
                i++;
            }
            maxSum = Math.max(maxSum, currSum);
            j++;
        }
        return maxSum;
    }
}