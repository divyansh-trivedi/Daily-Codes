class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long i : nums)
        pq.add(i);
        int steps =0;
        while(pq.size()>=2&&pq.peek()<k){
            long first = pq.poll();
            long second = pq.poll();
            steps++;
            pq.offer(Math.min(first,second)*2 + Math.max(first, second));
            
        }
        // while (!pq.isEmpty() && pq.peek() < k) {
        //     steps++;
        //     pq.poll();
        // }
        return steps;
    }
}