class Solution {
    public int nthUglyNumber(int n) {
          PriorityQueue<Long>pq=new PriorityQueue<>();
        pq.offer(1L);
        Set<Long> set=new HashSet<>();
        set.add(1L);
        int a[]={2,3,5};
        for(int i=1;i<n;i++){
            long c=pq.poll();
            for(int k:a){
                long v=c*k;
                if(!set.contains(v)){
                    set.add(v);
                    pq.offer(v);
                }
            }
        }
        System.out.println(pq);
        long t=pq.poll();
        return (int)t;
        //return a.get(n-1);
    }
}