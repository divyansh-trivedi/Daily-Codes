//JAI SHREE RAM
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;

        long prefix[] = new long[n + 1];

        for (int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] + nums[i];
        
      Deque<Integer> dq= new ArrayDeque<>();

      for(int i=0;i<n+1;i++){

        while(!dq.isEmpty() && prefix[i]-prefix[dq.peek()] >=k)//when increase
        res=Math.min(res, i-dq.poll());

        while(!dq.isEmpty()&& prefix[i] <= prefix[dq.peekLast()])// when shrink 
        dq.pollLast();

        dq.add(i);
      }

      return res<=n?res:-1;
    }
}