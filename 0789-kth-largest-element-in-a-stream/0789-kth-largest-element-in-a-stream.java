class KthLargest {
PriorityQueue<Integer> ar=new PriorityQueue<>();
int res;

    public KthLargest(int k, int[] nums) {
       res=k;

       for(int i:nums){
        ar.add(i);
        if(ar.size()>res)
        ar.poll();
       }
    }
    
    public int add(int val) {
        ar.add(val);

        if(ar.size()>res)ar.poll();

        return ar.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */