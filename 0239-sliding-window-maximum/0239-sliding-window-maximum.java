class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int r=0;
        int ar[]= new int[n-k+1];
         
        Deque<Integer> dq= new ArrayDeque<>();

        for(int i=0;i<n;i++){

           if(!dq.isEmpty()&&dq.peek()==i-k)dq.poll();

            while(!dq.isEmpty()&&nums[dq.peekLast()]<nums[i])
            dq.pollLast();
           
            dq.offer(i);
            if(i>=k-1)
            ar[r++]=nums[dq.peek()];


        }

       
        return ar;
    }
}