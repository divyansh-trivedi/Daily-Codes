class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int nextChair=0;
        int targetStart = times[targetFriend][0];

        Arrays.sort(times, (a,b)->a[0] - b[0]);
        PriorityQueue<int []> leave = new PriorityQueue<>((a,b)->a[0] - b[0]);
        PriorityQueue<Integer> avail = new PriorityQueue<>();

        for(int [] time : times){
            int start = time[0];
            int end = time[1];
            
            while(!leave.isEmpty() && leave.peek()[0] <= start)
              avail.add(leave.poll()[1]);

              int sat;
              if(!avail.isEmpty())
              sat = avail.poll();
              else
              sat=nextChair++;

              leave.add(new int[]{end ,sat});
              if(start==targetStart) 
              return sat;
        }

        return -1;


         
    }
}